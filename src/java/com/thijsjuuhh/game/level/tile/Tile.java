package com.thijsjuuhh.game.level.tile;

import com.thijsjuuhh.game.grapics.Screen;
import com.thijsjuuhh.game.grapics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower_yellow = new FlowerYellowTile(Sprite.flower_yellow);
	public static Tile flower_red = new FlowerRedTile(Sprite.flower_red);
	public static Tile rock = new RockTile(Sprite.rock);

	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {
	}

	public boolean solid() {
		return false;
	}

}
