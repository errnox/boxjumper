package com.boxjumper.entity;

import com.boxjumper.Game;

import processing.core.PApplet;

public class Entity {
	protected PApplet p;
	public int x;
	public int y;
	public int w;
	public int h;

	public Entity(PApplet p, int x, int y) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.w = 16;
		this.h = 16;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getScaledX() {
		return (int) (x * Game.scaleFactor);
	}

	public int getScaledY() {
		return (int) (y * Game.scaleFactor);
	}
	
	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}
}
