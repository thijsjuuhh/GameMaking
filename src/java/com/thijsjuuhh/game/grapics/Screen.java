package com.thijsjuuhh.game.grapics;

import java.util.Random;

import com.thijsjuuhh.game.entity.mob.Player;
import com.thijsjuuhh.game.entity.projectile.Projectile;
import com.thijsjuuhh.game.level.tile.Tile;

public class Screen {

	Random r = new Random();

	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 8;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int xOffs, yOffs;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++)
			tiles[i] = r.nextInt(0xffffff);
		tiles[0] = 0x000000;

	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0;
	}

	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) {
		if (fixed) {
			xp -= xOffs;
			yp -= yOffs;
		}
		for (int y = 0; y < sprite.getHeight(); y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.getWidth(); x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
				pixels[xa + ya * width] = sprite.pixels[x + y * sprite.getWidth()];
			}
		}
	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffs;
		yp -= yOffs;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}

	public void renderProjectile(int xp, int yp, Projectile p) {
		xp -= xOffs;
		yp -= yOffs;
		for (int y = 0; y < p.getSpriteSize(); y++) {
			int ya = y + yp;
			for (int x = 0; x < p.getSpriteSize(); x++) {
				int xa = x + xp;
				if (xa < -p.getSpriteSize() || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = p.getSprite().pixels[x + y * p.getSpriteSize()];
				if (col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}

	public void renderPlayer(int xp, int yp, Player p, Sprite sprite, int flip) {
		xp -= xOffs;
		yp -= yOffs;
		for (int y = 0; y < 32; y++) {
			int ya = y + yp;
			int ys = y;
			if (flip == 2 || flip == 3) ys = 31 - y;
			for (int x = 0; x < 32; x++) {
				int xa = x + xp;
				int xs = x;
				if (flip == 1 || flip == 3) xs = 31 - x;
				if (xa < -32 || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xs + ys * 32];
				if (col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}

	public void setOffset(int xOffs, int yOffs) {
		this.xOffs = xOffs;
		this.yOffs = yOffs;
	}

}
