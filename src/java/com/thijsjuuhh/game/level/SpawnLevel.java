package com.thijsjuuhh.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpawnLevel extends Level {

	public SpawnLevel(String path) {
		super(path);
	}

	@Override
	protected void loadLevel(String path) {
		try {
			BufferedImage img = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = img.getWidth();
			int h = height = img.getHeight();
			tiles = new int[w * h];
			img.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load level file");
		}
	}

	@Override
	protected void generateLevel() {

	}
}
