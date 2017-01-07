package com.leetcode.accepted;

import java.util.Arrays;

/**
 * <h1>260. Single Number 3 (M)</h1>
 * <p>
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * </p>
 * <p>
 * For example: <br>
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5]. <br>
 * </p>
 * <p>
 * <b> Note:</b><br>
 * 
 * The order of the result is not important. So in the above example, [5, 3] is
 * also correct.<br>
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant space complexity?
 * </p>
 * 
 * @author Sumit
 *
 */
public class SingleNumber3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleNumber3 sn3 = new SingleNumber3();
		int[] nums = { 1, 2, 1, 3, 2, 5 };
		printArray(sn3.singleNumber(nums));
	}

	/**
	 * LeetCode accepted solution for Single Number 3
	 * 
	 * @param numst
	 *            the array of numbers
	 * @return the single number
	 */
	public int[] singleNumber(int[] nums) {
		int[] arr = new int[2];
		Arrays.sort(nums);
		int i = 0;
		int k = 0;
		for (i = 0; i < nums.length - 1; i += 2) {
			if (nums[i + 1] != nums[i]) {
				arr[k++] = nums[i];
				i--;
				if (k > 1)
					break;
			}
		}
		if (nums[nums.length - 1] != nums[nums.length - 2]) {
			arr[1] = nums[nums.length - 1];
		}
		return arr;
	}

	private static void printArray(int[] list) {
		for (int item : list) {
			if (item != 0)
				System.out.print(item + ", ");
		}
		System.out.println("");
	}

}
