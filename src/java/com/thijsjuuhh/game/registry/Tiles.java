package com.thijsjuuhh.game.registry;

import com.thijsjuuhh.game.level.tile.FlowerRedTile;
import com.thijsjuuhh.game.level.tile.FlowerYellowTile;
import com.thijsjuuhh.game.level.tile.GrassTile;
import com.thijsjuuhh.game.level.tile.RockTile;
import com.thijsjuuhh.game.level.tile.Tile;
import com.thijsjuuhh.game.level.tile.VoidTile;
import com.thijsjuuhh.game.level.tile.spawn.SpawnFloorTile;
import com.thijsjuuhh.game.level.tile.spawn.SpawnGrassTile;
import com.thijsjuuhh.game.level.tile.spawn.SpawnHedgeTile;
import com.thijsjuuhh.game.level.tile.spawn.SpawnWallTile;
import com.thijsjuuhh.game.level.tile.spawn.SpawnWaterTile;

public class Tiles {

	public static Tile grass = new GrassTile(Sprites.grass);
	public static Tile flower_yellow = new FlowerYellowTile(Sprites.flower_yellow);
	public static Tile flower_red = new FlowerRedTile(Sprites.flower_red);
	public static Tile rock = new RockTile(Sprites.rock);

	public static Tile spawn_grass = new SpawnGrassTile(Sprites.spawn_grass);
	public static Tile spawn_wall1 = new SpawnWallTile(Sprites.spawn_wall1, 0);
	public static Tile spawn_wall2 = new SpawnWallTile(Sprites.spawn_wall2, 1);
	public static Tile spawn_water = new SpawnWaterTile(Sprites.spawn_water);
	public static Tile spawn_hedge = new SpawnHedgeTile(Sprites.spawn_hedge);
	public static Tile spawn_floor = new SpawnFloorTile(Sprites.spawn_floor);

	public static Tile voidTile = new VoidTile(Sprites.voidSprite);

}
