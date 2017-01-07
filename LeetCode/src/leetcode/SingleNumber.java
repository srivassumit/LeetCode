package com.leetcode.accepted;

import java.util.Arrays;

/**
 * <h1>136. Single Number (E)</h1>
 * <p>
 * Given an array of integers, every element appears twice except for one. Find
 * that single one. <br>
 * <b> Note:</b><br>
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * </p>
 * 
 * @author Sumit
 *
 */
public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleNumber sn = new SingleNumber();
		int[] nums = { 1, 5, 6, 7, 8, 8, 7, 1, 9, 5, 6 };
		System.out.println(sn.singleNumber(nums));
	}

	/**
	 * LeetCode accepted solution for Single Number
	 * 
	 * @param numst
	 *            the array of numbers
	 * @return the single number
	 */
	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		for (i = 0; i < nums.length - 1; i += 2) {
			if (nums[i + 1] != nums[i]) {
				break;
			}
		}
		return nums[i];
	}

}
