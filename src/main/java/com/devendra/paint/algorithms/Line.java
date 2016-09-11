package com.devendra.paint.algorithms;

import com.devendra.paint.model.ICanvas;
import com.devendra.paint.model.Point;

public class Line {
	public static void draw(ICanvas<Object> canvas, Point startingPoint, Point endingPoint) {
		if (startingPoint.getX() == endingPoint.getX()) {
			for (int y = startingPoint.getY(); y <= endingPoint.getY(); y++) {
				canvas.setColor(startingPoint.getX(), y);
			}
		} else if (startingPoint.getY() == endingPoint.getY()) {
			for (int x = startingPoint.getX(); x <= endingPoint.getX(); x++) {
				canvas.setColor(x, startingPoint.getY());
			}
		} else {
			throw new IllegalArgumentException("The line is not horizontal or vertical");
		}
	}
}
