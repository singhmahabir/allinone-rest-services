package z.interview;

import lombok.Getter;
import lombok.Setter;

public class LinkedListUtil {

	public static void print(Node head) {
		System.out.print("{");
		while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}
		System.out.print("}\n");
	}

	public static Node reverse(Node head) {
		return null;
	}

	@Setter
	@Getter
	public static class Node<E extends Comparable<E>> {
		E data;
		Node<E> next;

		Node(E data) {
			this.data = data;
		}

	}

	public static void main(String[] args) {
		Node<Integer> head = new Node<>(10);
		head.setNext(new Node<>(12));
		head.getNext().setNext(new Node<>(15));
		head.getNext().getNext().setNext(new Node<>(25));
		// print like 10 12 15 25

		print(head);
	}

}
