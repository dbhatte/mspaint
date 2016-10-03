package com.devendra.paint.command.reader;

import com.devendra.paint.command.ICommand;

public class ConsoleCommandReader extends CommandReader {

	private final static CommandReader consoleCommandReader = new ConsoleCommandReader();
	private ConsoleCommandReader(){}

	@Override
	public ICommand getCommand() {
		System.out.print("enter command: ");
		return commandParser.parse();
	}

	public static CommandReader getInstance() {
		return consoleCommandReader;
	}

}
