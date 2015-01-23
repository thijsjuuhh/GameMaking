package com.thijsjuuhh.game.grapics;

import java.util.Random;

public class Screen {

	Random r = new Random();

	int width, height;
	public int[] pixels;

	public final int MAP_SIZE = 8;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;

	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = r.nextInt(0xffffff);
		}
		tiles[0] = 0x000000;

	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void render(int xOffs, int yOffs) {
		for (int y = 0; y < height; y++) {
			int yPix = y + yOffs;
			// if (yPix < 0 || yPix >= height) break;
			for (int x = 0; x < width; x++) {
				int xPix = x + xOffs;
				// if (xPix < 0 || xPix >= width) break;
				int tileIndex = ((xPix >> 4) & MAP_SIZE_MASK) + ((yPix >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
				pixels[x + y * width] = tiles[tileIndex];
			}
		}

	}

}
