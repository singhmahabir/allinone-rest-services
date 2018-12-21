/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.interviewe.datastructure;

/**
 * @author Mahabir Singh
 *
 */
public class BasicQueue<X> {

    private final X[] data;
    private int front;
    private int end;

    public BasicQueue() {
        front = -1;
        end = -1;
        data = (X[]) new Object[10];
    }

    public void enQueue(X newItem) {
        // First see if the queue is full
        if ((end + (1 % data.length)) == front) {
            throw new IllegalArgumentException("The Queue is Full");
        }
        // Otherwise check to see if any data have been added to the queue yet
        else if (size() == 0) {
            front++;
            end++;
            data[end] = newItem;
        }
        // Otherwise add the item to the end of the queue.
        else {
            end++;
            data[end] = newItem;
        }
    }

    public X deQueue() {
        X item;
        // If the queue is empty we can't dequeue anything
        if (size() == 0) {
            throw new IllegalArgumentException("Can'y dequeue because the Queue is empty");
        }
        // Otherwise if this is the last item on the queue,
        else if (front == end) {
            item = data[front];
            front = -1;
            end = -1;
        }
        // Otherwise grab the front of the queue, return it and adjust the front pointer
        else {
            item = data[front];
            front++;
        }
        return item;
    }

    public boolean contains(X item) {
        boolean found = false;
        // If the queue is empty return false
        if (size() == 0) {
            return found;
        }
        for (int i = front; i < end; i++) {
            if (this.data[i] == item) {
                found = true;
                break;
            }
        }
        return found;
    }

    public X access(int position) {
        if ((size() == 0) || (position > size())) {
            throw new IllegalArgumentException("No item in the queue or the position is grater then size");
        }
        int trueIndex = 0;
        for (int i = front; i < end; i++) {
            if (trueIndex == position) {
                return data[i];
            }
            trueIndex++;
        }
        throw new IllegalArgumentException("could not found item on the stack");
    }

    public int size() {
        // If queue is empty return 0
        if ((front == -1) & (end == -1)) {
            return 0;
        } else {
            return (end - front) + 1;
        }
    }

    public static void main(String[] args) {
        final BasicQueue<String> stack = new BasicQueue<>();
        stack.enQueue("Mahabir");
        stack.enQueue("Mahabir Singh");
        System.err.println("size " + stack.size());
        System.err.println(stack.deQueue());
        System.err.println("size " + stack.size());
    }

}
