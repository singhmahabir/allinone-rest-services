/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.interview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Mahabir Singh
 *
 */
public class LRUCacheUsingLinkedHashMap<K, V> {

	private final int capacity;
	private final Map<K, V> cache;

	/**
	 *
	 */
	public LRUCacheUsingLinkedHashMap() {
		this(2);
	}

	/**
	 * @param defaultCapacity
	 */
	public LRUCacheUsingLinkedHashMap(int defaultCapacity) {
		capacity = defaultCapacity;
		cache = new LinkedHashMap<K, V>(defaultCapacity, 0.75f, true) {
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
				return size() > capacity;
			}
		};

	}

	// This method works in O(1)
	public void set(K key, V value) {
		System.out.println("Going to set the (key, " + "value) : (" + key + ", " + value + ")");
		cache.put(key, value);
	}

	// This method works in O(1)
	public V get(K key) {
		System.out.println("Going to get the value " + "for the key : " + key);
		return cache.getOrDefault(key, null);
	}

	public static void main(String[] args) {
		final LRUCacheUsingLinkedHashMap<Integer, Integer> ob = new LRUCacheUsingLinkedHashMap<>();
		ob.set(1, 100);
		ob.set(2, 100);
		System.out.println(ob.cache);
		ob.set(3, 100);
		System.out.println(ob.cache);
		System.out.println(ob.get(2));
		ob.set(4, 100);
		System.out.println(ob.cache);
	}
}
