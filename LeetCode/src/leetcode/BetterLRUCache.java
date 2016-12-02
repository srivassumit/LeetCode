package com.leetcode.accepted;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A better implementation of the LRU Cache.
 * LeetCode Accepted
 * @author Sumit
 *
 */
public class BetterLRUCache extends LinkedHashMap<Integer, Integer> {

	/**
	 * generated serial Version UID.
	 */
	private static final long serialVersionUID = 6763565888957956619L;
	private int capacity;

	public BetterLRUCache(int capacity) {
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}

	@Override
	public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}

	public int get(int key) {
		Integer value = super.get(key);
		if (null == value)
			return -1;
		return value;
	}

	public void set(int key, int value) {
		super.put(key, value);
	}
}
