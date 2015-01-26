package com.thijsjuuhh.game.registry;

import com.thijsjuuhh.game.grapics.Sprite;

public class Sprites {

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheets.tiles);
	public static Sprite flower_yellow = new Sprite(16, 1, 0, SpriteSheets.tiles);
	public static Sprite flower_red = new Sprite(16, 2, 0, SpriteSheets.tiles);
	public static Sprite rock = new Sprite(16, 3, 0, SpriteSheets.tiles);

	public static Sprite spawn_grass = new Sprite(16, 0, 0, SpriteSheets.spawn);
	public static Sprite spawn_hedge = new Sprite(16, 1, 0, SpriteSheets.spawn);
	public static Sprite spawn_water = new Sprite(16, 2, 0, SpriteSheets.spawn);
	public static Sprite spawn_wall1 = new Sprite(16, 0, 1, SpriteSheets.spawn);
	public static Sprite spawn_floor = new Sprite(16, 1, 1, SpriteSheets.spawn);
	public static Sprite spawn_wall2 = new Sprite(16, 0, 2, SpriteSheets.spawn);

	public static Sprite wizard_ball_large = new Sprite(16, 1, 0, SpriteSheets.projectile_wizard);
	public static Sprite wizard_ball = new Sprite(16, 1, 1, SpriteSheets.projectile_wizard);

	public static Sprite voidSprite = new Sprite(16, 0x009696);

	public static Sprite player_down = new Sprite(32, 0, 0, SpriteSheets.player);
	public static Sprite player_down_1 = new Sprite(32, 0, 1, SpriteSheets.player);
	public static Sprite player_down_2 = new Sprite(32, 0, 2, SpriteSheets.player);

	public static Sprite player_up = new Sprite(32, 1, 0, SpriteSheets.player);
	public static Sprite player_up_1 = new Sprite(32, 1, 1, SpriteSheets.player);
	public static Sprite player_up_2 = new Sprite(32, 1, 2, SpriteSheets.player);

	public static Sprite player_side = new Sprite(32, 2, 0, SpriteSheets.player);
	public static Sprite player_side_1 = new Sprite(32, 2, 1, SpriteSheets.player);
	public static Sprite player_side_2 = new Sprite(32, 2, 2, SpriteSheets.player);

	public static Sprite particle_normal = new Sprite(3, 0xAAAAAA);

}
