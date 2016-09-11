package com.devendra.paint.command;

public interface ICommandReader {

	ICommand getCommand();

	void setCommandParser(ICommandParser commandParser);

}
