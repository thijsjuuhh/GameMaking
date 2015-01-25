package com.thijsjuuhh.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.thijsjuuhh.game.entity.mob.Player;
import com.thijsjuuhh.game.grapics.Screen;
import com.thijsjuuhh.game.input.Keyboard;
import com.thijsjuuhh.game.input.Mouse;
import com.thijsjuuhh.game.level.Level;
import com.thijsjuuhh.game.level.TileCoordinate;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static final String TITLE = "Game";

	private Level level;

	BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	int[] pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();

	static JFrame frame;
	Screen screen;
	Thread thread;
	boolean running = false;
	Keyboard key;
	Player player;

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		level = Level.spawn;
		TileCoordinate ps = new TileCoordinate(19, 52);
		player = new Player(ps.x(), ps.y(), key);
		player.init(level);

		Mouse mouse = new Mouse();

		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}

	public synchronized void start() {
		if (running) return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		running = false;
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double delta = 0;
		double ns = 1000000000.0 / 60.0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(TITLE + " | " + updates + " ups " + frames + " fps");
				System.out.println(updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}

		}
	}

	private void update() {
		key.update();
		player.update();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;

		level.render(xScroll, yScroll, screen);
		player.render(screen);

		for (int i = 0; i < pixels.length; i++)
			pixels[i] = screen.pixels[i];

		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		if (Mouse.getButton() == 1) {
			g.setColor(Color.WHITE);
			g.fillRect(Mouse.getX(), Mouse.getY(), 64, 64);
		}
		g.dispose();
		bs.show();

	}

	public static void main(String[] args) {
		Game game = new Game();

		frame.add(game);
		frame.pack();
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		frame.addKeyListener(new Keyboard());
		game.start();
	}
}
