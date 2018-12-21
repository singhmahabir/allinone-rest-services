/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.interviewe.datastructure;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Mahabir Singh
 *
 */
public class BasicBlockingQueue<T> {
    private final List<T> queue = new LinkedList<>();

    private static final int DEFAULT_SIZE = 10;
    private int limit;

    public BasicBlockingQueue(int limit) {
        this.limit = limit;
    }

    public BasicBlockingQueue() {
        this(DEFAULT_SIZE);
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.isEmpty()) {
            notifyAll();
        }
        this.queue.add(item);
    }

    public synchronized T dequeue() throws InterruptedException {
        while (this.queue.isEmpty()) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }

        return this.queue.remove(0);
    }
}
