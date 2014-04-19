package com.github.hxrs;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.hxrs.MaxNumberPonitsOnSameLine.Point;

public class MaxNumberPonitsOnSameLineTest {
	private final static Logger logger = LoggerFactory
			.getLogger(MaxNumberPonitsOnSameLineTest.class);

	@DataProvider(name = "testData")
	public Object[][] testData() {
		Point pa = new Point(0, 0);
		Point pb = new Point(1, 1);
		Point pc = new Point(2, 2);
		Point pd = new Point(3, 4);
		Point pe = new Point(6, 8);
		Point pf = new Point(6, 9);
		Point pg = new Point(7, 9);
		Point ph = new Point(8, 9);
		
		Point p1 = new Point(2, 3);
		Point p2 = new Point(3, 3);
		Point p3 = new Point(-5, 3);
		return new Object[][] { { new Point[] {}, 0 },
				{ new Point[] { pa, pa }, 2 }, { new Point[] { pa, pb }, 2 },
				{ new Point[] { pb, pd }, 2 },
				{ new Point[] { pa, pa, pb, pb }, 4 },
				{ new Point[] { pa, pb, pc }, 3 },
				{ new Point[] { pa, pb, pd }, 2 },
				{ new Point[] { pa, pd, pe }, 3 },
				{ new Point[] { pb, pe, pf }, 2 },
				{ new Point[] { pb, pf, pg }, 2 },
				{ new Point[] { pf, pg, ph }, 3 },
				{ new Point[] { p1, p2, p3 }, 3 }};
	}

	@Test(dataProvider = "testData")
	public void testGetMaxNumberOfPointsOnSameLine(Point[] points, int maxNum) {
		logger.info("input: {}, output: {}", Arrays.toString(points), maxNum);
		int actualValue = MaxNumberPonitsOnSameLine
				.getMaxNumberOfPointsOnSameLine(points);
		assertEquals(actualValue, maxNum, "the maxNum is not correct!");
	}
}
