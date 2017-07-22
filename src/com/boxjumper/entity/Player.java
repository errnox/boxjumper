package com.boxjumper.entity;

import java.util.ArrayList;

import com.boxjumper.Game;
import com.boxjumper.Helper;
import com.boxjumper.graphics.TextureLoader;
import com.boxjumper.map.Map;
import com.boxjumper.map.RockTile;
import com.boxjumper.map.Tile;

import processing.core.PApplet;
import processing.core.PImage;

public class Player extends MovingEntity {
	private PImage texNorth;
	private PImage texWest;
	private PImage texSouth;
	private PImage texEast;
	private Map map;
	private RockTile rockTile;

	public Player(PApplet p, int x, int y, Map map) {
		super(p, x, y);
		this.map = map;

		texNorth = TextureLoader.playerNorth;
		texWest = TextureLoader.playerWest;
		texSouth = TextureLoader.playerSouth;
		texEast = TextureLoader.playerEast;
	}
	
	public void update() {
		super.update();
		handleCollision();
		gravitate();
	}

	public void render() {
		p.pushStyle();
		p.pushMatrix();
		
		p.translate(x, y);

		// DEBUG
		// drawBoundingBox();

		if (directions.get("north") == true &&
				directions.get("west") == false &&
				directions.get("south") == false &&
				directions.get("east") == false) {
			p.image(texNorth, 0, 0);
		} else if(directions.get("west") == true &&
				directions.get("north") == false &&
				directions.get("south") == false &&
				directions.get("east") == false) {
			p.image(texWest, 0, 0);
		} else if(directions.get("south") == true &&
				directions.get("north") == false &&
				directions.get("west") == false &&
				directions.get("east") == false) {
			p.image(texSouth, 0, 0);
		} else if(directions.get("east") == true &&
				directions.get("north") == false &&
				directions.get("west") == false &&
				directions.get("south") == false) {
			p.image(texEast, 0, 0);
		} else {
			p.image(texNorth, 0, 0);
		}
		p.popStyle();
		p.popMatrix();
	}
	
	private void drawBoundingBox() {
		p.pushMatrix();
		p.pushStyle();
		p.noFill();
		p.stroke(255, 0, 0);
		p.rect(0, 0, w, h);
		p.popStyle();
		p.popMatrix();
	}
	
	private void handleCollision() {
		ArrayList<Tile> tiles = map.getTiles();
		Tile tile;
		for (int i = 0; i < tiles.size(); i++) {
			tile = tiles.get(i);
			if (tile.isSolid()) {
				if (Helper.collideAABB(this, tile) == true) {
					Helper.unsinkAFromB(this, tile);
				}
			}
		}
	}
}
