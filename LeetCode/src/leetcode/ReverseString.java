package com.leetcode.accepted;

/**
 * <h1>344. Reverse String (E)</h1>
 * <p>
 * Write a function that takes a string as input and returns the string
 * reversed.
 * </p>
 * <p>
 * <b> Example:</b>
 * </p>
 * <p>
 * Given s = "hello", return "olleh".
 * </p>
 * 
 * @author Sumit
 *
 */
public class ReverseString {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		System.out.println(rs.reverseString("helhednasdknasodnoiasdoaisd"));
	}

	/**
	 * LeetCode Accepted solution for Reverse String
	 * 
	 * @param s
	 *            the string to be reversed
	 * @return the reversed string
	 */
	public String reverseString(String s) {
		if (null == s) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (char c : s.toCharArray()) {
			sb.append(c);
		}
		return sb.reverse().toString();
	}
}
