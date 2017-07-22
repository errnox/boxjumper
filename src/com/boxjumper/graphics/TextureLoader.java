package com.boxjumper.graphics;

import processing.core.PApplet;
import processing.core.PImage;

public class TextureLoader {
	private PApplet p;
	private PImage entities;
	public static PImage playerNorth;
	public static PImage playerWest;
	public static PImage playerSouth;
	public static PImage playerEast;
	
	private PImage tiles;
	public static PImage rockTile;
	public static PImage backgroundTile;


	public TextureLoader(PApplet p) {
		this.p = p;
		
		// Entities

		entities = p.loadImage("entities.png");
		entities.loadPixels();
		
		playerNorth = new PImage();
		playerNorth.loadPixels();
		playerNorth = entities.get(16 * 2, 0, 16, 16);
		playerNorth.updatePixels();

		playerWest = new PImage();
		playerWest.loadPixels();
		playerWest = entities.get(0, 0, 16, 16);
		playerWest.updatePixels();

		playerSouth = new PImage();
		playerSouth.loadPixels();
		playerSouth = entities.get(16 * 3, 0, 16, 16);
		playerSouth.updatePixels();

		playerEast = new PImage();
		playerEast.loadPixels();
		playerEast = entities.get(16, 0, 16, 16);
		playerEast.updatePixels();

		entities.updatePixels();

		// Tiles

		tiles = p.loadImage("tiles.png");
		tiles.loadPixels();

		rockTile = new PImage();
		rockTile.loadPixels();
		rockTile = tiles.get(0, 0, 16, 16);
		rockTile.updatePixels();

		backgroundTile = new PImage();
		backgroundTile.loadPixels();
		backgroundTile = tiles.get(16, 0, 16, 16);
		backgroundTile.updatePixels();

		tiles.updatePixels();

	}
}
