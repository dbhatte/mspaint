package com.devendra.paint.command.commands;

import com.devendra.paint.command.ICommand;

public class QuitCommand implements ICommand {

	@Override
	public void execute() {
		System.exit(0);
	}

}
