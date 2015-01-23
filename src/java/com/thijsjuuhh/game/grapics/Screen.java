package com.thijsjuuhh.game.grapics;

import java.util.Random;

public class Screen {

	Random r = new Random();

	int width, height;
	public int[] pixels;

	public int[] tiles = new int[64 * 64];

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < 64 * 64; i++) {
			tiles[i] = r.nextInt(0xffffff);
		}

	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void render(int xOffs, int yOffs) {
		for (int y = 0; y < height; y++) {
			if (y < 0 || y >= height) {
				break;
			}
			int yPix = y + yOffs;
			for (int x = 0; x < width; x++) {
				if (x < 0 || x >= width) {
					break;
				}
				int xPix = x + xOffs;
				int tileIndex = (xPix >> 4) + (yPix >> 4) * 64;
				pixels[x + y * width] = tiles[tileIndex];
			}
		}

	}

}
