package com.devendra.paint.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandParser implements ICommandParser {

	private static ICommandParser commandParser = new CommandParser();
	private static Map<String, ICommand> commands = new HashMap<String, ICommand>();
	private Scanner scanner;

	private CommandParser(){}

	public static ICommandParser getInstance() {
		return commandParser;
	}

	@Override
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public void registerCommands(String key, ICommand command){
		commands.put(key, command);
	}

	@Override
	public ICommand parse() {
		final String commandString = scanner.next();

		return commands.get(commandString.toUpperCase());
	}

}
