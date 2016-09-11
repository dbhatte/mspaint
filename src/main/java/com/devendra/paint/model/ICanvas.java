package com.devendra.paint.model;

import com.devendra.paint.exceptions.OutOfBoundsException;

public interface ICanvas<T> {

	void init(int width, int height, T blankColor);

	void setColor(int x, int y, T color) throws OutOfBoundsException;

	void setColor(int x, int y) throws OutOfBoundsException;

	void defaultDrawColor(T color);

	void draw();

	T getColor(int x, int y) throws OutOfBoundsException;

	int getWidth();

	void setWidth(int width);

	int getHeight();

	void setHeight(int height);

}
