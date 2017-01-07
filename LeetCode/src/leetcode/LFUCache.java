package com.leetcode.accepted;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * <h1>460. LFU Cache (H)</h1>
 * <p>
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and set. <br>
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new
 * item. For the purpose of this problem, when there is a tie (i.e., two or more
 * keys that have the same frequency), the least recently used key would be
 * evicted. <br>
 * </p>
 * <p>
 * Follow up:<br>
 * Could you do both operations in O(1) time complexity? <br>
 * <p>
 * <b> Example:</b>
 * </p>
 * 
 * <pre>
 * LFUCache cache = new LFUCache( 2 ); // capacity<br>
 * cache.set(1, 1);<br>
 * cache.set(2, 2);<br>
 * cache.get(1); // returns 1<br>
 * cache.set(3, 3); // evicts key 2<br>
 * cache.get(2); // returns -1 (not found)<br>
 * cache.get(3); // returns 3.<br>
 * cache.set(4, 4); // evicts key 1.<br>
 * cache.get(1); // returns -1 (not found)<br>
 * cache.get(3); // returns 3<br>
 * cache.get(4); // returns 4<br>
 * 
 * <pre>
 * 
 * @author Sumit
 */
public class LFUCache {

	private Map<Integer, Key> cache;
	private TreeSet<Key> treeSet;
	private int maxSize;

	/**
	 * LeetCode Accepted solution for LFUCache
	 * 
	 * @param capacity
	 *            the calacity of the LFUCache
	 */
	public LFUCache(int capacity) {
		this.cache = new HashMap<Integer, Key>();
		this.treeSet = new TreeSet<Key>(new KeyComparator());
		this.maxSize = capacity;
	}

	public int get(int key) {
		if (maxSize <= 0 || !cache.containsKey(key)) {
			return -1;
		}
		Key k = cache.get(key);
		treeSet.remove(k);
		k.accessKey();
		treeSet.add(k);

		return cache.get(key).value;
	}

	public void set(int key, int value) {
		if (maxSize <= 0) {
			return;
		}
		if (cache.containsKey(key)) {
			Key k = cache.get(key);
			k.value = value;
			treeSet.remove(k);
			k.accessKey();
			treeSet.add(k);
		} else if (cache.size() < maxSize) {
			Key k = new Key(key, value);
			cache.put(key, k);
			treeSet.add(k);
		} else {
			Key keyToRemove = treeSet.pollFirst();
			cache.remove(keyToRemove.key);
			Key k = new Key(key, value);
			cache.put(key, k);
			treeSet.add(k);
		}
	}

	class Key {
		int key;
		int value;
		int frequency;
		long lastUseTime;

		public Key(int key, int value) {
			this.key = key;
			this.value = value;
			this.frequency = 1;
			this.lastUseTime = System.nanoTime();
		}

		public void accessKey() {
			this.frequency++;
			this.lastUseTime = System.nanoTime();
		}

	}

	class KeyComparator implements Comparator<Key> {
		@Override
		public int compare(Key k1, Key k2) {
			if (k1.key == k2.key) {
				return 0;
			}
			int fDiff = k1.frequency - k2.frequency;
			return fDiff == 0 ? (k1.lastUseTime - k2.lastUseTime > 0 ? 1 : -1) : fDiff;
		}

	}

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
		LFUCache cache = new LFUCache(2);
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
		LFUCache cache = new LFUCache(2);
		cache.set(2, 1);
		cache.set(1, 1);
		cache.set(2, 3);
		cache.set(4, 1);
		System.out.println(cache.get(1)); // -1
		System.out.println(cache.get(2)); // 3
	}

	private static void tc3() {
		LFUCache cache = new LFUCache(2);
		cache.set(3, 1);
		cache.set(2, 1);
		cache.set(2, 2);
		cache.set(4, 4);
		System.out.println(cache.get(2)); // 2
	}

	private static void tc4() {
		LFUCache cache = new LFUCache(0);
		cache.set(0, 0);
		System.out.println(cache.get(0)); // -1
	}

	private static void tc5() {
		LFUCache cache = new LFUCache(10);
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
