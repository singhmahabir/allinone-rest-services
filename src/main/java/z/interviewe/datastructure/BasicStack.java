/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.interviewe.datastructure;

/**
 * @author Mahabir Singh
 *
 */
public class BasicStack<X> {

    private final X[] data;
    private int stackPointer;

    public BasicStack() {
        data = (X[]) new Object[10];
        stackPointer = 0;
    }

    public void push(X newItem) {
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
        System.err.println("size " + stack.size());
        System.err.println(stack.pop());
    }

}
