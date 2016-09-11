package com.devendra.paint.algorithms;

import com.devendra.paint.model.ICanvas;
import com.devendra.paint.model.Point;
import com.devendra.paint.model.XCanvas;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BucketFillTest extends TestCase {
	final ICanvas<Object> expectedCanvas = new XCanvas<Object>();
	final ICanvas<Object> canvas = new XCanvas<Object>();
	final String[] expectedCanvasStr = new String[] {
			"oooooooooooooooxxxxx",
			"xxxxxxooooooooox   x",
			"     xoooooooooxxxxx",
	"     xoooooooooooooo" };

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public BucketFillTest(String testName) {
		super(testName);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		expectedCanvas.init(20, 4, ' ');
		for (int y = 0; y < expectedCanvasStr.length; y++) {
			final String row = expectedCanvasStr[y];
			for (int x = 0; x < row.length(); x++) {
				expectedCanvas.setColor(x+1, y+1, row.charAt(x));
			}
		}
		canvas.init(20, 4, ' ');
		canvas.defaultDrawColor('x');

	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(BucketFillTest.class);
	}

	public void testBucketFill() {
		Point startingPoint = new Point(1, 2);
		Point endingPoint = new Point(6, 2);
		Line.draw(canvas, startingPoint, endingPoint);

		startingPoint = new Point(6, 3);
		endingPoint = new Point(6, 4);
		Line.draw(canvas, startingPoint, endingPoint);

		startingPoint = new Point(16, 1);
		endingPoint = new Point(20, 3);

		Rectangle.draw(canvas, startingPoint, endingPoint);

		startingPoint = new Point(10, 3);
		final Character color = 'o';
		BucketFill.draw(canvas, startingPoint, color);

		assertEquals(expectedCanvas, canvas);

	}

}