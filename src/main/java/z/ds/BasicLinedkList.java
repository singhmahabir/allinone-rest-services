/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.ds;

/**
 * @author Mahabir Singh
 *
 */
public class BasicLinedkList<X> {

	private int nodeCount;
	private Node first;
	private Node last;

	public BasicLinedkList() {
		first = null;
		last = null;
		nodeCount = 0;
	}

	public void add(X item) {
		// adding first time
		if (first == null) {
			first = new Node(item);
			last = first;
		}
		// Otherwise, we want to grab the last node and update it's value.
		else {
			final Node newLastNode = new Node(item);
			last.setNextNode(newLastNode);
			last = newLastNode;
		}
		nodeCount++;
	}

	public void insert(X item, int position) {
		// adding first time
		if (position > size()) {
			throw new IllegalArgumentException("The LinkedList is smaller than the position you added");
		}
		Node currentNode = first;
		// start at 1 because we are already on the first node
		for (int i = 1; (i < position) && (currentNode != null); i++) {
			currentNode = currentNode.getNextNode();
		}

		// serve the link chain and reconnect with the new node
		if (position == 0) {
			final Node newNode = new Node(item);
			newNode.setNextNode(first);
			first = newNode;
		} else {
			final Node newNode = new Node(item);
			final Node nextNode = currentNode.getNextNode();
			currentNode.setNextNode(newNode);
			newNode.setNextNode(nextNode);
		}
		nodeCount++;
	}

	public X remove() {
		if (first == null) {
			throw new IllegalArgumentException("The LinkedList is empty");
		}
		// now update the first pointer and throw away the first one
		final X nodeItem = first.getNodeItem();
		first = first.getNextNode();
		nodeCount--;
		return nodeItem;
	}

	public X removeAt(int position) {
		if (position > size()) {
			throw new IllegalArgumentException("The LinkedList is smaller than the position you ask to delete");
		}

		if (first == null) {
			throw new IllegalArgumentException("The LinkedList is empty");
		}

		Node prevNode = first;
		Node currentNode = first;

		// start at 1 because we are already on the first node
		for (int i = 1; (i < position) && (currentNode != null); i++) {
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		X item = null;
		// now update the pointer and throw away the old first
		if (position == 0) {
			item = first.getNodeItem();
			first = first.getNextNode();
		} else {
			item = currentNode.getNodeItem();
			prevNode.setNextNode(currentNode.getNextNode());
		}
		nodeCount--;
		return item;
	}

	public X get(int position) {
		if (first == null) {
			throw new IllegalArgumentException("The LinkedList is empty");
		}
		// now update the first pointer and throw away the first one
		Node currentNode = first;
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
		if (first == null) {
			throw new IllegalArgumentException("The LinkedList is empty");
		}
		// now update the first pointer and throw away the first one
		Node currentNode = first;
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
		if (first == null) {
			return contents.toString();
		}
		// now update the first pointer and throw away the first one
		Node currentNode = first;
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
		final BasicLinedkList<String> linkedList = new BasicLinedkList<>();
		linkedList.add("Mahabir");
		linkedList.add("singh");
		System.err.println(linkedList);
		linkedList.insert("MBRDi", 0);
		System.err.println(linkedList);
		System.err.println("remove at 0 " + linkedList.removeAt(0));
		System.err.println(linkedList);
		System.err.println("size " + linkedList.size());
		System.err.println(linkedList);
		System.err.println(linkedList.find("singh"));
		System.err.println(linkedList.get(linkedList.find("singh")));
		System.err.println("remove  " + linkedList.remove());
		System.err.println(linkedList);
	}

}
