package com.leetcode.accepted;

/**
 * <h1>58. Length of Last Word (E)</h1>
 * <p>
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string. <br>
 * If the last word does not exist, return 0. <br>
 * <b>Note</b>: A word is defined as a character sequence consists of non-space
 * characters only. <br>
 * For example,<br>
 * Given s = <mark style="background-color:#CCCCCC"> "Hello World" </mark>,<br>
 * return <mark style="background-color:#CCCCCC"> 5 </mark>.
 * </p>
 * 
 * @author Sumit
 *
 */
public class LengthLastWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LengthLastWord llw = new LengthLastWord();
		System.out.println(llw.lengthOfLastWord("Hello World! This is Sumit Srivastava"));
	}

	/**
	 * LeetCode accepted solution for Length of Last Word
	 * 
	 * @param s
	 *            the string
	 * @return the length of last word in s
	 */
	public int lengthOfLastWord(String s) {
		if (s != null && s.trim().length() > 0) {
			if (s.contains(" ")) {
				String tokens[] = s.split(" ");
				return tokens[tokens.length - 1].length();
			} else {
				return s.length();
			}
		}
		return 0;
	}

}
