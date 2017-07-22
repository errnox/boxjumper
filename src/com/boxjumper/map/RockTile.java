package com.boxjumper.map;

import com.boxjumper.graphics.TextureLoader;

import processing.core.PApplet;
import processing.core.PImage;

public class RockTile extends Tile {
	private PImage tex;

	public RockTile(PApplet p, int x, int y) {
		super(p, x, y);
		isSolid = true;
		tex = TextureLoader.rockTile;
	}
	
	@Override
	public void render() {
		p.pushMatrix();
		p.pushStyle();
		p.noStroke();
		p.fill(80, 100, 200);
		p.image(tex, x, y);
		p.popStyle();
		p.popMatrix();
	}
}
