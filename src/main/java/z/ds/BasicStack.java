/**
 * Copyright 2019. All rights reserved.
 */

package z.ds;

import java.util.Stack;

/**
 * <P>
 * It is a {@link Stack} Array Based implementation </>
 *
 *
 * @author Mahabir Singh
 *
 */
public class BasicStack<X> {

	private final X[] data;
	private int stackPointer;

	/**
	 * Default initial capacity.
	 */
	private static final int DEFAULT_CAPACITY = 10;

	public BasicStack() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public BasicStack(int size) {
		data = (X[]) new Object[size];
		stackPointer = 0;
	}

	public void push(X newItem) {
		if (stackPointer == data.length) {
			throw new IllegalArgumentException("No more space in tha stack");
		}
		this.data[stackPointer++] = newItem;
	}

	public X pop() {
		if (stackPointer == 0) {
			throw new IllegalArgumentException("No more items on tha stack");
		}
		return data[--stackPointer];
	}

	public boolean contains(X item) {
		boolean found = false;
		for (int i = 0; i < stackPointer; i++) {
			if (this.data[i] == item) {
				found = true;
				break;
			}
		}
		return found;
	}

	public X access(X item) {
		while (stackPointer > 0) {
			final X tempItem = pop();
			if (item.equals(tempItem)) {
				return tempItem;
			}
		}
		throw new IllegalArgumentException("could not found item on the stack");
	}

	public int size() {
		return stackPointer;
	}

	public static void main(String[] args) {
		final BasicStack<String> stack = new BasicStack<>();
		stack.push("Mahabir");
		stack.push("Mahabir Singh");
		stack.push("Mahabir Singh");
		stack.push("Mahabir Singh");
		stack.push("Mahabir Singh");
		stack.push("Mahabir Singh");
		stack.push("Mahabir Singh");
		stack.push("Mahabir Singh");
		stack.push("Mahabir Singh");
		stack.push("Mahabir Singh");
		System.err.println("size " + stack.size());
		System.err.println(stack.pop());
		stack.push("Mahabir Singh");
		System.err.println("size " + stack.size());
	}

}
