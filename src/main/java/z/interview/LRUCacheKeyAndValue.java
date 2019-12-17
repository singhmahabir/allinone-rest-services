/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.interview;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author Mahabir Singh
 *
 */
public class LRUCacheKeyAndValue {

	// store keys of cache
	private final Deque<Integer> dq;
	// store references of key in cache
	private final HashSet<Integer> map;
	// maximum capacity of cache
	private final int csize;

	/**
	 *
	 */
	public LRUCacheKeyAndValue() {
		this(4);
	}

	/**
	 * @param defaultCapacity
	 */
	public LRUCacheKeyAndValue(int defaultCapacity) {
		csize = defaultCapacity;
		dq = new LinkedList<>();
		map = new HashSet<>();

	}

	/* set key x in the LRU cache */
	public void set(int x) {
		if (map.contains(x)) {
			dq.remove(x); // remove from entry
			dq.addFirst(x); // then add at first
		} else {
			if (dq.size() == csize) {
				final int last = dq.removeLast();
				System.out.println("removing from queue " + last);
				map.remove(last);
			}
			dq.push(x);
//			dq.addFirst(x);
			map.add(x);
		}
	}

	// display contents of cache
	public void display() {
		dq.forEach(x -> System.out.print(x + " "));
	}

	@Override
	public String toString() {
		return dq.stream().map(String::valueOf).collect(Collectors.joining(" "));
	}

	public static void main(String[] args) {
		final LRUCacheKeyAndValue ob = new LRUCacheKeyAndValue();
		ob.set(5);

		ob.set(4);
		ob.set(3);
		ob.set(2);
		ob.set(1);
		ob.set(7);
		ob.set(8);
		ob.set(1);
		ob.display();
		System.out.println();
		System.out.println(ob);

	}
}
