package com.thijsjuuhh.game.level;

import java.util.ArrayList;
import java.util.List;

import com.thijsjuuhh.game.entity.Entity;
import com.thijsjuuhh.game.entity.projectile.Projectile;
import com.thijsjuuhh.game.grapics.Screen;
import com.thijsjuuhh.game.level.tile.Tile;
import com.thijsjuuhh.game.registry.LevelColors;
import com.thijsjuuhh.game.registry.Tiles;

//75
public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

	private List<Entity> entities = new ArrayList<Entity>();
	List<Projectile> projectiles = new ArrayList<Projectile>();

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
		for (int i = 0; i < entities.size(); i++)
			entities.get(i).update();
		for (int i = 0; i < projectiles.size(); i++)
			projectiles.get(i).update();

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

		for (int i = 0; i < entities.size(); i++)
			entities.get(i).render(screen);
		for (int i = 0; i < projectiles.size(); i++)
			projectiles.get(i).render(screen);

	}

	private void time() {
	}

	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	public void add(Entity e) {
		entities.add(e);
	}

	public void addProjectile(Projectile p) {
		p.init(this);
		projectiles.add(p);
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

	public boolean tileCollision(double x, double y, double xa, double ya, int size) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = (((int) x + (int) xa) + c % 2 * size * 2 - 12) / 16;
			int yt = (((int) y + (int) ya) + c / 2 * size + 2) / 16;
			if (getTile(xt, yt).solid()) solid = true;
		}
		return solid;
	}

}
