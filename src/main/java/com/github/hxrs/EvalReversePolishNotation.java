package com.github.hxrs;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.<br>
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.<br>
 * Some examples:<br>
 * <code>["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 <br>
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6</code>
 *
 * @author huanxiao
 *
 */
public class EvalReversePolishNotation {
	private static final List<String> OPERATORS = Collections
			.unmodifiableList(Arrays.asList("+", "-", "*", "/"));

	private static String calculate(String data1, String data2, String op) {
		int operand1 = Integer.parseInt(data1);
		int operand2 = Integer.parseInt(data2);
		int result;
		if ("+".equals(op)) {
			result = operand1 + operand2;
		} else if ("-".equals(op)) {
			result = operand1 - operand2;
		} else if ("*".equals(op)) {
			result = operand1 * operand2;
		} else if ("/".equals(op)) {
			result = operand1 / operand2;
		} else {
			throw new RuntimeException("op is not supported!" + op);
		}
		return String.valueOf(result);
	}

	public static int evalRPN(String[] rpnArray) {
		if (rpnArray == null) {
			throw new NullPointerException("input array is null!");
		}
		if (rpnArray.length == 0) {
			return 0;
		}

		LinkedList<String> stack = new LinkedList<String>();
		for (String s : rpnArray) {
			if (OPERATORS.contains(s)) {
				if (stack.size() >= 2) {
					String data2 = stack.pop();
					String data1 = stack.pop();
					stack.push(calculate(data1, data2, s));
				} else {
					throw new RuntimeException(
							"Invalid Reverse Polish Notation: "
									+ Arrays.toString(rpnArray));
				}

			} else {
				stack.push(s);
			}
		}
		return Integer.parseInt(stack.pop());
	}
}
