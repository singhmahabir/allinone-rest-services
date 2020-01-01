/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package z.ds.binarytree;

import java.util.Deque;
import java.util.LinkedList;

import z.ds.binarytree.BinaryTreeUnidirectional.Node;

/**
 * @author Mahabir Singh
 *
 */
public class SpiralOrderBinaryTree {

    private SpiralOrderBinaryTree() {
	super();
    }

    /**
     * Method 1 (Recursive) This problem can be seen as an extension of the level
     * order traversal post. To print the nodes in spiral order, nodes at different
     * levels should be printed in alternating order. An additional Boolean variable
     * ltr is used to change printing order of levels. If ltr is false then
     * printGivenLevel() prints nodes from left to right else from right to left.
     * Value of ltr is flipped in each iteration to change the order.
     *
     *
     * <pre>
     * 		    binary search tree
     *		            5
     *				   / \
     *				  2   8
     *				 / \   \
     *				1   4   9
     *						 \
     *						  12
     * </pre>
     *
     * @param root starting point
     */
    public static <X extends Comparable<X>> void printSpiralOrder(Node<X> root, boolean isStartFromLeft) {
	if (root == null) {
	    return;
	}
	/**
	 * If you want to start from left spiral then set itr with true else false for
	 * right spiral
	 */
	boolean itr = isStartFromLeft;
	final int height = findHeightOfTree(root);
	for (int level = 1; level <= height; level++) {
	    printLevel(root, level, itr);
	    itr = !itr;

	}
    }

    private static <X extends Comparable<X>> void printLevel(Node<X> node, int level, boolean itr) {
	if (node == null) {
	    return;
	}
	if (level == 1) {
	    System.out.print(node.getData() + " ");
	} else if (level > 1) {
	    if (itr) {
		printLevel(node.getRight(), level - 1, itr);
		printLevel(node.getLeft(), level - 1, itr);
	    } else {
		// itr = false mean print left to right
		printLevel(node.getLeft(), level - 1, itr);
		printLevel(node.getRight(), level - 1, itr);

	    }
	}
    }

    /**
     * <p>
     * This method returns the height of the given Binary Tree
     *
     * <p>
     *
     * The number of nodes along the longest path from the root node down to the
     * farthest leaf node.
     *
     * @param root starting point of Binary Tree
     * @return Height of the Tree
     */
    public static <X extends Comparable<X>> Integer findHeightOfTree(Node<X> root) {
	if (root == null) {
	    return 0;
	}
	/* compute the height of each subtree */
	final Integer left = findHeightOfTree(root.getLeft());
	final Integer right = findHeightOfTree(root.getRight());
	return 1 + (left > right ? left : right);
    }

    public static <X extends Comparable<X>> void printSpiralOrderUsingIterative(Node<X> root, boolean isStartFromLeft) {
	if (root == null) {
	    return;
	}
	// Create two stacks to store alternate levels For levels to be printed from
	// right to left
	final Deque<Node<X>> rightToLeftStack = new LinkedList<>();
	// For levels to be printed from left to right
	final Deque<Node<X>> leftToRightStack = new LinkedList<>();

	if (isStartFromLeft) {
	    rightToLeftStack.push(root);
	} else {
	    leftToRightStack.push(root);
	}

	while (!leftToRightStack.isEmpty() || !rightToLeftStack.isEmpty()) {
	    // Print nodes of current level from s1 and push nodes of next level to s2
	    while (!rightToLeftStack.isEmpty()) {
		final Node<X> temp = rightToLeftStack.peek();
		rightToLeftStack.pop();
		System.out.print(temp.getData() + " ");

		// Note that is right is pushed before left
		if (temp.getRight() != null) {
		    leftToRightStack.push(temp.getRight());
		}

		if (temp.getLeft() != null) {
		    leftToRightStack.push(temp.getLeft());
		}
	    }

	    // Print nodes of current level from s2 and push nodes of
	    // next level to s1
	    while (!leftToRightStack.isEmpty()) {
		final Node<X> temp = leftToRightStack.peek();
		leftToRightStack.pop();
		System.out.print(temp.getData() + " ");

		// Note that is left is pushed before right
		if (temp.getLeft() != null) {
		    rightToLeftStack.push(temp.getLeft());
		}
		if (temp.getRight() != null) {
		    rightToLeftStack.push(temp.getRight());
		}
	    }
	}
    }

    /**
     * *
     *
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
//		printVerticalOrder(root);
	printSpiralOrder(root, false);
    }
}
