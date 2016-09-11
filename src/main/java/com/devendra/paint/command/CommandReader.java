package com.devendra.paint.command;

import com.devendra.paint.command.enums.CommandReaderEnum;

public abstract class CommandReader implements ICommandReader{

	private static CommandReader consoleCommandReader = ConsoleCommandReader.getInstance();
	protected ICommandParser commandParser;

	protected CommandReader(){}

	public static ICommandReader getInstance(CommandReaderEnum commandReaderEnum) {
		CommandReader commandReader = null;
		switch (commandReaderEnum){
		case CONSOLE:
			commandReader = consoleCommandReader;
			break;
		default:
			commandReader = consoleCommandReader;
			break;
		}
		return commandReader;
	}

	public void setCommandParser(ICommandParser commandParser) {
		this.commandParser = commandParser;
	}

}
