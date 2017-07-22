package com.boxjumper;

import com.boxjumper.entity.Entity;
import com.boxjumper.entity.MovingEntity;

public class Helper {
	public static boolean collideAABB(Entity a, Entity b) {
		boolean isColliding = true;
		if (a.x + a.w < b.x || a.x > b.x + b.w) isColliding = false;
		if (a.y + a.h < b.y || a.y > b.y + b.h) isColliding = false;
		return isColliding;
	}

	public static void unsinkAFromB(MovingEntity a, Entity b) {
		int aCenterX = a.x + a.w / 2;
		int aCenterY = a.y + a.h / 2;
		int bCenterX = b.x + b.w / 2;
		int bCenterY = b.y + b.h / 2;

		int hd = Math.max(aCenterX, bCenterX) - Math.min(aCenterX, bCenterX);
		int vd = Math.max(aCenterY, bCenterY) - Math.min(aCenterY, bCenterY);

		int buf = 1;

		if (hd > vd) {
			if (aCenterX < bCenterX) { // from west
				a.x = b.x - a.w - buf;
			} else { // from east
				a.x = b.x + b.w + buf;
			}
		} else {
			if (aCenterY < bCenterY) { // from north
				a.y = b.y - b.h - buf;
				a.setStanding();
			} else { // from south
				a.y = b.y + a.h + buf;
			}
		}
	}
}
