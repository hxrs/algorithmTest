package com.github.hxrs;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LRUCacheTest {
	private final static Logger logger = LoggerFactory
			.getLogger(LRUCacheTest.class);

	@Test
	public void get() {
		LRUCache cache = new LRUCache(2);
		cache.set(1, 2);
		cache.set(2, 3);
		logger.info("cache: {}", cache.toString());
		cache.get(1);
		logger.info("cache: {}", cache.toString());
		cache.set(3, 4);
		logger.info("cache: {}", cache.toString());
		assertFalse(cache.containsKey(2), "cache contains key 2 !");
		assertTrue(cache.containsKey(1), "cache contains key 1 !");
		assertTrue(cache.containsKey(3), "cache contains key 3 !");
	}

	@Test
	public void testSet() {
		LRUCache cache = new LRUCache(2);
		cache.set(1, 2);
		cache.set(2, 3);
		logger.info("cache: {}", cache.toString());
		assertEquals(cache.size(), 2, "The size is not 2!");
		cache.set(3, 4);
		logger.info("cache: {}", cache.toString());
		assertFalse(cache.containsKey(1), "cache contains key 1 !");
		assertEquals(cache.size(), 2, "The size is not 2!");
	}
}
