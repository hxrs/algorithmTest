package com.github.hxrs;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContinuousSubSetTest {
	private final static Logger logger = LoggerFactory
			.getLogger(ContinuousSubSetTest.class);

	@DataProvider(name = "testData")
	public Object[][] testData() {
		int[] emptyArray = new int[] {};
		int[] oneElementArray = new int[] { 2 };
		int[] twoElementsArray1 = new int[] { 2, 4 };
		int[] twoElementsArray2 = new int[] { 4, 2 };
		int[] twoElementsArray3 = new int[] { 2, 3 };
		int[] moreElementsArray3 = new int[] { 15, 7, 12, 6, 14, 13, 9, 11 };
		return new Object[][] { { null, emptyArray },
				{ emptyArray, emptyArray },
				{ oneElementArray, oneElementArray },
				{ twoElementsArray1, new int[] { 2 } },
				{ twoElementsArray2, new int[] { 2 } },
				{ twoElementsArray3, new int[] { 2, 3 } },
				{ moreElementsArray3, new int[] { 11, 12, 13, 14, 15 } } };
	}

	@Test(dataProvider = "testData")
	public void testFindMaxContinuousSubSet(int[] inputArray, int[] subset) {
		logger.info("input: {}   output: {}", Arrays.toString(inputArray),
				Arrays.toString(subset));
		assertEquals(subset,
				ContinuousSubSet.findMaxContinuousSubSet(inputArray),"subset is not correct!");
	}
}
