package com.thijsjuuhh.game.graphics;

public class Render {
	public final int width;
	public final int height;
	public final int[] pixels;

	public Render(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void draw(Render render, int xOffs, int yOffs) {
		for (int y = 0; y < render.height; y++) {
			int yPix = y + yOffs;
			for (int x = 0; x < render.width; x++) {
				int xPix = x + xOffs;
				pixels[xPix + yPix * width] = render.pixels[x + y * width];
			}
		}
	}

}
