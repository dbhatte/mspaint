package com.devendra.paint.algorithms;

import com.devendra.paint.model.ICanvas;
import com.devendra.paint.model.Point;

public class Rectangle {
	public static void draw(ICanvas<Object> canvas, Point leftTopPoint, Point rightBottomPoint) {
		Line.draw(canvas, new Point(leftTopPoint.getX(), leftTopPoint.getY()),
				new Point(leftTopPoint.getX(), rightBottomPoint.getY()));
		Line.draw(canvas, new Point(rightBottomPoint.getX(), leftTopPoint.getY()),
				new Point(rightBottomPoint.getX(), rightBottomPoint.getY()));
		Line.draw(canvas, new Point(leftTopPoint.getX(), leftTopPoint.getY()),
				new Point(rightBottomPoint.getX(), leftTopPoint.getY()));
		Line.draw(canvas, new Point(leftTopPoint.getX(), rightBottomPoint.getY()),
				new Point(rightBottomPoint.getX(), rightBottomPoint.getY()));
	}
}
