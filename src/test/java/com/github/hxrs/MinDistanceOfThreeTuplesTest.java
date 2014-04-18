package com.github.hxrs;

import static org.testng.Assert.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MinDistanceOfThreeTuplesTest {
	private final static Logger logger = LoggerFactory
			.getLogger(MinDistanceOfThreeTuplesTest.class);

	@DataProvider(name = "testNPE")
	public Object[][] testNPEData() {
		return new Object[][] { { null, new int[0], new int[0] },
				{ new int[0], null, new int[0] },
				{ new int[0], new int[0], null } };
	}

	@Test(dataProvider = "testNPE", expectedExceptions = NullPointerException.class)
	public void testFindMinDistanceElmentsNPE(int[] a, int[] b, int[] c) {
		MinDistanceOfThreeTuples.findMinDistanceElments(a, b, c);
	}

	@DataProvider(name = "testRTE")
	public Object[][] testRTEData() {
		return new Object[][] { { new int[0], new int[1], new int[1] },
				{ new int[1], new int[0], new int[1] },
				{ new int[1], new int[1], new int[0] } };
	}

	@Test(dataProvider = "testRTE", expectedExceptions = RuntimeException.class)
	public void testFindMinDistanceElmentsRTE(int[] a, int[] b, int[] c) {
		MinDistanceOfThreeTuples.findMinDistanceElments(a, b, c);
	}

	@DataProvider(name = "testData")
	public Object[][] testData() {
		int[] a1 = new int[] { 2, 3, 4 };
		int[] b1 = new int[] { 2, 5, 8 };
		int[] c1 = new int[] { 2, 6, 9 };
		int[] output1 = new int[] { 2, 2, 2 };

		int[] a2 = new int[] { 2, 7, 6 };
		int[] b2 = new int[] { 3, 7, 8 };
		int[] c2 = new int[] { 6, 7, 9 };
		int[] output2 = new int[] { 7, 7, 7 };

		int[] a3 = new int[] { 2, 4, 8 };
		int[] b3 = new int[] { 3, 5, 8 };
		int[] c3 = new int[] { 6, 7, 8 };
		int[] output3 = new int[] { 8, 8, 8 };

		int[] a4 = new int[] { 8, 10, 11 };
		int[] b4 = new int[] { 3, 8, 9 };
		int[] c4 = new int[] { 6, 7, 8 };
		int[] output4 = new int[] { 8, 8, 8 };

		int[] a5 = new int[] { 2, 4, 8 };
		int[] b5 = new int[] { 4, 5, 7 };
		int[] c5 = new int[] { 3, 4, 9 };
		int[] output5 = new int[] { 4, 4, 4 };

		return new Object[][] { { a1, b1, c1, output1 },
				{ a2, b2, c2, output2 }, { a3, b3, c3, output3 },
				{ a4, b4, c4, output4 }, { a5, b5, c5, output5 } };
	}

	@Test(dataProvider = "testData")
	public void testFindMinDistanceElments(int[] a, int[] b, int[] c,
			int[] output) {
		logger.info("input: {}\n {} \n {}  \noutput: {}", a, b, c, output);
		assertEquals(output,
				MinDistanceOfThreeTuples.findMinDistanceElments(a, b, c),
				"the output is not correct!");
	}
}
