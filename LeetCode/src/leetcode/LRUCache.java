package com.leetcode.accepted;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <h1>146. LRU Cache (H)</h1>
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set. <br>
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.<br>
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * </p>
 * 
 * @author Sumit
 *
 */
public class LRUCache {

	private Map<Integer, Integer> cache;
	private int capacity;

	/**
	 * LeetCode Accepted Solution for LRUCache
	 * 
	 * @param capacity
	 *            the capacity of LRUCache
	 */
	public LRUCache(int capacity) {
		this.cache = new LinkedHashMap<Integer, Integer>(capacity);
		this.capacity = capacity;
	}

	public int get(int key) {
		Integer value = cache.get(key);
		if (null == value) {
			return -1;
		}
		cache.remove(key);
		cache.put(key, value);
		return value;
	}

	public void set(int key, int value) {
		if (capacity <= 0) {
			return;
		}
		cache.remove(key);
		cache.put(key, value);
		if (cache.size() > capacity) {
			cache.remove(cache.entrySet().iterator().next().getKey());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("---------------------------TestCase1---------------------------");
		tc1();
		System.out.println("---------------------------TestCase2---------------------------");
		tc2();
		System.out.println("---------------------------TestCase3---------------------------");
		tc3();
		System.out.println("---------------------------TestCase4---------------------------");
		tc4();
		System.out.println("---------------------------TestCase5---------------------------");
		tc5();
	}

	private static void tc1() {
		LRUCache cache = new LRUCache(2);
		cache.set(1, 1);
		cache.set(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.set(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3.
		cache.set(4, 4); // evicts key 1.
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4
	}

	private static void tc2() {
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(1, 1);
		cache.set(2, 3);
		cache.set(4, 1);
		System.out.println(cache.get(1)); // -1
		System.out.println(cache.get(2)); // 3
	}

	private static void tc3() {
		LRUCache cache = new LRUCache(2);
		cache.set(3, 1);
		cache.set(2, 1);
		cache.set(2, 2);
		cache.set(4, 4);
		System.out.println(cache.get(2)); // 2
	}

	private static void tc4() {
		LRUCache cache = new LRUCache(0);
		cache.set(0, 0);
		System.out.println(cache.get(0)); // -1
	}

	private static void tc5() {
		LRUCache cache = new LRUCache(10);
		String ss = null;
		System.out.println(ss);
		String[] arr = { "set", "set", "set", "set", "set", "get", "set", "get", "get", "set", "get", "set", "set",
				"set", "get", "set", "get", "get", "get", "get", "set", "set", "get", "get", "get", "set", "set", "get",
				"set", "get", "set", "get", "get", "get", "set", "set", "set", "get", "set", "get", "get", "set", "set",
				"get", "set", "set", "set", "set", "get", "set", "set", "get", "set", "set", "get", "set", "set", "set",
				"set", "set", "get", "set", "set", "get", "set", "get", "get", "get", "set", "get", "get", "set", "set",
				"set", "set", "get", "set", "set", "set", "set", "get", "get", "get", "set", "set", "set", "get", "set",
				"set", "set", "get", "set", "set", "set", "get", "get", "get", "set", "set", "set", "set", "get", "set",
				"set", "set", "set", "set", "set", "set" };
		int[][] arr2 = { { 10, 13 }, { 3, 17 }, { 6, 11 }, { 10, 5 }, { 9, 10 }, { 13 }, { 2, 19 }, { 2 }, { 3 },
				{ 5, 25 }, { 8 }, { 9, 22 }, { 5, 5 }, { 1, 30 }, { 11 }, { 9, 12 }, { 7 }, { 5 }, { 8 }, { 9 },
				{ 4, 30 }, { 9, 3 }, { 9 }, { 10 }, { 10 }, { 6, 14 }, { 3, 1 }, { 3 }, { 10, 11 }, { 8 }, { 2, 14 },
				{ 1 }, { 5 }, { 4 }, { 11, 4 }, { 12, 24 }, { 5, 18 }, { 13 }, { 7, 23 }, { 8 }, { 12 }, { 3, 27 },
				{ 2, 12 }, { 5 }, { 2, 9 }, { 13, 4 }, { 8, 18 }, { 1, 7 }, { 6 }, { 9, 29 }, { 8, 21 }, { 5 },
				{ 6, 30 }, { 1, 12 }, { 10 }, { 4, 15 }, { 7, 22 }, { 11, 26 }, { 8, 17 }, { 9, 29 }, { 5 }, { 3, 4 },
				{ 11, 30 }, { 12 }, { 4, 29 }, { 3 }, { 9 }, { 6 }, { 3, 4 }, { 1 }, { 10 }, { 3, 29 }, { 10, 28 },
				{ 1, 20 }, { 11, 13 }, { 3 }, { 3, 12 }, { 3, 8 }, { 10, 9 }, { 3, 26 }, { 8 }, { 7 }, { 5 },
				{ 13, 17 }, { 2, 27 }, { 11, 15 }, { 12 }, { 9, 19 }, { 2, 15 }, { 3, 16 }, { 1 }, { 12, 17 }, { 9, 1 },
				{ 6, 19 }, { 4 }, { 5 }, { 5 }, { 8, 1 }, { 11, 7 }, { 5, 2 }, { 9, 28 }, { 1 }, { 2, 2 }, { 7, 4 },
				{ 4, 22 }, { 7, 24 }, { 9, 26 }, { 13, 28 }, { 11, 26 } };
		for (int i = 0; i < arr.length; i++) {
			if ("set".equalsIgnoreCase(arr[i])) {
				cache.set(arr2[i][0], arr2[i][1]);
				System.out.println(ss);
			} else if ("get".equalsIgnoreCase(arr[i])) {
				System.out.println(cache.get(arr2[i][0]));
			}
		}
	}

}
