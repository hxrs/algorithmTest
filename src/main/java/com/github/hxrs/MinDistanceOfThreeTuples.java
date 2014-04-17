package com.github.hxrs;

import java.util.Arrays;

/**
 * Given three sorted arrays with incremental order, find one element in each
 * array, make sure the distance of the three elements is minimum.<br>
 * For example:<br>
 * Three arrays a[l], b[m], c[n]. Assume the three elements are a[i], b[j], c[k]<br>
 * distance = max(|a[i]-b[j]|, |b[j]-c[k]|,|a[i]-c[k]|)
 * 
 * @author huanxiao
 * 
 */
public class MinDistanceOfThreeTuples {
	public static int[] findMinDistanceElments(int[] a, int[] b, int[] c) {
		if (a == null || b == null || c == null) {
			throw new NullPointerException(
					"one of the three input arrays is null!");
		}
		if (a.length == 0 || b.length == 0 || c.length == 0) {
			throw new RuntimeException(
					"one of the three input arrays is empty!");
		}

		int distance = caculateDistance(a[0], b[0], c[0]);
		int minValue;

		int aIndex = 0;
		int bIndex = 0;
		int cIndex = 0;
		while (aIndex < a.length && bIndex < b.length && cIndex < c.length) {
			minValue = min(a[aIndex], b[bIndex], c[cIndex]);
			if (minValue == a[aIndex]) {
				aIndex++;
				if(aIndex == a.length) {
					break;
				}
			} else if (minValue == b[bIndex]) {
				bIndex++;
				if(bIndex == b.length) {
					break;
				}
			} else {
				cIndex++;
				if(cIndex == c.length) {
					break;
				}
			}
			int currentDist = caculateDistance(a[aIndex], b[bIndex], c[cIndex]);
			if (currentDist < distance) {
				distance = currentDist;
			}
		}
		if (aIndex == a.length) {
			aIndex--;
		} else if (bIndex == b.length) {
			bIndex--;
		} else {
			cIndex--;
		}
		return new int[] { a[aIndex], b[bIndex], c[cIndex] };
	}

	private static int min(int aValue, int bValue, int cValue) {
		int minValue = Math.min(aValue, bValue);
		minValue = Math.min(minValue, cValue);
		return minValue;
	}

	private static int caculateDistance(int aValue, int bValue, int cValue) {
		int absAB = Math.abs(aValue - bValue);
		int absAC = Math.abs(aValue - cValue);
		int absBC = Math.abs(bValue - cValue);

		int maxDist = Math.max(absAB, absAC);
		maxDist = Math.max(maxDist, absBC);
		return maxDist;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 4, 20 };
		int[] b = new int[] { 9, 20, 21 };
		int[] c = new int[] { 10, 19, 21 };

		System.out.println(Arrays.toString(findMinDistanceElments(a, b, c)));
	}
}
