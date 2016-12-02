package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution.
 * <p>
 * <b> Example:</b>
 * </p>
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * </p>
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * </p>
 * 
 * @author Sumit
 *
 */
public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { -3, 4, 3, 90 };
		int target = 0;
		TwoSum ts = new TwoSum();
		int[] val = ts.twoSum(nums, target);
		System.out.println(val[0] + ", " + val[1]);
	}

	/**
	 * LeetCode TwoSum Accepted solution
	 * 
	 * @param nums
	 *            array of integers
	 * @param target
	 *            the specified sum
	 * @return an array of length 2 containing the indices of required values in
	 *         nums array
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] returnVal = new int[2];
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (m.containsKey((target - nums[i]))) {
				returnVal[0] = m.get(target - nums[i]);
				returnVal[1] = i;
				break;
			} else {
				m.put(nums[i], i);
			}
		}
		return returnVal;
	}

}
