package com.devendra.paint;

import java.util.Scanner;

import com.devendra.paint.command.CommandParser;
import com.devendra.paint.command.CommandReader;
import com.devendra.paint.command.ICommand;
import com.devendra.paint.command.ICommandParser;
import com.devendra.paint.command.ICommandReader;
import com.devendra.paint.command.commands.CreateCanvasCommand;
import com.devendra.paint.command.commands.QuitCommand;
import com.devendra.paint.command.enums.CommandReaderEnum;
import com.devendra.paint.engine.IPaintEngine;
import com.devendra.paint.engine.PaintEngine;

public class App
{
	private final static IPaintEngine paintEngine = PaintEngine.getInstance();
	private final static ICommandReader commandReader = CommandReader.getInstance(CommandReaderEnum.CONSOLE);
	private final static ICommandParser commandParser = CommandParser.getInstance();
	private final static Scanner scanner = new Scanner(System.in);

	public static void main( String[] args )
	{
		commandReader.setCommandParser(commandParser);
		commandParser.registerCommands("C", new CreateCanvasCommand(scanner));
		commandParser.registerCommands("Q", new QuitCommand());
		commandParser.setScanner(scanner);
		while (true) {
			final ICommand command = commandReader.getCommand();

			paintEngine.executeCommand(command);
		}

	}
}
