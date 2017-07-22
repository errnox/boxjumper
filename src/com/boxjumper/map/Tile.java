package com.boxjumper.map;

import com.boxjumper.entity.Entity;

import processing.core.PApplet;

public class Tile extends Entity {
	protected int w;
	protected int h;
	protected boolean isSolid;
	public static int DEFAULT_WIDTH = 16;
	public static int DEFAULT_HEIGHT = 16;
	
	public Tile(PApplet p, int x, int y) {
		super(p, x, y);
		w = DEFAULT_WIDTH;
		h = DEFAULT_HEIGHT;
		isSolid = false;
	}
	
	public void update() {
		
	}

	public void render() {
		
	}
	
	public boolean isSolid() {
		return isSolid;
	}
}
