package com.leetcode.accepted;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <h1>387. First Unique Character in a String (E)</h1>
 * <p>
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * </p>
 * <p>
 * <b> Examples:</b>
 * 
 * <pre>
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * </pre>
 * 
 * <b> Note:</b> You may assume the string contain only lowercase letters.
 * </p>
 * 
 * @author Sumit
 */
public class FirstUniqueChar {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FirstUniqueChar fuc = new FirstUniqueChar();
		String s = "leetcode";
		String s1 = "loveleetcode";
		System.out.println(fuc.firstUniqChar(s));
		System.out.println(fuc.firstUniqChar(s1));
	}

	/**
	 * LeetCode accepted solution for First Unique Character in a String
	 * 
	 * @param s
	 * @return
	 */
	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		} else {
			Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
			for (char ch : s.toCharArray()) {
				if (map.containsKey(ch)) {
					map.put(ch, map.get(ch) + 1);
				} else {
					map.put(ch, 1);
				}
			}
			for (Map.Entry<Character, Integer> e : map.entrySet()) {
				if (e.getValue() == 1) {
					return s.indexOf(e.getKey());
				}
			}
		}
		return -1;
	}

}
