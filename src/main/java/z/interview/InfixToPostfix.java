/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package z.interview;

import java.util.Stack;

/**
 * @author Mahabir Singh
 *
 */
public class InfixToPostfix {

	// A utility function to return precedence of a given operator
	// Higher returned value means higher precedence
	static int prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		default:
			return -1;
		}
	}

	// The main method that converts given infix expression
	// to postfix expression.
	static String infixToPostfix(String exp) {
		// initializing empty String for result
		String result = "";

		// initializing empty stack
		final Stack<Character> stack = new Stack<>();

		for (int i = 0; i < exp.length(); ++i) {
			final char c = exp.charAt(i);

			// If the scanned character is an operand, add it to output.
			if (Character.isLetterOrDigit(c)) {
				result += c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop();
				}

				if (!stack.isEmpty() && stack.peek() != '(') {
					return "Invalid Expression"; // invalid expression
				} else {
					stack.pop();
				}
			} else // an operator is encountered
			{
				while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
					if (stack.peek() == '(') {
						return "Invalid Expression";
					}
					result += stack.pop();
				}
				stack.push(c);
			}

		}

		// pop all the operators from the stack
		while (!stack.isEmpty()) {
			if (stack.peek() == '(') {
				return "Invalid Expression";
			}
			result += stack.pop();
		}
		return result;
	}

	static int evaluatePostfix(String exp) {
		// create a stack
		final Stack<Integer> stack = new Stack<>();

		// Scan all characters one by one
		for (int i = 0; i < exp.length(); i++) {
			final char c = exp.charAt(i);

			// If the scanned character is an operand (number here),
			// push it to the stack.
			if (Character.isDigit(c)) {
				stack.push(c - '0');
			} else {
				final int val1 = stack.pop();
				final int val2 = stack.pop();

				switch (c) {
				case '+':
					stack.push(val2 + val1);
					break;

				case '-':
					stack.push(val2 - val1);
					break;

				case '/':
					stack.push(val2 / val1);
					break;

				case '*':
					stack.push(val2 * val1);
					break;
				}
			}
		}
		return stack.pop();
	}

	// Driver method
	public static void main(String[] args) {
//		final String exp = "a+b*(c^d-e)^(f+g*h)-i";
		final String infixToPostfix = infixToPostfix("34");
		System.out.println(infixToPostfix);
		System.out.println(evaluatePostfix("34*5-"));
	}
}
