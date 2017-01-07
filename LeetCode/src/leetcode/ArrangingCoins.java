package com.leetcode.accepted;

/**
 * <h1>441. Arranging Coins (E)</h1>
 * <p>
 * You have a total of n coins that you want to form in a staircase shape, where
 * every k-th row must have exactly k coins. <br>
 * Given n, find the total number of full staircase rows that can be formed.
 * <br>
 * n is a non-negative integer and fits within the range of a 32-bit signed
 * integer. <br>
 * </p>
 * <p>
 * <b> Example 1:</b>
 * </p>
 * 
 * <pre>
 * n = 5
 * 
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 
 * Because the 3rd row is incomplete, we return 2.
 * </pre>
 * <p>
 * <b> Example 2:</b>
 * </p>
 * 
 * <pre>
 * 
 * n = 8
 * 
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 
 * Because the 4th row is incomplete, we return 3.
 * </pre>
 * 
 * @author Sumit
 *
 */
public class ArrangingCoins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrangingCoins ac = new ArrangingCoins();
		System.out.println(ac.arrangeCoins(8));
		System.out.println(ac.arrangeCoins(5));
		System.out.println(ac.arrangeCoins(1));
		System.out.println(ac.arrangeCoins(0));
	}

	/**
	 * LeetCode accepted solution for arrangeCoins
	 * 
	 * @param n
	 *            the number of coins
	 * @return the number of rows that can be formed.
	 */
	public int arrangeCoins(int n) {
		return (int) Math.floor((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
	}
}
