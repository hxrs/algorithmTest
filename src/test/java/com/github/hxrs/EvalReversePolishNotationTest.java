package com.github.hxrs;

import static org.testng.Assert.assertEquals;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EvalReversePolishNotationTest {
	private final static Logger logger = LoggerFactory
			.getLogger(EvalReversePolishNotationTest.class);

	@DataProvider(name = "testData")
	public Object[][] testData() {
		return new Object[][] { { new String[] { "1" }, "1" },
				{ new String[] { "1", "2", "+", "3", "*" }, "9" },
				{ new String[] { "0", "2", "-" }, "-2" },
				{ new String[] { "4", "2", "*" }, "8" },
				{ new String[] { "-4", "2", "*" }, "-8" },
				{ new String[] { "4", "2", "/" }, "2" },
				{ new String[] { "4", "-2", "/" }, "-2" },
				{ new String[] { "2", "4", "/" }, "0" }, };
	}

	@Test(dataProvider = "testData")
	public void testEvalRPN(String[] rpnArray, String result) {
		logger.info("input: {}  output: {}", Arrays.toString(rpnArray), result);
		assertEquals(Integer.parseInt(result),
				EvalReversePolishNotation.evalRPN(rpnArray),
				"result is not correct!");
	}
}
