/**
 * Copyright 2019. All rights reserved.
 */

package z.ds;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * BalancedParentheses is a class which have implementation of Parentheses are
 * Balanced or not
 * <p>
 * such as: <br>
 * <strong> [a{()}] </strong> is Balanced [aa)] is a Unbalanced
 *
 *
 * @author Mahabir Singh
 *
 */
public class BalancedParentheses {

	private static boolean isPair(Character before, Character after) {
		return before.equals('(') && after.equals(')') || before.equals('{') && after.equals('}')
				|| before.equals('[') && after.equals(']');

	}

	public static boolean isParanthesesBalanced(String data) {
		final Deque<Character> stack = new ArrayDeque<>();

		for (final char c : data.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if (stack.isEmpty() || !isPair(stack.peek(), c)) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		final String expressoin = "[a{()}]";
		System.out.println(isParanthesesBalanced(expressoin));
	}

}
