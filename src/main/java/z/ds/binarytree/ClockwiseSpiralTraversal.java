package z.ds.binarytree;

import z.ds.binarytree.BinaryTreeUnidirectional.Node;

public class ClockwiseSpiralTraversal {

    /**
     * Method 1 (Recursive) This problem can be seen as an extension of the level
     * order traversal post. To print the nodes in ClockWise spiral order, nodes at
     * top and bottom levels should be printed in alternating order. An additional
     * Boolean variable ltr is used to change printing order of levels. If ltr is
     * false then printGivenLevel() prints nodes from left to right else from right
     * to left. Value of ltr is flipped in each iteration to change the order.
     *
     *
     * <pre>
     * 		    binary search tree
     *		                    5
     *				   / \
     *				  2   8
     *				 / \   \
     *				1   4   9
     *					 \
     *					  12
     * </pre>
     *
     * @param root starting point
     */
    public static <X extends Comparable<X>> void printClockwiseSpiralOrder(Node<X> root, boolean isAntiClockWise) {
	if (root == null) {
	    return;
	}
	/**
	 * If you want to start from left spiral then set itr with true else false for
	 * right spiral
	 */
	boolean itr = isAntiClockWise;
	final int height = findHeightOfTree(root);
	for (int level = 1; level <= height / 2; level++) {
	    printLevel(root, level, itr);
	    itr = !itr;
	    printLevel(root, height + 1 - level, itr);
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
	printClockwiseSpiralOrder(root, false);
    }

}
