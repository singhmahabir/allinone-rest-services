/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.ds;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <P>
 * It is a {@link LinkedList} implementation </>
 * 
 * @author Mahabir Singh
 *
 */
public class BasicDoublyLinedkList<X> {

	private int nodeCount;
	private Node head;
	private Node last;

	public BasicDoublyLinedkList() {
		head = null;
		last = null;
		nodeCount = 0;
	}

	public void add(X item) {
		// adding first time
		if (head == null) {
			head = new Node(item);
			last = head;
		}
		// Otherwise, we want to grab the last node and update it's value.
		else {
			final Node newLastNode = new Node(item);
			last.setNextNode(newLastNode);
			last = newLastNode;
		}
		nodeCount++;
	}

	public void addFirst(X item) {
		// adding first time
		if (head == null) {
			head = new Node(item);
			last = head;
		}
		// Otherwise, we want to grab the last node and update it's value.
		else {
			final Node newNode = new Node(item);
			newNode.setNextNode(head);
			head = newNode;
		}
		nodeCount++;
	}

	public void insert(X item, int position) {
		// adding first time
		if (position > size()) {
			throw new IllegalArgumentException("The LinkedList is smaller than the position you added");
		}
		Node currentNode = head;
		// start at 1 because we are already on the first node
		for (int i = 1; (i < position) && (currentNode != null); i++) {
			currentNode = currentNode.getNextNode();
		}

		// serve the link chain and reconnect with the new node
		if (position == 0) {
			final Node newNode = new Node(item);
			newNode.setNextNode(head);
			head = newNode;
		} else {
			final Node newNode = new Node(item);
			final Node nextNode = currentNode.getNextNode();
			currentNode.setNextNode(newNode);
			newNode.setNextNode(nextNode);
		}
		nodeCount++;
	}

	public X remove() {
		if (head == null) {
			throw new IllegalArgumentException("The LinkedList is empty");
		}
		// now update the first pointer and throw away the first one
		final X nodeItem = head.getNodeItem();
		head = head.getNextNode();
		nodeCount--;
		return nodeItem;
	}

	public X removeAt(int position) {
		if (position > size()) {
			throw new IllegalArgumentException("The LinkedList is smaller than the position you ask to delete");
		}

		if (head == null) {
			throw new IllegalArgumentException("The LinkedList is empty");
		}

		Node prevNode = head;
		Node currentNode = head;

		// start at 1 because we are already on the first node
		for (int i = 1; (i < position) && (currentNode != null); i++) {
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		X item = null;
		// now update the pointer and throw away the old first
		if (position == 0) {
			item = head.getNodeItem();
			head = head.getNextNode();
		} else {
			item = currentNode.getNodeItem();
			prevNode.setNextNode(currentNode.getNextNode());
		}
		nodeCount--;
		return item;
	}

	public X get(int position) {
		if (head == null) {
			throw new IllegalArgumentException("The LinkedList is empty");
		}
		// now update the first pointer and throw away the first one
		Node currentNode = head;
		for (int i = 0; (i < size()) && (currentNode != null); i++) {
			if (position == i) {
				return currentNode.getNodeItem();
			}
			currentNode = currentNode.getNextNode();
		}
		// if we did not find it then return null or throw exception.
		return null;
	}

	public int find(X item) {
		if (head == null) {
			throw new IllegalArgumentException("The LinkedList is empty");
		}
		// now update the first pointer and throw away the first one
		Node currentNode = head;
		for (int i = 0; (i < size()) && (currentNode != null); i++) {
			if (currentNode.getNodeItem().equals(item)) {
				return i;
			}
			currentNode = currentNode.getNextNode();
		}
		// if we did not find it then return -1 or throw exception.
		return -1;
	}

	@Override
	public String toString() {
		final StringBuilder contents = new StringBuilder();
		if (head == null) {
			return contents.toString();
		}
		// now update the first pointer and throw away the first one
		Node currentNode = head;
		while (currentNode != null) {
			contents.append(currentNode.getNodeItem());
			currentNode = currentNode.getNextNode();
			if (currentNode != null) {
				contents.append(", ");
			}
		}
		// if we did not find it then return -1 or throw exception.
		return contents.toString();
	}

	private class Node {
		private Node nextNode;
		private Node preNode;

		public Node getPreNode() {
			return preNode;
		}

		public void setPreNode(Node preNode) {
			this.preNode = preNode;
		}

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

	public int size() {
		return nodeCount;
	}

	public static void main(String[] args) {
		final BasicDoublyLinedkList<String> linkedList = new BasicDoublyLinedkList<>();
		linkedList.add("Mahabir");
		linkedList.add("singh");
		linkedList.addFirst("Hari");
		linkedList.insert("Ram", 4);
		System.err.println(linkedList);

	}

}
