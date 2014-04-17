package com.github.hxrs;

import static org.testng.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReverseWordsTest {
  private final static Logger logger = LoggerFactory
			.getLogger(ReverseWordsTest.class);

  @Test(expectedExceptions = NullPointerException.class)
  public void testReverseWords_Null() {
	  String s1 = null;
	  ReverseWords.reverseWords(s1);
  }

  @DataProvider(name = "testdata")
  public Object[][] testData() {
	  return new Object[][] {
			  {"", ""},
			  {" ", ""},
			  {"1", "1"},
			  {" 1", "1"},
			  {"1 ", "1"},
			  {"Hello World", "World Hello"},
			  {"Hello World ", "World Hello"},
			  {" Hello World", "World Hello"},
			  {" Hello World ", "World Hello"},
			  {"Hello    World", "World Hello"},
			  {" Hello    World ", "World Hello"},
	  };
  }

  @Test(dataProvider = "testdata")
  public void testReverseWords_Empty(String input, String output) {
	  logger.info("input: {}  output: {}", input, output);
	  assertEquals(output, ReverseWords.reverseWords(input), "output is not correct!");
  }
}
