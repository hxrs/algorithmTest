package com.github.hxrs;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContinuousSubSetTest {
	private final static Logger logger = LoggerFactory
			.getLogger(ContinuousSubSetTest.class);

	@Test
	public void testFindMaxContinuousSubSet() {
		logger.info("=============test findMaxContinuousSubSet=================");
		int[] result;
		int[] nullArray = null;
		logger.info("input: {}", nullArray);
		result = ContinuousSubSet.findMaxContinuousSubSet(nullArray);
		logger.info("output: {}", result);
		Assert.assertEquals(result.length, 0);

		int[] emptyArray = new int[] {};
		logger.info("input: {}", Arrays.toString(emptyArray));
		result = ContinuousSubSet.findMaxContinuousSubSet(emptyArray);
		logger.info("output: {}", result);
		Assert.assertEquals(result.length, 0);

		int[] oneElementArray = new int[] {2};
		logger.info("input: {}", Arrays.toString(oneElementArray));
		result = ContinuousSubSet.findMaxContinuousSubSet(oneElementArray);
		logger.info("output: {}", result);
		Assert.assertEquals(result.length, 1);

		int[] twoElementsArray = new int[] {2, 4};
		logger.info("input: {}", Arrays.toString(twoElementsArray));
		result = ContinuousSubSet.findMaxContinuousSubSet(twoElementsArray);
		logger.info("output: {}", result);
		Assert.assertEquals(result.length, 1);

		twoElementsArray = new int[] {4, 2};
		logger.info("input: {}", Arrays.toString(twoElementsArray));
		result = ContinuousSubSet.findMaxContinuousSubSet(twoElementsArray);
		logger.info("output: {}", result);
		Assert.assertEquals(result.length, 1);

		twoElementsArray = new int[] {2, 3};
		logger.info("input: {}", Arrays.toString(twoElementsArray));
		result = ContinuousSubSet.findMaxContinuousSubSet(twoElementsArray);
		logger.info("output: {}", result);
		Assert.assertEquals(result.length, 2);

		int[] manyElementsArray = new int[] {15, 7, 12, 6, 14, 13, 9, 11};
		logger.info("input: {}", Arrays.toString(manyElementsArray));
		result = ContinuousSubSet.findMaxContinuousSubSet(manyElementsArray);
		logger.info("output: {}", result);
		Assert.assertEquals(result.length, 5);
	}
}
