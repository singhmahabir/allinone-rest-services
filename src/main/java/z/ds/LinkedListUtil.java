package z.ds;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

import lombok.Getter;
import lombok.Setter;

public class LinkedListUtil {

	public static <E extends Comparable<E>> Node<E> reverseUsingStack(Node<E> head) {
		final Deque<Node<E>> stack = new LinkedList<>();
		Node<E> ptr = head;

		while (ptr.getNext() != null) {
			stack.push(ptr);
			ptr = ptr.getNext();
		}

		head = ptr;
		while (!stack.isEmpty()) {
			ptr.setNext(stack.peek());
			ptr = ptr.getNext();
			stack.pop();
		}
		ptr.setNext(null); // block to make loop
		return head;
	}

	public static <E extends Comparable<E>> Node<E> reverse(Node<E> head) {
		Node<E> current = head;
		Node<E> next = null;
		Node<E> pre = null;

		while (current != null) {
			next = current.next; // 10 20 30
			current.next = pre;
			pre = current;
			current = next;
		}
		return pre;
	}

	public static <E extends Comparable<E>> Node<E> findLloop(Node<E> h) {
		final HashSet<Node<E>> s = new HashSet<>();
		while (h != null) {
			if (s.contains(h)) {
				return h;
			}
			s.add(h);

			h = h.next;
		}
		return null;
	}

	/**
	 * <p>
	 * Floyd’s Cycle-Finding Algorithm: This is the fastest method and has been
	 * described below:
	 *
	 * <ul style="list-style-type:circle;">
	 * <li>Traverse linked list using two pointers. Move one pointer(slow_p) by one
	 * and</li>
	 * <li>another pointer(fast_p) by two. If these pointers meet at the same node
	 * then</li>
	 * <li>there is a loop. If pointers do not meet then linked list doesn’t have a
	 * loop</li>
	 * </ul>
	 *
	 * @param <E>  Type of Class
	 * @param head root of LikedList
	 * @return Node
	 */
	public static <E extends Comparable<E>> Node<E> findLloopByLoop(Node<E> head) {
		if (head == null || head.getNext() == null) {
			return null;
		} else if (head == head.next) {
			return head;
		}
		Node<E> current = head;
		Node<E> next = current.getNext();

		while (current != null && next != null) {
			if (current == next) {
				return next;
			}
			current = current.getNext();
			next = next.getNext().getNext();

		}
		return null;
	}

	public static <E extends Comparable<E>> void median(Node<E> head) {
		if (head == null) {
			return;
		}
		Node<E> current = head;
		Node<E> middle = head;
		Node<E> middleforEven = head;
		int length = 1;

		while (current.getNext() != null) {
			length++;
			if (length % 2 == 0) {
				middleforEven = middle;
				middle = middle.getNext();
			}
			current = current.getNext();
		}

		System.out.println("length of LinkedList: " + length);
		if (length % 2 == 1) {
			System.out.println("odd middle element of LinkedList : " + middle.getData());
		} else {
			System.out.println(
					"even middle element of LinkedList : " + middleforEven.getData() + " , " + middle.getData());
		}

	}

	public static <E extends Comparable<E>> void print(Node<E> head) {
		System.out.print("{");
		while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}
		System.out.print("}\n");
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

		final Node<Integer> duplicate = new Node<>(12);
		final Node<Integer> head = new Node<>(10);

		head.setNext(duplicate);
		head.getNext().setNext(duplicate);
//		head.getNext().getNext().setNext(new Node<>(25));
//		head.getNext().getNext().getNext().setNext(new Node<>(20));
		// print like 10 12 15 25 20

//		print(findLloopByLoop(head));
		System.out.println(findLloopByLoop(head).getData());
//		print(reverse(head));
//		median(head);

	}

}
