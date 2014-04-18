package com.github.hxrs;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 *
 * @author huanxiao
 *
 */

public class MaxNumberPonitsOnSameLine {

	public static int getMaxNumberOfPointsOnSameLine(Point[] points) {
		if (points == null) {
			throw new NullPointerException("the input points array is null");
		}
		if (points.length == 0) {
			throw new IllegalArgumentException("the length of points is zero!");
		}
		if (points.length == 1) {
			return 1;
		}
		/*
		 * Integer.max represents the two points on the vertical line, zero
		 * value means the two points on the horizontal line
		 */
		List<Double> slopeFactors = new LinkedList<Double>();
		// initialize the slopeFactors
		for (int i = 0; i < points.length - 1; i++) {
			Set<Double> sfInLine = new HashSet<Double>();
			for (int j = i + 1; j < points.length; j++) {
				sfInLine.add(caculateSlopeFactor(points[i], points[j]));
			}
			slopeFactors.addAll(sfInLine);
		}
		return getMaxNumOfSameValue(slopeFactors);
	}

	private static double caculateSlopeFactor(Point a, Point b) {
		if (a.x == b.x) {
			return Double.MAX_VALUE;
		}
		return ((double)(b.y - a.y)) / (b.x - a.x);
	}

	private static int getMaxNumOfSameValue(List<Double> list) {
		if (list == null || list.size() == 0) {
			return 0;
		}
		int max = 1;
		Collections.sort(list);
		Double preValue = list.remove(0);
		int tempMax = 1;
		for (Double d : list) {
			if (d.equals(preValue)) {
				tempMax++;
			} else {
				tempMax = 1;
			}
			if (max < tempMax) {
				max = tempMax;
			}
			preValue = d;
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point a = new Point(0, 0);
		Point b = new Point(1, 2);
		Point c = new Point(3, 3);
		Point d = new Point(2, 4);
		Point e = new Point(3, 6);
		Point[] points = new Point[] { a, b, c, d, e };

		System.out.println(getMaxNumberOfPointsOnSameLine(points));
	}

	public static class Point {
		private int x;
		private int y;

		public Point() {
			x = 0;
			y = 0;
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
}
