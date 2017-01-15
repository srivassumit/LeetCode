package com.leetcode.contest;

/**
 * <h1>485. Max Consecutive Ones (E)</h1>
 * <p>
 * Given a binary array, find the maximum number of consecutive 1s in this
 * array. <br>
 * <b> Example 1: </b>
 * 
 * <pre>
 * <b>Input</b>: [1,1,0,1,1,1]
 * <b>Output</b>: 3
 * <b>Explanation</b>: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * </pre>
 * 
 * <b> Note: </b><br>
 * The input array will only contain 0 and 1.<br>
 * The length of input array is a positive integer and will not exceed 10,000
 * 
 * </p>
 * 
 * @author Sumit
 *
 */
public class MaxConsOnes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxConsOnes mco = new MaxConsOnes();
		int[] nums = { 1, 1, 0, 1, 1, 1 };
		System.out.println(mco.findMaxConsecutiveOnes(nums));
		int[] nums2 = {};
		System.out.println(mco.findMaxConsecutiveOnes(nums2));
		int[] nums3 = { 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 };
		System.out.println(mco.findMaxConsecutiveOnes(nums3));
		int[] nums4 = { 1, 0, 1, 1, 0, 1 };
		System.out.println(mco.findMaxConsecutiveOnes(nums4));
	}

	/**
	 * LeetCode accepted Code for Max Consecutive Ones
	 * 
	 * @param nums
	 *            the nums array
	 * @return the count of ax consecutive number of ones.
	 */
	public int findMaxConsecutiveOnes(int[] nums) {
		if (null == nums || nums.length == 0) {
			return 0;
		}
		int count = 0;
		int maxCount = 0;
		for (int i : nums) {
			if (i == 0) {
				count = 0;
			} else {
				count++;
				if (maxCount < count) {
					maxCount = count;
				}
			}
		}
		return maxCount;
	}

}
