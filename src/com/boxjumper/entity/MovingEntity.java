package com.boxjumper.entity;

import java.util.ArrayList;
import java.util.HashMap;

import processing.core.PApplet;

public class MovingEntity extends Entity {
	protected float xVel;
	protected float yVel;
	protected float previousYVel;
	protected float maxXVel;
	protected float maxYVel;
	protected float accel;
	protected float friction;
	protected float gravity;
	protected float jumpImpulse;
	public boolean isJumping;
	public boolean isGravitating;
	public int jumpTimer;
	public int bobbingTimer;
	public int yVelTimer;
	public boolean bobbingUp;
	public HashMap<String, Boolean> directions;

	public MovingEntity(PApplet p, int x, int y) {
		super(p, x, y);
		xVel = 0;
		yVel = 0;
		previousYVel = 0;
		yVelTimer = 0;
		maxXVel = 2f;
		maxYVel = 2f;
		accel = 1f;
		jumpImpulse = 15;
		jumpTimer = 0;
		bobbingTimer = 0;
		bobbingUp = true;
		friction = accel / 2;
		gravity = accel * 1.5f;
		isJumping = false;
		isGravitating = true;
		directions = new HashMap<String, Boolean>();
		directions.put("north", false);
		directions.put("west", false);
		directions.put("south", false);
		directions.put("east", false);
	}
	
	protected void update() {
		x += xVel;
		if (xVel > 0 ) xVel -= friction;
		if (xVel < 0 ) xVel += friction;
		if (xVel > maxXVel) xVel = maxXVel; 
		if (xVel < -maxXVel) xVel = -maxXVel; 

		y += yVel;
		if (!isGravitating) {
			if (yVel > 0 ) yVel -= friction;
			if (yVel < 0 ) yVel += friction;
		}
		if (yVel > maxYVel) yVel = maxYVel; 
		if (yVel < -maxYVel) yVel = -maxYVel;
		
		if (jumpTimer <= 0) {
			gravity = accel * 1.5f;
			jumpTimer = 0;
		} else {
			gravity = 0;
			jumpTimer--;
			yVel -= jumpTimer;
		}

		if (bobbingTimer <= -2) bobbingUp = true;
		if (bobbingTimer >= 2) bobbingUp = false;
		if (bobbingUp == true) {
			bobbingTimer++;
		} else {
			bobbingTimer--;
		}

		if (yVelTimer >= 0) {
			yVelTimer--;
		} else {
			yVelTimer = 2;
			previousYVel = yVel;
		}
		if (previousYVel == yVel) {
			isJumping = true;
		}
	}

	public void moveRight() {
		xVel += accel;
		if (isGravitating && !isJumping) yVel -= bobbingTimer * 1.8;
		directions.put("east", true);
	}

	public void moveLeft() {
		xVel -= accel;
		if (isGravitating && !isJumping) yVel -= bobbingTimer * 1.8;
		directions.put("west", true);
	}

	public void moveUp() {
		if (!isGravitating) {
			yVel -= accel;
			directions.put("north", true);
		}
	}

	public void moveDown() {
		yVel += accel;
		directions.put("south", true);
	}
	
	public void stopMovingLeft() {
		directions.put("west", false);
	}

	public void stopMovingRight() {
		directions.put("east", false);
	}

	public void stopMovingUp() {
		directions.put("north", false);
	}

	public void stopMovingDown() {
		directions.put("south", false);
	}
	
	public void jump() {
		if (!isJumping && isGravitating) {
			jumpTimer = 7;
			isJumping = true;
		}
	}
	
	protected void gravitate() {
		if (isGravitating) yVel += gravity;
	}
	
	public void setStanding() {
		isJumping = false;
	}
	
	public void toggleGravitating() {
		if (isGravitating) {
			jump();
			isGravitating = false;
		} else {
			isGravitating = true;
		}
	}
}
