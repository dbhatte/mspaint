package com.devendra.paint.engine;

import com.devendra.paint.command.ICommand;

public class PaintEngine implements IPaintEngine {

	private static PaintEngine paintEngine = new PaintEngine();

	private PaintEngine(){}

	public static PaintEngine getInstance() {
		return paintEngine;
	}

	public void executeCommand(ICommand command) {
		command.execute();
	}

}
