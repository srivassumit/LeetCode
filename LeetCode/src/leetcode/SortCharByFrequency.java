package com.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>Sort Characters By Frequency</h1> Given a string, sort it in decreasing
 * order based on the frequency of characters.
 * <p>
 * <b> Example 1: </b>
 * </p>
 * <p>
 * Input: "tree"
 * </p>
 * <p>
 * Output: "eert"
 * </p>
 * <p>
 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e'
 * must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * </p>
 * <p>
 * <b> Example 2: </b>
 * </p>
 * <p>
 * Input: "cccaaa"
 * </p>
 * <p>
 * Output: "cccaaa"
 * </p>
 * <p>
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid
 * answer. Note that "cacaca" is incorrect, as the same characters must be
 * together.
 * </p>
 * <p>
 * <b> Example 3: </b>
 * </p>
 * <p>
 * Input: "Aabb"
 * </p>
 * <p>
 * Output: "bbAa"
 * </p>
 * <p>
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note
 * that 'A' and 'a' are treated as two different characters.
 * </p>
 * 
 * @author Sumit
 */
public class SortCharByFrequency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortCharByFrequency scbf = new SortCharByFrequency();
		System.out.println(scbf.frequencySort(args[0]));
		System.out.println(scbf.frequencySort("tree"));
		System.out.println(scbf.frequencySort("cccaaa"));
		System.out.println(scbf.frequencySort("aAbb"));
	}

	/**
	 * LeetCode Accepted Solution for Sort Characters By Frequency
	 * 
	 * @param s
	 *            the string to be sorted
	 * @return the sorted string
	 */
	private String frequencySort(String s) {
		StringBuilder sb = new StringBuilder();
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (!frequencyMap.containsKey(c))
				frequencyMap.put(c, 0);
			frequencyMap.put(c, frequencyMap.get(c) + 1);
		}
		Queue<Map.Entry<Character, Integer>> pQueque = new PriorityQueue<Map.Entry<Character, Integer>>(
				frequencyMap.size(), new Comparator<Map.Entry<Character, Integer>>() {
					@Override
					public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
						return e2.getValue() - e1.getValue();
					}
				});
		for (Map.Entry<Character, Integer> e : frequencyMap.entrySet()) {
			pQueque.add(e);
		}
		while (!pQueque.isEmpty()) {
			Map.Entry<Character, Integer> e = pQueque.remove();
			for (int i = 0; i < e.getValue(); i++) {
				sb.append(e.getKey());
			}
		}
		return sb.toString();
	}

}