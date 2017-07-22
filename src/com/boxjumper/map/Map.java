package com.boxjumper.map;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;


public class Map {
	private PApplet p;
	private int w;
	private int h;
	private ArrayList<Tile> tiles;

	public Map(PApplet p) {
		this.p = p;
		w = 13;
		h = 9;
		tiles = new ArrayList<Tile>();
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if (x % 2 == 1 && y > 2 && y % 3 == 1) {
					tiles.add(new RockTile(p, x * Tile.DEFAULT_WIDTH, y * Tile.DEFAULT_HEIGHT));
				} else {
					tiles.add(new BackgroundTile(p, x * Tile.DEFAULT_WIDTH, y * Tile.DEFAULT_HEIGHT));
				}
			}
		}
	}
	
	public void update() {
		
	}

	public void render() {
		p.pushMatrix();
		p.pushStyle();
		for (int i = 0; i < tiles.size(); i++) {
			tiles.get(i).render();
		}
		p.popStyle();
		p.popMatrix();
	}
	
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
}
