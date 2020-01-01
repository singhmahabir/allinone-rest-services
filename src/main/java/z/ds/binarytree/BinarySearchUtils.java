/**
 * Copyright 2019. All rights reserved.
 */

package z.ds.binarytree;

/**
 *
 * <pre>
 * 		    binary search tree
 *		            5
 *				   / \
 *				  2   8
 *				 / \   \
 *				1   4   9
 * </pre>
 *
 * Time Complexity O(logn)
 *
 * @author Mahabir Singh
 *
 */
public class BinarySearchUtils {

	/**
	 * Searches the specified array of ints for the specified value using the binary
	 * search algorithm. The array must be sorted (as by the {@link #sort(int[])}
	 * method) prior to making this call. If it is not sorted, the results are
	 * undefined. If the array contains multiple elements with the specified value,
	 * there is no guarantee which one will be found.
	 *
	 * @param a   the array to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise,
	 *         -1
	 */
	public static int binarySearch(int[] a, int key) {

		return binarySearch1(a, 0, a.length - 1, key);
	}

	/**
	 * Searches a range of the specified array of ints for the specified value using
	 * the binary search algorithm. The range must be sorted (as by the
	 * {@link #sort(int[], int, int)} method) prior to making this call. If it is
	 * not sorted, the results are undefined. If the range contains multiple
	 * elements with the specified value, there is no guarantee which one will be
	 * found.
	 *
	 * @param a         the array to be searched
	 * @param fromIndex the index of the first element (inclusive) to be searched
	 * @param toIndex   the index of the last element (exclusive) to be searched
	 * @param key       the value to be searched for
	 * @return index of the search key, if it is contained in the array within the
	 *         specified range; otherwise, -1
	 * @throws IllegalArgumentException       if {@code fromIndex > toIndex}
	 * @throws ArrayIndexOutOfBoundsException if
	 *                                        {@code fromIndex < 0 or toIndex > a.length}
	 */
	public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
		rangeCheck(a.length, fromIndex, toIndex);
		return binarySearch0(a, fromIndex, toIndex, key);
	}

	public static <X extends Comparable<X>> int objectBinarySearch(X[] arr, X data) {
		return -1;
	}

	public boolean isBinarySearchTree(int[] a) {
		return false;
	}

	public static int countOccurrence(int[] a, int key) {
		final int first = occurrenceOfBinarySearch(a, key, true);
		if (first == -1) {
			return first + 1;
		}
		final int last = occurrenceOfBinarySearch(a, key, false);
		return last - first + 1;
	}

	public static int firstOccurrenceOfBinarySearchTree(int[] a, int key) {
		return occurrenceOfBinarySearch(a, key, true);
	}

	public static int lastOccurrenceOfBinarySearchTree(int[] a, int key) {
		return occurrenceOfBinarySearch(a, key, false);
	}

	public static int countRotationOfCircularBinarySearch(int[] a) {
		int low = 0;
		final int n = a.length;
		int high = n - 1;
		while (low <= high) {
			// case :1 a[low] < a[high] return low
			if (a[low] <= a[high]) {
				return low;
			}
			// case :2 a[mid] <= a[next] && a[mid] <= a[pre] return mid
			final int mid = low + (high - low) / 2;
			final int next = (mid + 1) % n;
			final int pre = (mid + n - 1) % n;

			if (a[mid] <= a[next] && a[mid] <= a[pre]) {
				return mid;
			}
			// case :3 a[mid] < a[high] set high = mid-1
			if (a[mid] < a[high]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static int circularBinarySearch(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			final int mid = low + (high - low) / 2;
			// case :1 a[mid] == key found
			if (a[mid] == key) {
				return mid;
			}
			// case :2 a[mid] <= a[high] mean right half is sorted
			if (a[mid] <= a[high]) {
				// case :2A key > a[mid] && key < a[high]
				if (key > a[mid] && key <= a[high]) {
					low = mid + 1; // go search in right sorted half
				}
				// case :2B
				else {
					high = mid - 1;
				}
			}
			// case :3 a[mid] >= a[high]
			else {
				// case :3A key > a[low] && key < a[mid]
				if (key >= a[low] && key < a[mid]) {
					high = mid - 1; // go search in left sorted half
				}
				// case :3B
				else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	/**
	 *
	 * @param a
	 * @param key
	 * @param search true for first occurrence and false for last occurrence
	 * @return
	 */
	private static int occurrenceOfBinarySearch(int[] a, int key, boolean search) {
		int low = 0;
		int high = a.length - 1;
		int result = -1;
		if (low > high) {
			return result;
		}
		while (low <= high) {
			final int mid = (low + high) >>> 1;
			if (a[mid] == key) {
				result = mid;
				if (search) { // mean search for first occurrence
					high = mid - 1;
				} else { // mean search for last occurrence
					low = mid + 1;
				}
			} else if (key < a[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}

	/**
	 *
	 * Iterative implementation
	 */
	private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
		int low = fromIndex;
		int high = toIndex;

		while (low <= high) {
//			int mid = (low + high)/2;
//			int mid = low +(high-low)/2; // (low +high) may overflow
			final int mid = (low + high) >>> 1;
			if (key > a[mid]) {
				low = mid + 1;
			} else if (key < a[mid]) {
				high = mid - 1;
			} else {
				return mid; // key found
			}
		}
		return -1; // key not found.
	}

	/**
	 *
	 * Recursive implementation
	 */
	private static int binarySearch1(int[] a, int fromIndex, int toIndex, int key) {
		int low = fromIndex;
		int high = toIndex;
		if (low > high) {
			return -1; // key not found.
		}
//	    int mid = (low + high)/2;
		final int mid = (low + high) >>> 1;
		if (key > a[mid]) {
			low = mid + 1;
			return binarySearch1(a, low, high, key);
		} else if (key < a[mid]) {
			high = mid - 1;
			return binarySearch1(a, low, high, key);
		} else {
			return mid; // key found
		}
	}

	/**
	 * Checks that {@code fromIndex} and {@code toIndex} are in the range and throws
	 * an exception if they aren't.
	 */
	private static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
		if (fromIndex > toIndex) {
			throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
		}
		if (fromIndex < 0) {
			throw new ArrayIndexOutOfBoundsException(fromIndex);
		}
		if (toIndex > arrayLength) {
			throw new ArrayIndexOutOfBoundsException(toIndex);
		}
	}

	public static void main(String[] args) {
		final int[] a = new int[] { 7, 8, 9, 1, 2, 3, 4, 5, 6 };

		System.err.println("rotation count " + countRotationOfCircularBinarySearch(a));
		System.err.println("circular " + circularBinarySearch(a, 1));
		System.err.println("binary " + binarySearch(a, 9));

		System.out.println("done");
	}
}
