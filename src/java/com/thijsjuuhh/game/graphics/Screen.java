package com.thijsjuuhh.game.graphics;

import java.util.Random;

public class Screen extends Render {

	Render test;

	public Screen(int width, int height) {
		super(width, height);
		Random r = new Random();
		test = new Render(width, height);
		for (int i = 0; i < width * height; i++) {
			pixels[i] = r.nextInt();
		}
	}

}
