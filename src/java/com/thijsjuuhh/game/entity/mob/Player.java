package com.thijsjuuhh.game.entity.mob;

import com.thijsjuuhh.game.Game;
import com.thijsjuuhh.game.grapics.Screen;
import com.thijsjuuhh.game.grapics.Sprite;
import com.thijsjuuhh.game.input.Keyboard;
import com.thijsjuuhh.game.input.Mouse;
import com.thijsjuuhh.game.registry.Sprites;

//68
public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprites.player_up;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprites.player_up;

	}

	@Override
	public void update() {
		int xa = 0;
		int ya = 0;
		if (anim < 7500)
			anim++;
		else anim = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;

		if (xa != 0 || ya != 0) {
			walking = true;
			move(xa, ya);
		} else walking = false;

		updateShooting();
	}

	private void updateShooting() {
		if (Mouse.getButton() == 1) {
			double dx = Mouse.getX() - Game.width / 2;
			double dy = Mouse.getY() - Game.height / 2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
		}
	}

	@Override
	public void render(Screen screen) {
		if (dir == 0) {
			sprite = Sprites.player_up;
			if (walking) if (anim < 15)
				sprite = Sprites.player_up_1;
			else if (anim < 30)
				sprite = Sprites.player_up_2;
			else anim = 0;
		}
		if (dir == 1) {
			sprite = Sprites.player_right;
			if (walking) if (anim < 15)
				sprite = Sprites.player_right_1;
			else if (anim < 30)
				sprite = Sprites.player_right_2;
			else anim = 0;
		}
		if (dir == 2) {
			sprite = Sprites.player_down;
			if (walking) if (anim < 15)
				sprite = Sprites.player_down_1;
			else if (anim < 30)
				sprite = Sprites.player_down_2;
			else anim = 0;
		}
		if (dir == 3) {
			sprite = Sprites.player_left;
			if (walking) if (anim < 15)
				sprite = Sprites.player_left_1;
			else if (anim < 30)
				sprite = Sprites.player_left_2;
			else anim = 0;
		}
		screen.renderPlayer(x - 16, y - 16, this, sprite);
	}
}
