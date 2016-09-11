package com.devendra.paint.command.commands;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.devendra.paint.algorithms.Line;
import com.devendra.paint.command.ICommand;
import com.devendra.paint.command.NeedsCanvas;
import com.devendra.paint.model.ICanvas;
import com.devendra.paint.model.Point;

public class LineCommand implements ICommand, NeedsCanvas {
	private Point startingPoint;
	private Point endingPoint;
	private ICanvas<Object> canvas;
	private final Scanner scanner;

	public LineCommand(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public void setCanvas(ICanvas<Object> canvas) {
		this.canvas = canvas;
	}

	@Override
	public void execute() {
		try {
			startingPoint = new Point(scanner.nextInt(), scanner.nextInt());
			endingPoint = new Point(scanner.nextInt(), scanner.nextInt());
		} catch (final InputMismatchException ime) {
			throw new IllegalArgumentException("Invalid Input");
		}
		Line.draw(canvas, startingPoint, endingPoint);
	}

}
