package com.boxjumper.map;

import com.boxjumper.Game;
import com.boxjumper.graphics.TextureLoader;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TextLoader;

import processing.core.PApplet;
import processing.core.PImage;

public class BackgroundTile extends Tile {
	private PImage tex;
	
	public BackgroundTile(PApplet p, int x, int y) {
		super(p, x, y);
		tex = TextureLoader.backgroundTile;
	}
	
	@Override
	public void render() {
		p.pushMatrix();
		p.pushStyle();
		p.noStroke();
		p.fill(40, 80, 100);
		p.image(tex, x, y);
		p.popStyle();
		p.popMatrix();
	}
}

