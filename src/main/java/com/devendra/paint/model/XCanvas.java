package com.devendra.paint.model;

import java.util.ArrayList;
import java.util.List;

import com.devendra.paint.exceptions.OutOfBoundsException;

public class XCanvas<T> implements ICanvas<T> {
	private List<List<T>> board;
	private int width;
	private int height;
	private T defaultDrawColor;
	private boolean initialized;

	@Override
	public void init(int width, int height, T blankColor) {
		this.width = width;
		this.height = height;
		board = new ArrayList<List<T>>();
		for (int row = 0; row < height; row++) {
			board.add(new ArrayList<T>());
			for (int col = 0; col < width; col++) {
				board.get(row).add(blankColor);
			}
		}
		initialized = true;
	}

	@Override
	public void setColor(int x, int y, T color) {
		if (x < 1 || y < 1 || x > this.getWidth() || y > this.getHeight()) {
			throw new OutOfBoundsException("Point is out of bounds of the canvas ");
		}
		board.get(y - 1).set(x - 1, color);
	}

	@Override
	public T getColor(int x, int y) {
		if (x < 1 || y < 1 || x > this.getWidth() || y > this.getHeight()) {
			throw new OutOfBoundsException("Point is out of bounds of the canvas ");
		}
		return board.get(y - 1).get(x - 1);
	}

	@Override
	public void setColor(int x, int y) {
		setColor(x, y, defaultDrawColor);
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void defaultDrawColor(T color) {
		this.defaultDrawColor = color;
	}

	@Override
	public void draw() {
		if (!initialized) {
			return;
		}
		drawHorizontalBorder();

		for (final List<T> row : board) {
			System.out.print("|");

			for (final T column : row) {
				System.out.print(column);

			}
			System.out.println("|");

		}
		drawHorizontalBorder();

	}

	private void drawHorizontalBorder() {
		for (int column = 0; column < width + 2; column++) {
			System.out.print("-");
		}
		System.out.println();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (board == null ? 0 : board.hashCode());
		result = prime * result + height;
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		@SuppressWarnings("unchecked")
		final XCanvas<T> other = (XCanvas<T>) obj;
		if (board == null) {
			if (other.board != null) {
				return false;
			}
		} else if (!board.equals(other.board)) {
			return false;
		}
		if (height != other.height) {
			return false;
		}
		if (width != other.width) {
			return false;
		}
		return true;
	}

}
