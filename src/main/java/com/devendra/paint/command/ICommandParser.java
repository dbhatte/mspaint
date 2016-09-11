package com.devendra.paint.command;

import java.util.Scanner;

public interface ICommandParser {

	void setScanner(Scanner scanner);

	void registerCommands(String key, ICommand command);

	ICommand parse();

}