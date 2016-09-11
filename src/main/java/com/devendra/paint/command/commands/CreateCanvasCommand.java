package com.devendra.paint.command.commands;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.devendra.paint.command.ICommand;
import com.devendra.paint.command.NeedsCanvas;
import com.devendra.paint.model.ICanvas;

public class CreateCanvasCommand implements ICommand, NeedsCanvas {
	private int width;
	private int height;
	private ICanvas<Object> canvas;
	private final Scanner scanner;

	public CreateCanvasCommand(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public void setCanvas(ICanvas<Object> canvas) {
		this.canvas = canvas;
	}

	@Override
	public void execute() {
		try {
			width = scanner.nextInt();
			height = scanner.nextInt();
		} catch (final InputMismatchException ime) {
			throw new IllegalArgumentException("Invalid Input");
		}
		if (width < 0 ||height <0 ) {
			throw new IllegalArgumentException("Width or Height can't be negative");
		}
		canvas.init(width, height, ' ');
		canvas.defaultDrawColor('x');
	}

}
