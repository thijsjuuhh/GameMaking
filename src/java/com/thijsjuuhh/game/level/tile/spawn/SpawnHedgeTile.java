package com.thijsjuuhh.game.level.tile.spawn;

import com.thijsjuuhh.game.grapics.Screen;
import com.thijsjuuhh.game.grapics.Sprite;
import com.thijsjuuhh.game.level.tile.Tile;

public class SpawnHedgeTile extends Tile {

	public SpawnHedgeTile(Sprite sprite) {
		super(sprite);

	}

	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

	@Override
	public boolean solid() {
		return true;
	}

	@Override
	public boolean breakable() {
		return true;
	}
}
