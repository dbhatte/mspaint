package com.devendra.paint.algorithms;

import com.devendra.paint.exceptions.OutOfBoundsException;
import com.devendra.paint.model.ICanvas;
import com.devendra.paint.model.Point;
import com.devendra.paint.model.XCanvas;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LineTest extends TestCase {

	final ICanvas<Object> expectedCanvas = new XCanvas<Object>();
	final ICanvas<Object> canvas = new XCanvas<Object>();

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public LineTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(LineTest.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		expectedCanvas.init(20, 4, ' ');
		canvas.init(20, 4, ' ');

	}

	public void testHorizontal() {

		final Point startingPoint = new Point(1, 2);
		final Point endingPoint = new Point(6, 2);

		for (int x = startingPoint.getX(); x <= endingPoint.getX(); x++) {
			expectedCanvas.setColor(x, startingPoint.getY());
		}

		Line.draw(canvas, startingPoint, endingPoint);
		assertEquals(expectedCanvas, canvas);
	}

	public void testVertical() {
		final Point startingPoint = new Point(6, 3);
		final Point endingPoint = new Point(6, 4);

		for (int y = startingPoint.getY(); y <= endingPoint.getY(); y++) {
			expectedCanvas.setColor(startingPoint.getX(), y);
		}

		Line.draw(canvas, startingPoint, endingPoint);
		assertEquals(expectedCanvas, canvas);
	}

	public void testOutOfCanvas() {
		final Point startingPoint = new Point(-1, -1);
		final Point endingPoint = new Point(-1, 4);
		try {
			Line.draw(canvas, startingPoint, endingPoint);
		} catch (final OutOfBoundsException e) {
			assertEquals("Point is out of bounds of the canvas ", e.getMessage());
		}
	}

	public void testNonHorizontalOrVertical() {
		final Point startingPoint = new Point(1, 1);
		final Point endingPoint = new Point(4, 4);
		try {
			Line.draw(canvas, startingPoint, endingPoint);
		} catch (final IllegalArgumentException e) {
			assertEquals("The line is not horizontal or vertical", e.getMessage());
		}
	}

}