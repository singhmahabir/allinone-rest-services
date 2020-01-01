/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package z.ds.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import z.ds.binarytree.BinaryTreeUnidirectional.Node;

/**
 * @author Mahabir Singh
 *
 */
public class VerticalOrderBinaryTree {

	private VerticalOrderBinaryTree() {
		super();
	}

	public static <E extends Comparable<E>> void getVerticalOrderBTree(Node<E> current, Map<Integer, List<E>> map,
			Integer position) {

		// Base Case to terminate the recursion
		if (current == null) {
			return;
		}

		// get the list at 'position'
		List<E> list = map.get(position);

		if (list == null) {
			list = new ArrayList<>();
		}

		list.add(current.getData());
		map.put(position, list);

		// Store nodes in left subtree
		getVerticalOrderBTree(current.getLeft(), map, position - 1);

		// Store nodes in right subtree
		getVerticalOrderBTree(current.getRight(), map, position + 1);
	}

	public static <E extends Comparable<E>> void printVerticalOrder(Node<E> root) {
		// Create a map and store vertical order in map using getVerticalOrderBTree()
		final Map<Integer, List<E>> treeMap = new TreeMap<>();
		final Integer position = 0;
		getVerticalOrderBTree(root, treeMap, position);

		treeMap.values().stream().forEach(System.out::println);
	}

	/**
	 * <pre>
	 *      1
	      /    \
	     2        3
	    / \      /   \
	   4    5   6     7
	             \   / \
	             8  10  9
	 *
	 * </pre>
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		final Node<Integer> root = new Node<>(1);
		root.setLeft(new Node<>(2));
		root.setRight(new Node<>(3));
		root.getLeft().setLeft(new Node<>(4));
		root.getLeft().setRight(new Node<>(5));
		root.getRight().setLeft(new Node<>(6));
		root.getRight().setRight(new Node<>(7));
		root.getRight().getLeft().setRight(new Node<>(8));
		root.getRight().getRight().setRight(new Node<>(9));
		root.getRight().getRight().setLeft(new Node<>(10));
		printVerticalOrder(root);
	}
}
