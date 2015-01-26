package com.thijsjuuhh.game.entity.projectile;

import com.thijsjuuhh.game.grapics.Screen;
import com.thijsjuuhh.game.registry.Sprites;

public class WizardProjectile extends Projectile {

	public static final int FIRERATE = 10;

	public WizardProjectile(int xOrigin, int yOrigin, double dir) {
		super(xOrigin, yOrigin, dir);
		range = 200;
		speed = 4;
		damage = 20;
		sprite = Sprites.wizard_ball;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	@Override
	public void update() {
		if (level.tileCollision(x, y, nx, ny, 8)) remove();
		move();
	}

	@Override
	protected void move() {
		x += nx;
		y += ny;
		if (distance() > range) remove();
	}

	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return dist;
	}

	@Override
	public void render(Screen screen) {
		screen.renderProjectile((int) x - 12, (int) y - 2, this);
	}

}
