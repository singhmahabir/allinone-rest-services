/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.ds;

import java.util.LinkedList;
import java.util.Queue;

import lombok.extern.slf4j.Slf4j;

/**
 * <P>
 * It is a {@link Queue} implementation based on {@link LinkedList} </>
 * 
 * @author Mahabir Singh
 *
 */
@Slf4j
public class BasicQueueUsingLinkedList<X> {

	private Node front;
	private Node end;
	private int size = -1;

	public void enQueue(X newItem) {
		Node newNode = new Node(newItem);
		// First see if the queue is full
		if (front == null && end == null) {
			front = end = newNode;
		}
		// Otherwise check to see if any data have been added to the queue yet
		else {
			end.setNextNode(newNode);
			end = newNode;
		}
		size++;
	}

	public X deQueue() {
		X item;
		// If the queue is empty we can't dequeue anything
		if (front == null && end == null) {
			throw new IllegalArgumentException("Can'y dequeue because the Queue is empty");
		}
		// Otherwise if this is the last item on the queue,
		else if (front == end) {
			item = front.getNodeItem();
			front = end = null;
		}
		// Otherwise grab the front of the queue, return it and adjust the front pointer
		else {
			item = front.getNodeItem();
			front = front.getNextNode();
		}
		size--;
		return item;
	}

	public boolean contains(X item) {
		boolean found = false;
		// If the queue is empty return false
		if (size() == 0) {
			return found;
		}
		Node temp = front;
		while (temp != null) {
			if (temp.getNodeItem().equals(item)) {
				found = true;
				break;
			}
			temp = temp.getNextNode();
		}
		return found;
	}

	public X access(int position) {
		if ((size() == 0) || (position > size())) {
			throw new IllegalArgumentException("No item in the " + "queue or the position is grater then size");
		}
		int trueIndex = 1;
		Node temp = front;
		while (trueIndex != position) {
			temp = temp.getNextNode();
			trueIndex++;
		}
		return temp.getNodeItem();
	}

	public int size() {
		// If queue is empty return 0
		return size + 1;
	}

	private class Node {
		private Node nextNode;

		private final X nodeItem;

		public Node(X item) {
			this.nodeItem = item;
			nextNode = null;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public Node getNextNode() {
			return this.nextNode;
		}

		public X getNodeItem() {
			return this.nodeItem;
		}
	}

	public static void main(String[] args) {
		final BasicQueueUsingLinkedList<String> queue = new BasicQueueUsingLinkedList<>();
		queue.enQueue("Mahabir");
		queue.enQueue("Mahabir Singh");
		log.info(queue.access(1));
		log.info(queue.access(2));
		log.info("size " + queue.size());
		log.info("de Queue " + queue.deQueue());
		log.info("size " + queue.size());
		log.info(queue.access(1));
		queue.deQueue();
	}

}
