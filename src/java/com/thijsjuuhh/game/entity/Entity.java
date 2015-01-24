package com.thijsjuuhh.game.entity;

import java.util.Random;

import com.thijsjuuhh.game.grapics.Screen;
import com.thijsjuuhh.game.level.Level;

public abstract class Entity {

	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();

	public void update() {
	}

	public void render(Screen screen) {
	}

	public void remove() {
		// Remove from Level
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}

}
