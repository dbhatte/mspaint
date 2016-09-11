package com.devendra.paint.command.commands;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.devendra.paint.algorithms.Rectangle;
import com.devendra.paint.command.ICommand;
import com.devendra.paint.command.NeedsCanvas;
import com.devendra.paint.model.ICanvas;
import com.devendra.paint.model.Point;

public class RectangleCommand implements ICommand, NeedsCanvas {

	private Point leftTopPoint;
	private Point rightBottomPoint;
	private ICanvas<Object> canvas;
	private final Scanner scanner;

	@Override
	public void setCanvas(ICanvas<Object> canvas) {
		this.canvas = canvas;
	}

	public RectangleCommand(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public void execute() {
		try {
			leftTopPoint = new Point(scanner.nextInt(), scanner.nextInt());
			rightBottomPoint = new Point(scanner.nextInt(), scanner.nextInt());
		} catch (final InputMismatchException ime) {
			throw new IllegalArgumentException("Invalid Input");
		}
		Rectangle.draw(canvas, leftTopPoint, rightBottomPoint);
	}

}
