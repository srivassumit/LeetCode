package com.leetcode.accepted;

/**
 * <h1>338. Counting Bits (M)</h1>
 * <p>
 * Given a non negative integer number num. For every numbers i in the range 0 ≤
 * i ≤ num calculate the number of 1's in their binary representation and return
 * them as an array.
 * </p>
 * <p>
 * <b> Example:</b>
 * 
 * <pre>
 * For num = 5 you should return [0,1,1,2,1,2].
 * </pre>
 * </p>
 * <p>
 * <b> Follow up:</b>
 * </p>
 * <p>
 * It is very easy to come up with a solution with run time
 * O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a
 * single pass? <br>
 * Space complexity should be O(n). <br>
 * Can you do it like a boss? Do it without using any builtin function like
 * __builtin_popcount in c++ or in any other language.
 * </p>
 * <p>
 * <b> Hint:</b>
 * </p>
 * <p>
 * 
 * You should make use of what you have produced already.<br>
 * Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to
 * generate new range from previous.<br>
 * Or does the odd/even status of the number help you in calculating the number
 * of 1s?<br>
 * 
 * </p>
 * 
 * @author Sumit
 */
public class CountingBits {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CountingBits cb = new CountingBits();
		int num = 50000;
		int[] arr = cb.countBits(num);
		System.out.print("[");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		System.out.print("]");
		System.out.println("");
	}

	/**
	 * LeetCode accepted solution for Counting Bits
	 * 
	 * @param num
	 *            the number
	 * @return the count of 1s in bits representation
	 */
	public int[] countBits(int num) {
		int[] arr = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			int count = 0;
			String bits = Integer.toBinaryString(i);
			for (char ch : bits.toCharArray()) {
				if (ch == '1') {
					count++;
				}
			}
			arr[i] = count;
		}
		return arr;
	}

}
