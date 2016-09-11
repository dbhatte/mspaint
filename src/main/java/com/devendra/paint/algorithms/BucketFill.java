package com.devendra.paint.algorithms;

import com.devendra.paint.model.ICanvas;
import com.devendra.paint.model.Point;

public class BucketFill {

	public static void draw(ICanvas<Object> canvas, Point startingPoint, Object color) {
		final Object originalColor = canvas.getColor(startingPoint.getX(), startingPoint.getY());
		paint(canvas, startingPoint.getX(), startingPoint.getY(), originalColor, color);
	}

	private static void paint(ICanvas<Object> canvas, int x, int y, Object originalColor, Object color) {
		if (x < 1 || y < 1 || x > canvas.getWidth() || y > canvas.getHeight()) {
			return;
		}
		if (originalColor == color) {
			return;
		}
		if (canvas.getColor(x, y) != originalColor) {
			return;
		}
		canvas.setColor(x, y, color);
		paint(canvas, x + 1, y, originalColor, color);
		paint(canvas, x, y + 1, originalColor, color);
		paint(canvas, x - 1, y, originalColor, color);
		paint(canvas, x, y - 1, originalColor, color);
	}

}
