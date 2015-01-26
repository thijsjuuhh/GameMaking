package com.thijsjuuhh.game.entity.particle;

import java.util.ArrayList;
import java.util.List;

import com.thijsjuuhh.game.entity.Entity;
import com.thijsjuuhh.game.grapics.Screen;
import com.thijsjuuhh.game.grapics.Sprite;
import com.thijsjuuhh.game.registry.Sprites;

//77
public class Particle extends Entity {

	private List<Particle> particles = new ArrayList<Particle>();
	private Sprite sprite;

	private int life;

	public Particle(int x, int y, int life) {
		this.x = x;
		this.y = y;
		this.life = life;
		sprite = Sprites.particle_normal;
		particles.add(this);
	}

	public Particle(int x, int y, int life, int amount) {
		this(x, y, life);
		for (int i = 0; i < amount - 1; i++)
			particles.add(new Particle(x, y, life));
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Screen screen) {
	}
}
