package com.github.hxrs;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
			return 0;
		}
		if (points.length == 1) {
			return 1;
		}
		/*
		 * Integer.max represents the two points on the vertical line, zero
		 * value means the two points on the horizontal line
		 */
		int maxNum = 0;
		// initialize the slopeFactors
		for (int i = 0; i < points.length - 1; i++) {
			Map<Double, Integer> slopeFactorsMap = new HashMap<Double, Integer>();
			int numOfsameValue = 0;
			for (int j = i + 1; j < points.length; j++) {
				if (!isEqual(points[i], points[j])) {
					double slope = caculateSlopeFactor(points[i], points[j]);
					if (slopeFactorsMap.containsKey(slope)) {
						int newValue = slopeFactorsMap.get(slope) + 1;
						slopeFactorsMap.put(slope, newValue);
					} else {
						int newValue = 2;
						slopeFactorsMap.put(slope, newValue);
					}
				} else {
					numOfsameValue++; 
				}
			}
			int maxValueOneLine;
			if (slopeFactorsMap.size() != 0) {
				maxValueOneLine = Collections.max(slopeFactorsMap.values()) + numOfsameValue;
			} else {
				maxValueOneLine = 1 + numOfsameValue;
			}
			if (maxNum < maxValueOneLine) {
				maxNum = maxValueOneLine;
			}
		}
		return maxNum;
	}

	private static double caculateSlopeFactor(Point a, Point b) {
		if (a.x == b.x) {
			return Double.MAX_VALUE;
		}
		double slope = ((double) (b.y - a.y)) / (b.x - a.x);
		if (Double.compare(slope, -0.0) == 0) {
			return 0.0;
		} else {
			return slope;
		}
	}
	
	private static boolean isEqual(Point a, Point b) {
		if (a == b) {
			return true;
		}
		if (a.x == b.x && a.y == b.y) {
			return true;
		}
		return false;
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
