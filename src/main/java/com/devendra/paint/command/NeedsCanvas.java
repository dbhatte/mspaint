package com.devendra.paint.command;

import com.devendra.paint.model.ICanvas;

public interface NeedsCanvas {

	void setCanvas(ICanvas<Object> canvas);

}