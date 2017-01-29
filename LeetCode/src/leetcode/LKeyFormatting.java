package com.leetcode.accepted;

/**
 * <h1>482. License Key Formatting (M)</h1>
 * <a>https://leetcode.com/problems/license-key-formatting/</a>
 * <p>
 * Now you are given a string S, which represents a software license key which
 * we would like to format. The string S is composed of alphanumerical
 * characters and dashes. The dashes split the alphanumerical characters within
 * the string into groups. (i.e. if there are M dashes, the string is split into
 * M+1 groups). The dashes in the given string are possibly misplaced. <br>
 * We want each group of characters to be of length K (except for possibly the
 * first group, which could be shorter, but still must contain at least one
 * character). To satisfy this requirement, we will reinsert dashes.
 * Additionally, all the lower case letters in the string must be converted to
 * upper case. <br>
 * So, you are given a non-empty string S, representing a license key to format,
 * and an integer K. And you need to return the license key formatted according
 * to the description above.
 * </p>
 * <p>
 * <b>Example 1:</b><br>
 * </p>
 * 
 * <pre>
 * <b>Input:</b> S = "2-4A0r7-4k", K = 4
 * 
 * <b>Output:</b> "24A0-R74K"
 * 
 * <b>Explanation:</b> The string S has been split into two parts, each part<br> has 4 characters.
 * </pre>
 * <p>
 * <b>Example 2:</b><br>
 * </p>
 * 
 * <pre>
 * <b>Input:</b> S = "2-4A0r7-4k", K = 3
 * 
 * <b>Output:</b> "24-A0R-74K"
 * 
 * <b>Explanation:</b> The string S has been split into three parts, each part<br> has 3 characters except the first part as it could be shorter as said above.
 * </pre>
 * 
 * <p>
 * <b>Note</b><br>
 * <ol>
 * <li>The length of string S will not exceed 12,000, and K is a positive
 * integer.</li>
 * <li>String S consists only of alphanumerical characters (a-z and/or A-Z
 * and/or 0-9) and dashes(-).</li>
 * <li>String S is non-empty.</li>
 * </ol>
 * 
 * @author Sumit
 *
 */
public class LKeyFormatting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LKeyFormatting lkf = new LKeyFormatting();
		System.out.println(lkf.licenseKeyFormatting("2-4A0r7-4k", 4));
		System.out.println(lkf.licenseKeyFormatting("2-4A0r7-4k", 3));
		System.out.println(lkf.licenseKeyFormatting("--a-a-a-a--", 2));
	}

	/**
	 * LeetCode accepted solution for License Key Formatting
	 * 
	 * @param s
	 *            the String s
	 * @param k
	 *            the key length k
	 * @return the formatted License key
	 */
	public String licenseKeyFormatting(String s, int k) {
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			if (ch != '-') {
				sb.append(String.valueOf(ch).toUpperCase());
				if (counter % k == 0 && i != 0)
					sb.append("-");
				counter++;
			}
		}
		String returnVal = sb.reverse().toString();
		while (returnVal.startsWith("-")) {
			returnVal = returnVal.replaceFirst("-", "");
		}
		return returnVal;
	}

}
