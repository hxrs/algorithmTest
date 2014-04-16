package com.github.hxrs;

import java.util.BitSet;

/**
 * This class is for algorithm test as below: Q: Given an array of positive
 * integer, find the maximum continuous sub-set Example: Input: [15, 7, 12, 6,
 * 14, 13, 9, 11] Output: [11, 12, 13, 14, 15]
 *
 * @author huanxiao
 *
 */
public class ContinuousSubSet {

	/**
	 * Given an array of positive integer, find the maximum continuous sub-set
	 * @param array input array
	 * @return maximum continuous sub-set
	 */
	public static int[] findMaxContinuousSubSet(final int[] array) {
		if (array == null || array.length == 0) {
			return new int[] {};    //return a empty array instead of null value.
		}
		if (array.length == 1) {
			return array.clone();  //return one copy of the input array
		}
		BitSet bitSet = new BitSet(array.length);
		for (int e : array) {
			bitSet.set(e);
		}
		int fromValue = -1;
		int distance = -1;
		/*Iterate "true" value in this bitset*/
		for (int i = bitSet.nextSetBit(0); i >= 0; ) {
			int from = i;
			int end = i;

			i = bitSet.nextSetBit(i+1);
			while (i >= 0) {
				if (i == end + 1) {
					end = i;
					i = bitSet.nextSetBit(i+1);
				} else {
					break;
				}
			}
            if (end - from > distance) {
            	distance = end - from + 1;
            	fromValue = from;
            }
		}
		int[] result = new int[distance];
		for(int i=0; i<distance; i++){
			result[i] = fromValue + i;
		}
		return result;
	}
}
