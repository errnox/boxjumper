package com.boxjumper;

import java.util.HashMap;

import com.boxjumper.entity.Player;
import com.boxjumper.graphics.Camera;
import com.boxjumper.graphics.TextureLoader;
import com.boxjumper.map.BackgroundTile;
import com.boxjumper.map.Map;
import com.boxjumper.map.Tile;
import com.sun.org.apache.xpath.internal.operations.Bool;


import processing.core.PApplet;
import processing.event.KeyEvent;
import sun.applet.Main;

public class Game extends PApplet {
	public static int WIDTH = 640;
	public static int HEIGHT = 480;
	private HashMap<Character, Boolean> keys;
	private HashMap<Integer, Boolean> keyCodes;
	private TextureLoader textureLoader;
	private Player player;
	public Map map;
	public static float scaleFactor;
	private Camera camera;
	
	public void settings() {
		size(WIDTH, HEIGHT);
		noSmooth();
	}

	public void setup() {
		keys = new HashMap<Character, Boolean>();
		keyCodes = new HashMap<Integer, Boolean>();
		for (int i = 0; i < 200; i++) {
			keys.put((char) i, false);
			keyCodes.put(i, false);
		}
		textureLoader = new TextureLoader(this);

		scaleFactor = 3f;
		map = new Map(this);
//		player = new Player(this, WIDTH / 2 - 16 / scaleFactor, HEIGHT / 2 - 16 / scaleFactor, map);
		player = new Player(this, 20, 20, map);
		camera = new Camera(this, 0, 0, player);
}

	public void draw() {
		clear();
		background(0, 0, 0);

		update();

		pushMatrix();
		scale(scaleFactor);
//		translate(-WIDTH / scaleFactor, -HEIGHT / scaleFactor);
		map.render();
		player.render();

		popMatrix();

		// DEBUG
//		pushMatrix();
//		camera.render();
//		popMatrix();
	}

	private void update() {
		handleKeys();
		camera.update();
		player.update();
	}
	
	public void keyPressed() {
		if (key == CODED) {
			keyCodes.put(keyCode, true);
		} else {
			keys.put(key, true);
		}
	}

	private void handleKeys() {
		if (keyCodes.get(LEFT) == true) {
			player.moveLeft();
		}
		if (keyCodes.get(RIGHT) == true) {
			player.moveRight();
		}
		if (keyCodes.get(UP) == true) {
			player.moveUp();
		}
		if (keyCodes.get(DOWN) == true) {
			player.moveDown();
		}
		if (keys.get(' ') == true) {
			player.jump();
		}
		if (keys.get('a') == true) {
			camera.moveLeft();
		}
		if (keys.get('d') == true) {
			camera.moveRight();
		}
		if (keys.get('w') == true) {
			camera.moveUp();
		}
		if (keys.get('s') == true) {
			camera.moveDown();
		}
	}
	
	public void keyTyped() {
		if (key == 'f') {
			player.toggleGravitating();
		}
	}

	public void keyReleased() {
		if (keyCodes.get(LEFT) == true) {
			player.stopMovingLeft();
		}
		if (keyCodes.get(RIGHT) == true) {
			player.stopMovingRight();
		}
		if (keyCodes.get(UP) == true) {
			player.stopMovingUp();
		}
		if (keyCodes.get(DOWN) == true) {
			player.stopMovingDown();
		}
		
		keys.put(key, false);
		keyCodes.put(keyCode, false);
	}

	public static void main(String[] args) {
		PApplet.main("com.boxjumper.Game");
	}
}
