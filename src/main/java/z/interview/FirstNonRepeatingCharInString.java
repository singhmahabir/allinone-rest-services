/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @author Mahabir Singh
 *
 *         Solve in one iterations
 */

public class FirstNonRepeatingCharInString {

	/**
	 * Finds first non repeated character in a String in just one pass. It uses two
	 * storage to cut down one iteration, standard space vs time trade-off.Since we
	 * store repeated and non-repeated character separately, at the end of
	 * iteration, first element from List is our first non repeated character from
	 * String.
	 */
	public static Character firstNonRepeatingChar(String word) {
		final Set<Character> repeatingSet = new HashSet<>();
		final List<Character> nonRepeatingList = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			final Character letter = word.charAt(i);
			if (repeatingSet.contains(letter)) {
				continue;
			}
			if (nonRepeatingList.contains(letter)) {
				nonRepeatingList.remove(letter);
				repeatingSet.add(letter);
			} else {
				nonRepeatingList.add(letter);
			}
		}
		if (nonRepeatingList.isEmpty()) {
			return null;
		} else {
			return nonRepeatingList.get(0);
		}
	}

	public static Character firstNonRepeatingCharUsingMap(String word) {
		final Map<Character, Integer> entry = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			final Character letter = word.charAt(i);
			if (entry.containsKey(letter)) {
				entry.put(letter, entry.get(letter) + 1);
			} else {
				entry.put(letter, 1);
			}
		}
		final Optional<Character> findFirst = entry.keySet()
				.stream()
				.filter(letter -> entry.get(letter).equals(1))
				.findFirst();
		if (findFirst.isPresent()) {

			return findFirst.get();
		} else {
			System.out.println("Not found");
			return null;
		}
	}

	public static void main(String[] args) {
		final Character c = firstNonRepeatingCharUsingMap("adbcabca");
		System.out.println("Repeting charater in String is " + c);

	}
}
