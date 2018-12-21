/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.interviewe.datastructure;

/**
 * @author Mahabir Singh
 *
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

    public boolean contains(X item) {
        return getNode(item) != null;
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
            // if the node to delete only has a any right children, remove it in the hierarchy
            else if ((currentNode.getLeft() == null) && (currentNode.getRight() != null)) {
                unlink(currentNode, currentNode.getRight());
                deleted = true;
            }
            // if the node to delete only has a any left children, remove it in the hierarchy
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
                // we have the right most leaf node. we can replace the current node with this node
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
        size++;
    }

    public int size() {
        return this.size;
    }

    private class Node {
        private Node left;
        private Node right;
        private Node parent;
        private X item;

        public Node(X item) {
            this.item = item;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public X getItem() {
            return item;
        }

        public void setItem(X item) {
            this.item = item;
        }

    }
}
