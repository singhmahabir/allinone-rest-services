
/**
 * Copyright 2019. All rights reserved.
 */

package z.ds;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 *
 * @author Mahabir Singh
 *
 */
public class SortingTest {

	// total 12 element
	int[] a = new int[] { 8, 14, 16, 23, 2, 4, 5, 6, 7, 34, 56, 67 };

	@Test
	public void selectionSort() {
		int[] expecteds = new int[] { 2, 4, 5, 6, 7, 8, 14, 16, 23, 34, 56, 67 };
		int[] selectionSort = Sorting.selectionSortReturn(a);
//		Arrays.stream(selectionSort).forEach(i-> System.out.println(i));
		Arrays.stream(selectionSort).forEach(System.out::println);
		assertArrayEquals(expecteds, selectionSort);
	}

}
