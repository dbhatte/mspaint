package com.devendra.paint.command.commands;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.devendra.paint.algorithms.BucketFill;
import com.devendra.paint.command.ICommand;
import com.devendra.paint.command.NeedsCanvas;
import com.devendra.paint.model.ICanvas;
import com.devendra.paint.model.Point;

public class BucketFillCommand implements ICommand, NeedsCanvas {

	private ICanvas<Object> canvas;
	private Point startingPoint;
	private Object color;
	private final Scanner scanner;

	@Override
	public void setCanvas(ICanvas<Object> canvas) {
		this.canvas = canvas;
	}

	public BucketFillCommand(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public void execute() {
		try {
			startingPoint = new Point(scanner.nextInt(), scanner.nextInt());
			color = scanner.next().charAt(0);
		} catch (final InputMismatchException ime) {
			throw new IllegalArgumentException("Invalid Input");
		}
		BucketFill.draw(canvas, startingPoint, color);
	}

}
