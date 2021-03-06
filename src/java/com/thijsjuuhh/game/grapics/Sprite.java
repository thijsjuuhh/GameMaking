package com.thijsjuuhh.game.grapics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	private final int width, height;
	public int[] pixels;
	private SpriteSheet sheet;

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		width = size;
		height = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int color) {
		SIZE = size;
		width = size;
		height = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	private void setColor(int color) {
		for (int i = 0; i < width * height; i++)
			pixels[i] = color;
	}

	public Sprite(int width, int height, int color) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColor(color);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private void load() {
		for (int y = 0; y < SIZE; y++)
			for (int x = 0; x < SIZE; x++)
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
	}
}
