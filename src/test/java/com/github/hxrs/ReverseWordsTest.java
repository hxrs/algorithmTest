package com.github.hxrs;

import org.testng.annotations.Test;

public class ReverseWordsTest {

  @Test(expectedExceptions = NullPointerException.class)
  public void testReverseWords() {
	  String s1 = null;
	  ReverseWords.reverseWords(s1);
  }
}
