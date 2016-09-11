package com.devendra.paint.engine;

import com.devendra.paint.command.ICommand;

public interface IPaintEngine {
	public void executeCommand(ICommand command);

}
