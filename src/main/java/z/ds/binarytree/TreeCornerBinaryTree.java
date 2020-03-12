package z.ds.binarytree;

import z.ds.binarytree.BinaryTreeUnidirectional.Node;

/**
 * <pre>
 * 	1. Print the left boundary in top-down manner.
	2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
		2.1 Print all leaf nodes of left sub-tree from left to right.
		2.2 Print all leaf nodes of right subtree from left to right.
	3. Print the right boundary in bottom-up manner.
 * </pre>
 * 
 * @author Mahabir Singh
 *
 */
public class TreeCornerBinaryTree {

    public static <X extends Comparable<X>> void printTreeBoundary(Node<X> root, boolean startFromLeft) {
	if (root == null) {
	    return;
	}
	System.out.print(root.getData() + " ");
	if (startFromLeft) {
	    printBoundaryLeft(root.getLeft());

	    // Print all leaf nodes
	    printSubLeftLeaves(root.getLeft());
	    printSubRightLeaves(root.getRight());

	    // Print the right boundary in bottom-up manner
	    printBoundaryRight(root.getRight());
	} else {
	    // start from right

	}

    }

    public static <X extends Comparable<X>> void printSubLeftLeaves(Node<X> root) {
	if (root == null || (root.getLeft() == null && root.getRight() == null)) {
	    return;
	}

	printSubLeftLeaves(root.getLeft());
	leftRightTree(root.getRight());
    }

    public static <X extends Comparable<X>> void printSubRightLeaves(Node<X> root) {
	if (root == null || (root.getLeft() == null && root.getRight() == null)) {
	    return;
	}
	leftRightTree(root.getLeft());
	printSubRightLeaves(root.getRight());
    }

    /**
     * @param left
     */
    private static <X extends Comparable<X>> void leftRightTree(Node<X> root) {
	if (root == null) {
	    return;
	} else if (root.getLeft() == null && root.getRight() == null) {
	    System.out.print(root.getData() + " ");
	    return;
	}
	Node<X> left = root;
	while (left.getLeft() != null) {
	    left = left.getLeft();
	}
	if (left.getRight() == null) {
	    System.out.print(left.getData() + " ");
	}

	Node<X> right = root;
	while (right.getRight() != null) {
	    right = right.getRight();
	}
	if (right.getLeft() == null) {
	    System.out.print(right.getData() + " ");
	}

    }

    public static <X extends Comparable<X>> void printBoundaryLeft(Node<X> root) {
	if (root == null) {
	    return;
	}
	System.out.print(root.getData() + " ");
	printBoundaryLeft(root.getLeft());

	/*
	 * while(root!=null) { System.out.print(root.getData() + " "); root =
	 * root.getLeft(); }
	 */
    }

    public static <X extends Comparable<X>> void printBoundaryRight(Node<X> root) {
	if (root == null) {
	    return;
	}
	printBoundaryRight(root.getRight());
	System.out.print(root.getData() + " ");
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
	// Let us construct the tree given in the above diagram
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

	printTreeBoundary(root, true);
//	printBoundaryLeft(root);
//	printBoundaryRight(root.getRight());
//	printSubLeftLeaves(root.getLeft());
//	printSubRightLeaves(root.getRight());

    }
}
