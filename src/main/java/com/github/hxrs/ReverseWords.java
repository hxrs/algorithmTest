package com.github.hxrs;

/**
 * Given an input string, reverse the string word by word. For example,<br>
 * Given s = "the sky is blue", return "blue is sky the".
 * @author huanxiao
 *
 */
public class ReverseWords {
    public static String reverseWords(String s) {
    	// s is null
    	if (s == null) {
    		throw new NullPointerException("input string is null");
    	}
    	String trimStr = s.trim();
    	// s is empty
    	if ("".equals(trimStr)) {
    		return "";
    	}
    	String[] strs = trimStr.split("\\s+");
    	StringBuilder sb = new StringBuilder();
    	for (int i=strs.length-1; i>=0; i--) {
    		sb.append(strs[i]);
    		if(i != 0) {
    			sb.append(" ");
    		}
    	}
    	return sb.toString();
    }
}
