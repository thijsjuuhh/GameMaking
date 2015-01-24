package com.thijsjuuhh.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.thijsjuuhh.game.level.tile.Tile;

public class SpawnLevel extends Level {

	private int[] levelPixels;

	public SpawnLevel(String path) {
		super(path);
	}

	@Override
	protected void loadLevel(String path) {
		try {
			BufferedImage img = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = img.getWidth();
			int h = img.getHeight();
			tiles = new Tile[w * h];
			levelPixels = new int[w * h];
			img.getRGB(0, 0, w, h, levelPixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load level file");
		}
	}

	// Grass = 0xFF00
	// Yellow Flower = 0xFFFF00
	// Red Flower = 0xFF0000
	// Rock = 0x404040
	@Override
	protected void generateLevel() {
		for (int i = 0; i < levelPixels.length; i++) {
			if (levelPixels[i] == 0xFF00FF00) tiles[i] = Tile.grass;
			if (levelPixels[i] == 0xFFFFFF00) tiles[i] = Tile.flower_yellow;
			if (levelPixels[i] == 0xFFFF0000) tiles[i] = Tile.flower_red;
			if (levelPixels[i] == 0xFF404040) tiles[i] = Tile.rock;
		}
	}
}
