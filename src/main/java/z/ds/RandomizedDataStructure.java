/**
 * Copyright 2019 Mahabir Singh. All rights reserved.
 */

package z.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * @author Mahabir Singh
 *
 */
public class RandomizedDataStructure<T> {

	private final Map<T, Integer> map;
	private final List<T> list;
	private final Random random;

	/**
	 *
	 */
	public RandomizedDataStructure() {
		map = new HashMap<>();
		list = new ArrayList<>();
		random = new Random();
	}

	public void add(T value) {
		if (!map.containsKey(value)) {
			final int index = list.size();
			map.put(value, index);
			list.add(value);
		}
	}

	public boolean contains(T value) {
		if (value == null) {
			throw new NullPointerException();
		}
		return map.containsKey(value);
	}

	public T getRandom() {
		if (map.isEmpty()) {
			throw new NoSuchElementException();
		}
		final int index = random.nextInt(list.size());
		return list.get(index);
	}

	public T deleteRandom() {
		if (map.isEmpty()) {
			throw new NoSuchElementException();
		}
		final int index = random.nextInt(list.size());
		return deleteValue(index);
	}

	public T delete(T value) {
		if (!map.containsKey(value)) {
			throw new NoSuchElementException();
		}
		final int index = map.get(value);
		return deleteValue(index);
	}

	private T deleteValue(int index) {
		final T deletedValue = list.get(index);
		map.remove(deletedValue);
		Collections.swap(list, index, list.size() - 1);
		list.remove(list.size() - 1);
		map.put(list.get(index), index);
		return deletedValue;
	}

	public int size() {
		if (list.size() != map.size()) {
			// should never happen.
			throw new IllegalStateException();
		}
		return list.size();
	}

	public static void main(String[] args) {
		final RandomizedDataStructure<Integer> structure = new RandomizedDataStructure<>();
		structure.add(4);
		structure.add(5);
		structure.add(6);

		System.out.println(structure.contains(5));
		final Integer deleteRandom = structure.deleteRandom();
		System.out.println(deleteRandom);
		System.out.println(structure.contains(deleteRandom));
		System.out.println(structure.size());
		System.out.println(structure.deleteValue(0));
		System.out.println(structure.size());
	}
}
