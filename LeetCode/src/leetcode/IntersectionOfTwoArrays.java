package com.leetcode.accepted;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>Intersection of Two Arrays</h1>
 * <p>
 * Given two arrays, write a function to compute their intersection.
 * </p>
 * <p>
 * <b> Example:</b>
 * </p>
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * <b> Note: </b> Each element in the result must be unique. The result can be
 * in any order.
 * </p>
 * 
 * @author Sumit
 */
public class IntersectionOfTwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntersectionOfTwoArrays iota = new IntersectionOfTwoArrays();
		int[] nums1 = { 1, 2, 2, 1, 2 };
		int[] nums2 = { 2, 2, 1 };
		int[] intersection = iota.intersection(nums1, nums2);
		for (int i : intersection) {
			System.out.print(i + ", ");
		}
		System.out.println("");
	}

	/**
	 * LeetCode accepted solution for Intersection of Two Arrays
	 * 
	 * @param nums1
	 *            the first integer array
	 * @param nums2
	 *            the second integer array
	 * @return the intersection integer array
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> intersectionSet = new HashSet<Integer>();
		int[] returnVal;
		if (nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		} else {
			for (int i = 0; i < nums1.length; i++) {
				for (int j = 0; j < nums2.length; j++) {
					if (nums1[i] == nums2[j]) {
						intersectionSet.add(nums1[i]);
						break;
					}
				}
			}
			returnVal = new int[intersectionSet.size()];
			int i = 0;
			for (int val : intersectionSet) {
				returnVal[i++] = val;
			}
			return returnVal;
		}
	}

}
