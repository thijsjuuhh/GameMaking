package com.thijsjuuhh.game.level.tile;

import com.thijsjuuhh.game.grapics.Screen;
import com.thijsjuuhh.game.grapics.Sprite;

public class FlowerYellowTile extends Tile {

	public FlowerYellowTile(Sprite sprite) {
		super(sprite);

	}

	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}
