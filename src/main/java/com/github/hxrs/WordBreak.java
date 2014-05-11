package com.github.hxrs;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, <br>
 * determine if s can be segmented into a space-separated sequence of one or
 * more dictionary words.<br>
 * For example, given<br>
 * s = "leetcode",<br>
 * dict = ["leet", "code"].<br>
 * Return true because "leetcode" can be segmented as "leet code".<br>
 * 
 * @author Huan
 * 
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || dict == null || dict.size() == 0) {
			return false;
		}

		int length = s.length();
		boolean[][] seg = new boolean[length][length + 1];
		for (int len = 1; len < length + 1; len++) {
			for (int i = 0; i < length; i++) {
				if (i + len > length) {
					break;
				}
				String subStr = s.substring(i, i + len);
				if (dict.contains(subStr)) {
					seg[i][len] = true;
					continue;
				}
				for (int k=1; k<len; k++) {
					if (seg[i][k] && seg[i+k][len-k]) {
						seg[i][len] = true;
						break;
					}
				}
			}
		}
		return seg[0][length];
	}
	
	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> dict = new HashSet<String> ();
		dict.add("leet");
		dict.add("code");
		System.out.println(new WordBreak().wordBreak(s, dict));
	}
}
