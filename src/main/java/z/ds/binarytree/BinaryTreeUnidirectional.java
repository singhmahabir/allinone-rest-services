
/**
 * Copyright 2019. All rights reserved.
 */

package z.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;

/**
 * One way BinarySearchTree mean only parent or node have the link to it's child
 * but child doesn't have reference to it's parent
 *
 * <pre>
 * 		    binary search tree
 *		            5
 *				   / \
 *				  2   8
 *				 / \   \
 *				1   4   9
 * </pre>
 *
 * @author Mahabir Singh
 *
 * @param <X> X is any data type
 */
@Slf4j
public class BinaryTreeUnidirectional<X extends Comparable<X>> {

	private Node<X> root;
	private int size;

	public BinaryTreeUnidirectional() {
		root = null;
	}

	public Node<X> getRoot() {
		return root;
	}

	public void add(X item) {
		final Node<X> newNode = new Node<>(item);
		// if this is the first item in the tree,set it as root
		if (root == null) {
			this.root = newNode;
			log.info("set root: " + newNode.getData());
			this.size++;
		}
		// otherwise we need to insert the item into the tree using the binary
		else {
			insert(root, newNode);
		}
	}

	/**
	 * In Order traversal will provide in sorted list of binary tree
	 * <p>
	 * This is one of the Depth-First-Search
	 */
	public void printInOrder() {
		inOrder(getRoot());
	}

	/**
	 * <p>
	 * This is one of the Depth-First-Search
	 */
	public void printPostOrder() {
		postOrder(getRoot());
	}

	/**
	 * <p>
	 * This is one of the Depth-First-Search
	 */
	public void printPreOrder() {
		preOrder(getRoot());
	}

	/**
	 * This is also called level search
	 * <p>
	 * This is one of the Breadth-First-Search
	 *
	 */
	public void printBredthFirstSearch() {
		levelOrder(getRoot());
	}

	public int size() {
		return this.size;
	}

	public boolean contains(X item) {
		return getNode(item) != null;
	}

	public boolean delete(X item) {
		boolean deleted = false;
		if (this.root == null) {
			return deleted;
		}

		deleted = unlink(this.root, item) != null;

		if (deleted) {
			this.size--;
		}
		return deleted;
	}

	private Node<X> unlink(Node<X> currentNode, X item) {
		// if this is the root node, we replace that a little differently
		if (currentNode == null) {
			return currentNode;
		} else if (item.compareTo(currentNode.getData()) < 0) {
			currentNode.setLeft(unlink(currentNode.getLeft(), item));
		} else if (item.compareTo(currentNode.getData()) > 0) {
			currentNode.setRight(unlink(currentNode.getRight(), item));
		}
		// Wohoo... I found you, Get ready to be deleted
		else {
			// Case 1: No child
			if (currentNode.getLeft() == null && currentNode.getRight() == null) {
				currentNode = null;
			}
			// Case 2: One child
			else if (currentNode.getLeft() == null) {
				currentNode = currentNode.getRight();
			} else if (currentNode.getRight() == null) {
				currentNode = currentNode.getLeft();
			}
			// case 3: 2 children
			else {
				final Node<X> temp = findMin(currentNode.getRight());
				currentNode.setData(temp.getData());
				currentNode.setRight(unlink(currentNode.getRight(), temp.getData()));
//    			Node temp = findMax(currentNode.getLeft());  // two way either maximum in left or minimum in right
//    			currentNode.setItem(temp.getItem());
//    			currentNode.setLeft(unlink(currentNode.getLeft(), temp.getItem()));
			}
		}
		return currentNode;
	}

	// Function to find minimum in a tree.
	public Node<X> findMin(Node<X> root) {
		while (root.getLeft() != null) {
			root = root.getLeft();
		}
		return root;
	}

	// Function to find minimum in a tree.
	public Node<X> findMax(Node<X> root) {
		while (root.getRight() != null) {
			root = root.getRight();
		}
		return root;
	}

	private Node<X> getNode(X item) {
		Node<X> currentNode = this.root;

		while (currentNode != null) {
			final int val = item.compareTo(currentNode.getData());
			// see if the node is a match
			if (val == 0) {
				return currentNode;
			}
			// if the value is less then , we go to the left side of the tree
			else if (val < 0) {
				currentNode = currentNode.getLeft();
			}
			// otherwise we go to the right side
			else {
				currentNode = currentNode.getRight();
			}
		}
		return null;
	}

	private void insert(Node<X> parent, Node<X> child) {
		// If the child is less than parent, it goes on the left
		if (child.getData().compareTo(parent.getData()) < 0) {
			// If the left node is null, we've found our spot
			if (parent.getLeft() == null) {
				parent.setLeft(child);
				this.size++;
			} // otherwise we need to call insert again and test for left or right (recursion)
			else {
				insert(parent.getLeft(), child);
			}
		}
		// If the child is grater than the parent, it goes on right
		else if (child.getData().compareTo(parent.getData()) > 0) {
			// If the right node is null, we've found our spot
			if (parent.getRight() == null) {
				parent.setRight(child);
				this.size++;
			} // otherwise we need to call insert again and test for left or right (recursion)
			else {
				insert(parent.getRight(), child);
			}
		}
		// if the parent and child happen to be equal, we don't do anything
		// data in binary tree is assumed to be unique and value already exist in tree
	}

	public static class Node<X extends Comparable<X>> {
		private Node<X> left;
		private Node<X> right;
		private X data;

		Node(X data) {
			this.data = data;
		}

		public Node<X> getLeft() {
			return left;
		}

		public void setLeft(Node<X> left) {
			this.left = left;
		}

		public Node<X> getRight() {
			return right;
		}

		public void setRight(Node<X> right) {
			this.right = right;
		}

		public X getData() {
			return data;
		}

		public void setData(X data) {
			this.data = data;
		}
	}

	// Function to Insert Node in a Binary Search Tree
	public Node<X> insert(Node<X> root, X data) {
		if (root == null) {
			root = new Node<>(data);
			this.root = root;
			return root;
		} else if (data.compareTo(root.getData()) < 0) {
			root.setLeft(insert(root.getLeft(), data));
		} else {
			root.setRight(insert(root.getRight(), data));
		}
		this.root = root;
		return root;
	}

	// Function to visit nodes in Postorder
	public void postOrder(Node<X> root) {
		if (root == null) {
			return;
		}
		postOrder(root.getLeft()); // Visit left subtree
		postOrder(root.getRight()); // Visit right subtree
		log.info(root.getData() + " "); // Print data
	}

	// Function to visit nodes in Preorder
	public void preOrder(Node<X> root) {
		// base condition for recursion
		// if tree/sub-tree is empty, return and exit
		if (root == null) {
			return;
		}
		log.info(root.getData() + " "); // Print data
		preOrder(root.getLeft()); // Visit left subtree
		preOrder(root.getRight()); // Visit right subtree
	}

	// Function to visit nodes in Inorder
	public void inOrder(Node<X> root) {
		if (root == null) {
			return;
		}
		inOrder(root.getLeft()); // Visit left subtree
		log.info(root.getData() + " "); // Print data
		inOrder(root.getRight()); // Visit right subtree
	}

	// Function to print Nodes in a binary tree in Level order
	public void levelOrder(Node<X> root) {
		if (root == null) {
			return;
		}
		final Queue<Node<X>> Q = new LinkedList<>();
		Q.add(root);
		// while there is at least one discovered node
		while (!Q.isEmpty()) {
			final Node<X> current = Q.poll(); // removing the element at front
			log.info(current.getData() + " "); // Print data
			if (current.getLeft() != null) {
				Q.add(current.getLeft());
			}
			if (current.getRight() != null) {
				Q.add(current.getRight());
			}
		}
	}

	/**
	 * Method 1 (Recursive) This problem can be seen as an extension of the level
	 * order traversal post. To print the nodes in spiral order, nodes at different
	 * levels should be printed in alternating order. An additional Boolean variable
	 * ltr is used to change printing order of levels. If ltr is 1 then
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
	public void printSpiralOrder(Node<X> root, boolean startFromLeft) {
		if (root == null) {
			return;
		}
		/**
		 * If you want to start from left spiral then set itr with true else false for
		 * right spiral
		 */
		boolean itr = startFromLeft;
		final int height = findHeightOfTree(root);
		for (int level = 1; level <= height; level++) {
			printLevel(root, level, itr);
			itr = !itr;

		}
	}

	private void printLevel(Node<X> node, int level, boolean itr) {
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
	public Integer findHeightOfTree(Node<X> root) {
		if (root == null) {
			return 0;
		}
		/* compute the height of each subtree */
		final Integer left = findHeightOfTree(root.getLeft());
		final Integer right = findHeightOfTree(root.getRight());
		return 1 + (left > right ? left : right);
	}

	public void printSpiralOrderUsingIterative(Node<X> root, boolean startFromLeft) {
		if (root == null) {
			return;
		}
		// Create two stacks to store alternate levels
		// For levels to be printed from right to left
		final Stack<Node> rightToLeft = new Stack<>();
		// For levels to be printed from left to right
		final Stack<Node> leftToRight = new Stack<>();

		if (startFromLeft) {
			rightToLeft.push(root);
		} else {
			leftToRight.push(root);
		}

		while (!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {
			// Print nodes of current level from s1 and push nodes of
			// next level to s2
			while (!rightToLeft.empty()) {
				final Node temp = rightToLeft.peek();
				rightToLeft.pop();
				System.out.print(temp.data + " ");

				// Note that is right is pushed before left
				if (temp.right != null) {
					leftToRight.push(temp.right);
				}

				if (temp.left != null) {
					leftToRight.push(temp.left);
				}
			}

			// Print nodes of current level from s2 and push nodes of
			// next level to s1
			while (!leftToRight.empty()) {
				final Node temp = leftToRight.peek();
				leftToRight.pop();
				System.out.print(temp.data + " ");

				// Note that is left is pushed before right
				if (temp.left != null) {
					rightToLeft.push(temp.left);
				}
				if (temp.right != null) {
					rightToLeft.push(temp.right);
				}
			}
		}
	}

	public void printTreeCorner(Node<X> root, boolean startFromLeft) {
		if (root == null) {
			return;
		}
		// Create two stacks to store alternate levels
		// For levels to be printed from right to left
		final Stack<Node> rightToLeft = new Stack<>();
		// For levels to be printed from left to right
		final Stack<Node> leftToRight = new Stack<>();

		if (startFromLeft) {
			rightToLeft.push(root);
		} else {
			leftToRight.push(root);
		}

	}

	public static void main(String[] args) {
		final BinaryTreeUnidirectional<Integer> tree = new BinaryTreeUnidirectional<>();
		tree.add(5);
		tree.add(2);
		tree.add(4);
		tree.add(1);
		tree.add(8);
		tree.add(9);
		tree.add(12);

		System.out.println(tree.findHeightOfTree(tree.root));
//		tree.printSpiralOrder(tree.getRoot(), true);
		tree.printSpiralOrderUsingIterative(tree.getRoot(), true);

	}
}
