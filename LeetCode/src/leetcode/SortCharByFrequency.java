package com.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
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