
/**
 * Copyright 2019. All rights reserved.
 */

package z.ds;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Mahabir Singh
 * 
 *         <pre>
 * 		    binary search tree
 *		                    5
 *				   / \
 *				  2   8
 *				 / \   \
 *				1   4   9
 *         </pre>
 *
 * @param <X> X is any data type
 */
public class BasicBinaryTree<X extends Comparable<X>> {

	private Node root;
	private int size;

	public BasicBinaryTree() {
		this.root = null;
	}

	public void add(X item) {
		final Node newNode = new Node(item);
		// if this is the first item in the tree,set it as root
		if (root == null) {
			this.root = newNode;
			System.out.println("set root: " + newNode.getItem());
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

	public void printInOrder() {
		inOrder(this.root);
	}

	public void printPostOrder() {
		postOrder(this.root);
	}

	public void printPreOrder() {
		preOrder(this.root);
	}

	public boolean delete(X item) {
		boolean deleted = false;
		if (this.root == null) {
			return deleted;
		}
		// find a node to delete
		final Node currentNode = getNode(item);
		if (currentNode != null) {
			// if the node to delete doesn't have any children, just delete it
			if ((currentNode.getLeft() == null) && (currentNode.getRight() == null)) {
				unlink(currentNode, null);
				deleted = true;
			}
			// if the node to delete only has a any right children, remove it in the
			// hierarchy
			else if ((currentNode.getLeft() == null) && (currentNode.getRight() != null)) {
				unlink(currentNode, currentNode.getRight());
				deleted = true;
			}
			// if the node to delete only has a any left children, remove it in the
			// hierarchy
			else if ((currentNode.getLeft() != null) && (currentNode.getRight() == null)) {
				unlink(currentNode, currentNode.getLeft());
				deleted = true;
			}
			// if the node has both children, do a node swap to delete
			else {
				// you can swap out the node with the right most leaf mode on the left side
				Node child = currentNode.getLeft();
				while ((child.getRight() != null) && (child.getLeft() != null)) {
					child = child.getRight();
				}
				// we have the right most leaf node. we can replace the current node with this
				// node
				child.getParent().setRight(null); // remove the leaf node form it's current position

				child.setLeft(currentNode.getLeft());
				child.setRight(currentNode.getRight());

				unlink(currentNode, child);
				deleted = true;
			}
		}
		if (deleted) {
			this.size--;
		}
		return deleted;

	}

	private void unlink(Node currentNode, Node newNode) {
		// if this is the root node, we replace that a little differently
		if (currentNode == this.root) {
			newNode.setLeft(currentNode.getLeft());
			newNode.setRight(currentNode.getRight());
			this.root = newNode;
		} else if (currentNode.getParent().getRight() == currentNode) {
			currentNode.getParent().setRight(newNode);
		} else {
			currentNode.getParent().setLeft(currentNode);
		}
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
		System.out.print(root.getItem() + " "); // Print data
	}

	// Function to visit nodes in Preorder
	private void preOrder(Node root) {
		// base condition for recursion
		// if tree/sub-tree is empty, return and exit
		if (root == null) {
			return;
		}
		System.out.print(root.getItem() + " "); // Print data
		preOrder(root.getLeft()); // Visit left subtree
		preOrder(root.getRight()); // Visit right subtree
	}

	// Function to visit nodes in Inorder
	private void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.getLeft()); // Visit left subtree
		System.out.print(root.getItem() + " "); // Print data
		inOrder(root.getRight()); // Visit right subtree
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
}
