package com.devendra.paint.engine;

import com.devendra.paint.command.ICommand;
import com.devendra.paint.command.NeedsCanvas;
import com.devendra.paint.model.ICanvas;
import com.devendra.paint.model.XCanvas;

public class PaintEngine implements IPaintEngine {

	private static PaintEngine paintEngine = new PaintEngine();
	private static ICanvas<Object> canvas = new XCanvas<Object>();

	private PaintEngine(){}

	public static PaintEngine getInstance() {
		return paintEngine;
	}

	@Override
	public void executeCommand(ICommand command) {
		if (command == null) {
			System.out.println("Please retry with correct input");
			return;
		}
		if (command instanceof NeedsCanvas) {
			((NeedsCanvas) command).setCanvas(canvas);
		}
		try {
			command.execute();
		} catch (final RuntimeException e) {
			System.out.println("Error Occurred:" + e.getMessage());

			System.out.println("Please retry with correct input");

		}
		canvas.draw();
	}

}
