package com.thijsjuuhh.game.level.tile.spawn;

import com.thijsjuuhh.game.grapics.Screen;
import com.thijsjuuhh.game.grapics.Sprite;
import com.thijsjuuhh.game.level.tile.Tile;

public class SpawnWallTile extends Tile {

	private int id;

	public SpawnWallTile(Sprite sprite, int id) {
		super(sprite);
		this.id = id;
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
		if (id == 0)
			return true;
		else return false;
	}

}
