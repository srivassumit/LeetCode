package com.leetcode.accepted;

import java.util.Arrays;

/**
 * <h1>137. Single Number2 (M)</h1>
 * <p>
 * Given an array of integers, every element appears three times except for one,
 * which appears exactly once. Find that single one. <br>
 * <b> Note:</b><br>
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * </p>
 * 
 * @author Sumit
 *
 */
public class SingleNumber2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleNumber2 sn2 = new SingleNumber2();
		int[] nums = { 1, 1, 5, 5, 6, 7, 8, 6, 7, 8, 8, 7, 1, 3, 5, 6 };
		System.out.println(sn2.singleNumber(nums));
	}

	/**
	 * LeetCode accepted solution for Single Number 2
	 * 
	 * @param numst
	 *            the array of numbers
	 * @return the single number
	 */
	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		for (i = 0; i < nums.length - 1; i += 3) {
			if (nums[i + 1] != nums[i] || nums[i + 2] != nums[i]) {
				break;
			}
		}
		return nums[i];
	}

}
