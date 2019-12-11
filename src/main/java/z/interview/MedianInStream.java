/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.interview;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Mahabir Singh
 *
 */
public class MedianInStream {

	final Set<Integer> set = new TreeSet<>();

	private void printMedian(Integer val) {
		set.add(val);

		if (set.size() == 1) {
			System.out.println("Median of " + set + " is " + set.stream().findFirst());
			return;
		}
		final int medianPoint = set.size() / 2;
		if ((set.size() % 2) == 0) {
			final Integer[] array = new Integer[set.size()];
			set.toArray(array);
			System.out.println("Median of " + set + " is " + ((array[medianPoint] + array[medianPoint - 1]) / 2));
		} else {
			final Integer[] array = new Integer[set.size()];
			set.toArray(array);
			System.out.println("Median of " + set + " is " + array[medianPoint]);
		}
	}

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		Integer val = 999999;
		final MedianInStream median = new MedianInStream();
		while (val != null) {
			val = sc.nextInt();
			median.printMedian(val);
		}
	}
}
