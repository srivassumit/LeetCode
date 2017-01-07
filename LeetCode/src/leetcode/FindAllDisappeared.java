package com.leetcode.accepted;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>448. Find All Numbers Disappeared in an Array (E)</h1>
 * <p>
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once. <br>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <br>
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * </p>
 * <p>
 * <b> Example:</b>
 * 
 * <pre>
 * 
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [5,6]
 * </pre>
 * </p>
 * 
 * @author Sumit
 *
 */
public class FindAllDisappeared {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindAllDisappeared fad = new FindAllDisappeared();
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		printList(fad.findDisappearedNumbers(nums));
	}

	/**
	 * LeetCode accepted solution for Find All Numbers Disappeared in an Array
	 * 
	 * @param nums
	 *            the input array
	 * @return the list of missing numbers
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> missingList = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0) {
				nums[index] = -1 * nums[index];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				missingList.add(i + 1);
			}
		}
		return missingList;
	}

	private static void printList(List<Integer> list) {
		for (int item : list) {
			System.out.print(item + ", ");
		}
		System.out.println("");
	}

}
