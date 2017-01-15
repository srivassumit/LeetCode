package com.leetcode.contest;

/**
 * <h1>487. Max Consecutive Ones II (M)</h1>
 * <p>
 * Given a binary array, find the maximum number of consecutive 1s in this array
 * if you can flip at most one 0.<br>
 * <b> Example 1: </b>
 * 
 * <pre>
 * <b>Input</b>: [1,0,1,1,0]
 * <b>Output</b>: 4
 * <b>Explanation</b>: Flip the first zero will get the the maximum number of consecutive 1s.
 *     After flipping, the maximum number of consecutive 1s is 4.
 * </pre>
 * 
 * <b> Note: </b><br>
 * The input array will only contain 0 and 1.<br>
 * The length of input array is a positive integer and will not exceed 10,000
 * </p>
 * 
 * @author Sumit
 *
 */
public class MaxConsOnes2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxConsOnes2 mco = new MaxConsOnes2();
		int[] nums = { 1, 1, 0, 1, 1, 1 };
		System.out.println(mco.findMaxConsecutiveOnes(nums));
		int[] nums2 = {};
		System.out.println(mco.findMaxConsecutiveOnes(nums2));
		int[] nums3 = { 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 };
		System.out.println(mco.findMaxConsecutiveOnes(nums3));
		int[] nums4 = { 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1 };
		System.out.println(mco.findMaxConsecutiveOnes(nums4));
	}

	public int findMaxConsecutiveOnes(int[] nums) {
		if (null == nums || nums.length == 0) {
			return 0;
		}
		int count = 0;
		int maxCount = 0;
		int flippedCount = 0;
		for (int i : nums) {
			count++;
			if (i == 0) {
				flippedCount = count;
				count = 0;
			}
			if ((count + flippedCount) > maxCount) {
				maxCount = count + flippedCount;
			}
		}
		return maxCount;
	}

}
