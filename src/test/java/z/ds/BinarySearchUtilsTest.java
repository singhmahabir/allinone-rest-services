
/**
 * Copyright 2019. All rights reserved.
 */

package z.ds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author Mahabir Singh
 *
 */
public class BinarySearchUtilsTest {

	// total 12 element
	int[] a = new int[] { 2, 4, 5, 6, 7, 8, 14, 16, 23, 34, 56, 67 };

	@Test
	public void testBinarySearch() {
		assertEquals(0, BinarySearchUtils.binarySearch(a, 2));
		assertEquals(10, BinarySearchUtils.binarySearch(a, 56));
		assertEquals(-1, BinarySearchUtils.binarySearch(a, 100));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBinarySearchForIllegalArgumentException() {
		assertEquals(0, BinarySearchUtils.binarySearch(a, 5, 4, 5));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testBinarySearchForArrayIndexOutOfBoundsException() {
		assertEquals(0, BinarySearchUtils.binarySearch(a, -1, 4, 5));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testBinarySearchForArrayIndexOutOfBoundsException_lastIndex() {
		assertEquals(0, BinarySearchUtils.binarySearch(a, 1, 13, 5));
	}

}
