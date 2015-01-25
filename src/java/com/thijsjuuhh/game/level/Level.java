package com.thijsjuuhh.game.level;

import com.thijsjuuhh.game.grapics.Screen;
import com.thijsjuuhh.game.level.tile.Tile;
import com.thijsjuuhh.game.registry.LevelColors;
import com.thijsjuuhh.game.registry.Tiles;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

	public static Level spawn = new SpawnLevel("/main/level/level2.png");

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
			for (int x = x0; x < x1; x++)
				getTile(x, y).render(x, y, screen);
	}

	private void time() {
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tiles.voidTile;

		if (tiles[x + y * width] == LevelColors.spawn_grass) return Tiles.spawn_grass;
		if (tiles[x + y * width] == LevelColors.spawn_wall1) return Tiles.spawn_wall1;
		if (tiles[x + y * width] == LevelColors.spawn_wall2) return Tiles.spawn_wall2;
		if (tiles[x + y * width] == LevelColors.spawn_water) return Tiles.spawn_water;
		if (tiles[x + y * width] == LevelColors.spawn_hedge) return Tiles.spawn_hedge;
		if (tiles[x + y * width] == LevelColors.spawn_floor) return Tiles.spawn_floor;

		return Tiles.voidTile;
	}
}
