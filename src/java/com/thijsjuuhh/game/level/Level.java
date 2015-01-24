package com.thijsjuuhh.game.level;

import com.thijsjuuhh.game.grapics.Screen;
import com.thijsjuuhh.game.level.tile.Tile;

//56
public class Level {

	protected Tile[] tiles;
	protected int width, height;
	protected int[] tilesInt;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void loadLevel(String path) {
	}

	protected void generateLevel() {
	}

	public void update() {
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++)
			for (int x = x0; x < x1; x++) {
				if (x + y * 16 < 0 || x + y * 16 >= 256) {
					Tile.voidTile.render(x, y, screen);
					continue;
				}
				tiles[x + y * 16].render(x, y, screen);
			}
		// getTile(x, y).render(x, y, screen);

	}

	private void time() {
	}

	public Tile getTile(int x, int y) {

		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tilesInt[x + y * width] == 0) return Tile.grass;
		if (tilesInt[x + y * width] == 1) return Tile.flower_yellow;
		if (tilesInt[x + y * width] == 2) return Tile.flower_red;
		if (tilesInt[x + y * width] == 3) return Tile.rock;
		return Tile.voidTile;
	}
}
