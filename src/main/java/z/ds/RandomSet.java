/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package z.ds;

import java.util.HashSet;
import java.util.Random;

/**
 * @author Mahabir Singh
 *
 */
public class RandomSet<T> {

	private final HashSet<T> set = new HashSet<>();
	private final Random random = new Random();

	public boolean insert(T x) {
		return set.add(x);
	}

	public boolean remove(T x) {
		return set.remove(x);
	}

	public boolean search(T x) {
		return set.contains(x);
	}

	public T getRandom() {
		final int key = random.nextInt(set.size());
		final T[] nums = toArray();
		return nums[key];
	}

	public T[] toArray() {
		final T[] nums = (T[]) new Object[set.size()];
		set.toArray(nums);
		return nums;
	}

	public int size() {
		return set.size();
	}

	public static void main(String[] args) {
		final RandomSet<Integer> random = new RandomSet<>();
		random.insert(2);
		random.insert(3);
		random.insert(4);
		random.insert(5);
		random.insert(6);
		System.out.println(random.search(3));
		System.out.println(random.remove(2));
		System.out.println(random.getRandom());
		System.out.println(random.size());
		System.out.println(random.search(2));
	}
}
