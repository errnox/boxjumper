package com.boxjumper.graphics;

import com.boxjumper.Game;
import com.boxjumper.entity.Player;

import processing.core.PApplet;

public class Camera {
	private PApplet p;
	private int x;
	private int y;
	private int xVel;
	private int yVel;
	private Player player;
	private int zoneWidth;
	private int zoneHeight;
	
	public Camera(PApplet p, int x, int y, Player player) {
		this.p = p;
		this.x = x;
		this.y = y;
		this.player = player;
		
		xVel = 10;
		yVel = xVel;
		zoneWidth = Game.WIDTH / 5 * 2;
		zoneHeight= Game.HEIGHT / 3 * 2;
	}
	
	public void update() {
		followPlayer();
		p.translate(x, y);
	}
	
	private void followPlayer() {
		if (player.getScaledX() + x < (Game.WIDTH - zoneWidth) / 2) {
			moveLeft();
		}
		if ((player.getScaledX() + player.getWidth() * 2) + x > (Game.WIDTH -
				zoneWidth) / 2 + zoneWidth) {
			moveRight();
		}
		if (player.getScaledY() + y < (Game.HEIGHT- zoneHeight) / 2) {
			moveUp();
		}
		if ((player.getScaledY() + player.getHeight() * 2) + y > (Game.HEIGHT -
				zoneHeight) / 2 + zoneHeight) {
			moveDown();
		}
	}

	public void moveRight() {
		x -= xVel;
	}

	public void moveLeft() {
		x += xVel;
	}

	public void moveUp() {
		y += yVel;
	}

	public void moveDown() {
		y -= yVel;
	}
	
	public void render() {
		p.pushMatrix();
		p.translate(-x, -y);
		p.pushStyle();
		p.noFill();
		p.stroke(0, 0, 255);
		p.rect((Game.WIDTH - zoneWidth) / 2, (Game.HEIGHT - zoneHeight) / 2,
				zoneWidth, zoneHeight);
		p.popStyle();
		p.popMatrix();
	}
}
