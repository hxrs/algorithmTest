package com.github.hxrs;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 *                 When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * @author huanxiao
 *
 */
@SuppressWarnings("all")
public class LRUCache extends LinkedHashMap {
	private static final float DEFALUT_LOAD_FACTOR = 0.75f;
	private int capacity;

    public LRUCache(int capacity) {
    	super((int)Math.ceil(capacity/DEFALUT_LOAD_FACTOR) + 1, DEFALUT_LOAD_FACTOR, true);
    	this.capacity = capacity;
    }
    public int get(int key) {
        Object result = super.get(key);
        if (result == null) {
        	return -1;
        } else {
        	return Integer.parseInt(result.toString());
        }
    }
    public void set(int key, int value) {
        super.put(key, value);
    }
    protected boolean removeEldestEntry(Map.Entry eldest) {
    	return size() > capacity;
    }
}