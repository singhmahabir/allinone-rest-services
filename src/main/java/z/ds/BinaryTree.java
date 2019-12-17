
/**
 * Copyright 2019. All rights reserved.
 */

package z.ds;

import java.util.LinkedList;
import java.util.Queue;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Mahabir Singh
 * 
 *         <pre>
 * 		    binary search tree
 *		            5
 *				   / \
 *				  2   8
 *				 / \   \
 *				1   4   9
 *         </pre>
 *
 * @param <X> X is any data type
 */
@Slf4j
public class BinaryTree<X extends Comparable<X>> {

	private Node root;
	private int size;

	public BinaryTree() {
		this.root = null;
	}

	public void add(X item) {
		final Node newNode = new Node(item);
		// if this is the first item in the tree,set it as root
		if (root == null) {
			this.root = newNode;
			log.info("set root: " + newNode.getItem());
			this.size++;
		}
		// otherwise we need to insert the item into the tree using the binary
		else {
			insert(root, newNode);
		}
	}

	public int size() {
		return this.size;
	}

	public boolean contains(X item) {
		return getNode(item) != null;
	}

	/**
	 * In Order traversal will provide in sorted list of binary tree
	 * <p>
	 * This is one of the Depth-First-Search
	 */
	public void printInOrder() {
		inOrder(this.root);
	}

	/**
	 * <p>
	 * This is one of the Depth-First-Search
	 */
	public void printPostOrder() {
		postOrder(this.root);
	}

	/**
	 * <p>
	 * This is one of the Depth-First-Search
	 */
	public void printPreOrder() {
		preOrder(this.root);
	}

	/**
	 * This is also called level search
	 * <p>
	 * This is one of the Breadth-First-Search
	 *
	 */
	public void printBredthFirstSearch() {
		levelOrder(this.root);
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

	private Node unlink(Node currentNode, X item) {
		// if this is the root node, we replace that a little differently
		if (currentNode == null) {
			return currentNode;
		} else if (item.compareTo(currentNode.getItem()) < 0) {
			currentNode.setLeft(unlink(currentNode.getLeft(), item));
		} else if (item.compareTo(currentNode.getItem()) > 0) {
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
				final Node temp = findMin(currentNode.getRight());
				currentNode.setItem(temp.getItem());
				currentNode.setRight(unlink(currentNode.getRight(), temp.getItem()));
//    			Node temp = findMax(currentNode.getLeft());  // two way either maximum in left or minimum in right
//    			currentNode.setItem(temp.getItem());
//    			currentNode.setLeft(unlink(currentNode.getLeft(), temp.getItem()));
			}
		}
		return currentNode;
	}

	// Function to find minimum in a tree.
	public Node findMin(Node root) {
		while (root.getLeft() != null) {
			root = root.getLeft();
		}
		return root;
	}

	// Function to find minimum in a tree.
	public Node findMax(Node root) {
		while (root.getRight() != null) {
			root = root.getRight();
		}
		return root;
	}


	 

	private Node getNode(X item) {
		Node currentNode = this.root;

		while (currentNode != null) {
			final int val = item.compareTo(currentNode.getItem());
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

	private void insert(Node parent, Node child) {
		// If the child is less than parent, it goes on the left
		if (child.getItem().compareTo(parent.getItem()) < 0) {
			// If the left node is null, we've found our spot
			if (parent.getLeft() == null) {
				parent.setLeft(child);
				child.setParent(parent);
				this.size++;
			} // otherwise we need to call insert again and test for left or right (recursion)
			else {
				insert(parent.getLeft(), child);
			}
		}
		// If the child is grater than the parent, it goes on right
		else if (child.getItem().compareTo(parent.getItem()) > 0) {
			// If the right node is null, we've found our spot
			if (parent.getRight() == null) {
				parent.setRight(child);
				child.setParent(parent);
				this.size++;
			} // otherwise we need to call insert again and test for left or right (recursion)
			else {
				insert(parent.getRight(), child);
			}
		}
		// if the parent and child happen to be equal, we don't do anything
		// data in binary tree is assumed to be unique and value already exist in tree
	}

	// Function to visit nodes in Postorder
	private void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.getLeft()); // Visit left subtree
		postOrder(root.getRight()); // Visit right subtree
		log.info(root.getItem() + " "); // Print data
	}

	// Function to visit nodes in Preorder
	private void preOrder(Node root) {
		// base condition for recursion
		// if tree/sub-tree is empty, return and exit
		if (root == null) {
			return;
		}
		log.info(root.getItem() + " "); // Print data
		preOrder(root.getLeft()); // Visit left subtree
		preOrder(root.getRight()); // Visit right subtree
	}

	// Function to visit nodes in Inorder
	private void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.getLeft()); // Visit left subtree
		log.info(root.getItem() + " "); // Print data
		inOrder(root.getRight()); // Visit right subtree
	}

	// Function to print Nodes in a binary tree in Level order
	public void levelOrder(Node root) {
		if (root == null) {
			return;
		}
		final Queue<Node> Q = new LinkedList<>();
		Q.add(root);
		// while there is at least one discovered node
		while (!Q.isEmpty()) {
			final Node current = Q.poll(); // removing the element at front
			log.info(current.getItem() + " "); // Print data
			if (current.getLeft() != null) {
				Q.add(current.getLeft());
			}
			if (current.getRight() != null) {
				Q.add(current.getRight());
			}
		}
	}

	/**
	 * Binary Search Node class
	 *
	 */
	@Setter
	@Getter
	private class Node {
		private Node left;
		private Node right;
		private Node parent;
		private X item;

		public Node(X item) {
			this.item = item;
		}
	}
	
	public static void main(String[] args) {
		final BinaryTree<Integer> tree = new BinaryTree<>();
		tree.add(9);
		tree.add(4);
		tree.add(12);
		tree.add(3);
		tree.add(11);
		System.out.println(tree.root.getItem());
		tree.delete(9);

		System.out.println();
		tree.printBredthFirstSearch();
		System.out.println();
		System.out.println(tree.root.getItem());

	}
}
