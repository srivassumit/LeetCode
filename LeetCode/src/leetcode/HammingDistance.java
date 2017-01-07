package com.leetcode.accepted;

/**
 * <h1>461. Hamming Distance (E)</h1>
 * <p>
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different. <br>
 * Given two integers x and y, calculate the Hamming distance. <br>
 * <b> Note:</b> 0 ≤ x, y < 2^31. <br>
 * <b> Example: </b>
 * 
 * <pre>
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * </pre>
 * 
 * The above arrows point to positions where the corresponding bits are
 * different.
 * </p>
 * 
 * @author Sumit
 */
public class HammingDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HammingDistance hd = new HammingDistance();
		int x = 0;
		int y = 10;
		System.out.println(hd.hammingDistance(x, y));
	}

	/**
	 * LeetCode accepted solution for Hamming Distance
	 * 
	 * @param x
	 *            the first integer
	 * @param y
	 *            the second integer
	 * @return the hamming distance between x and y
	 */
	public int hammingDistance(int x, int y) {
		if (x == y) {
			return 0;
		}
		int count = 0;
		String sx = Integer.toBinaryString(x);
		String sy = Integer.toBinaryString(y);
		int smallerLength = 0;
		if (sx.length() > sy.length()) {
			smallerLength = sy.length();
			for (int i = 0; i < sx.length() - smallerLength; i++) {
				sy = "0".concat(sy);
			}
		} else {
			smallerLength = sx.length();
			for (int i = 0; i < sy.length() - smallerLength; i++) {
				sx = "0".concat(sx);
			}
		}
		smallerLength = sx.length() > sy.length() ? sy.length() : sx.length();
		for (int i = 0; i < smallerLength; i++) {
			if (sx.charAt(i) != sy.charAt(i)) {
				count++;
			}
		}
		return count;
	}

}
