package com.leetcode.accepted;

/**
 * <h1>35. Search insert Position (M)</h1>
 * <p>
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order. <br>
 * <br>
 * You may assume no duplicates in the array. <br>
 * <br>
 * Here are few examples.
 * </p>
 * 
 * <pre>
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * </pre>
 * 
 * @author Sumit
 *
 */
public class SearchInsertPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchInsertPosition sip = new SearchInsertPosition();
		int[] nums = { 1, 3, 5, 6 };
		System.out.println(sip.searchInsert(nums, 5));// 2
		System.out.println(sip.searchInsert(nums, 2));// 1
		System.out.println(sip.searchInsert(nums, 7));// 4
		System.out.println(sip.searchInsert(nums, 0));// 0
	}

	/**
	 * LeetCode accepted solution for Search Insert Position
	 * 
	 * @param nums
	 *            the array of integers
	 * @param target
	 *            the target value
	 * @return the insert position
	 */
	public int searchInsert(int[] nums, int target) {
		int pos = 0;
		if (target < nums[0]) {
			pos = 1;
		} else if (target > nums[nums.length - 1]) {
			pos = nums.length + 1;
		} else {
			while (nums[pos++] < target) {
				continue;
			}
		}
		return pos - 1;
	}

}
