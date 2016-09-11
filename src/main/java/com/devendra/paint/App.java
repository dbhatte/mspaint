package com.devendra.paint;

import com.devendra.paint.command.CommandReader;
import com.devendra.paint.command.ICommand;
import com.devendra.paint.command.ICommandReader;
import com.devendra.paint.command.enums.CommandReaderEnum;
import com.devendra.paint.engine.IPaintEngine;
import com.devendra.paint.engine.PaintEngine;

public class App
{
	private final static IPaintEngine paintEngine = PaintEngine.getInstance();
	private final static ICommandReader commandReader = CommandReader.getInstance(CommandReaderEnum.CONSOLE);

	public static void main( String[] args )
	{
		while (true) {
			final ICommand command = commandReader.getCommand();

			paintEngine.executeCommand(command);
		}

	}
}
