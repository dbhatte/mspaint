package com.devendra.paint.command.reader;

import com.devendra.paint.command.ICommand;
import com.devendra.paint.command.ICommandParser;

public interface ICommandReader {

	ICommand getCommand();

	void setCommandParser(ICommandParser commandParser);

}
