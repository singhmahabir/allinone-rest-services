
/**
 * Copyright 2019. All rights reserved.
 */

package z.ds;

import java.util.Arrays;

/**
 *
 * If the length of an array to be sorted is less than (47) this constant,
 * insertion sort is used in preference to Quicksort.
 *
 * <p>
 * If the length of a byte array to be sorted is greater than (29) this
 * constant, counting sort is used in preference to insertion sort.
 *
 * <p>
 * If the length of a short or char array to be sorted is greater than (3200)
 * this constant, counting sort is used in preference to Quicksort.
 *
 * @author Mahabir Singh
 *
 */
public class Sorting {

	private Sorting() {
	}

	/**
	 * First select the smallest and keep it from beginning
	 *
	 * <p>
	 * Selection sort selects i-th smallest element and places at i-th position.
	 * This algorithm divides the array into two parts: sorted (left) and unsorted
	 * (right) sub array. It selects the smallest element from unsorted sub array
	 * and places in the first position of that sub array (ascending order). It
	 * repeatedly selects the next smallest element.
	 * </p>
	 *
	 * <pre>
	 *    |2|7|4|1|5|3|  given array
	 *    |1|7|4|2|5|3|  1st iteration outer iteration
	 *    |1|2|4|7|5|3|  2nd iteration outer iteration
	 * 
	 * </pre>
	 * <p>
	 *
	 * <strong>O(n`2)<strong> is Time Complexity
	 *
	 * @param a array of integer to be sort
	 * @return integer sorted array
	 */
	public static int[] selectionSortReturn(int[] a) {
		for (int i = 0; i < a.length - 1; i++) { // we need to do n-1 pass
			int iMin = i; // ith position : element i till n-1 are candidate
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[iMin]) {
					iMin = j; // update the index of minimum element
				}
			}
			// swap i'th position with iMin'th position
			final int temp = a[iMin];
			a[iMin] = a[i];
			a[i] = temp;
		}
		return a;
	}

	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) { // we need to do n-1 pass
			int iMin = i; // ith position : element i till n-1 are candidate
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[iMin]) {
					iMin = j; // update the index of minimum element
				}
			}
			// swap i'th position with iMin'th position
			final int temp = a[iMin];
			a[iMin] = a[i];
			a[i] = temp;
		}
	}

	/**
	 * Bubble Sort is the simplest sorting algorithm that works by repeatedly
	 * swapping the adjacent elements if they are in wrong order
	 *
	 * <pre>
	 *    -------------
	 *    |2|7|4|1|5|3|  given array
	 *    |2|4|1|5|3|7|  1st outer iteration
	 *    |2|1|4|3|5|7|  2nd outer iteration
	 *    |1|2|3|4|5|7|  3rd outer iteration
	 *    no change in 4th and 5th iteration
	 * </pre>
	 *
	 * <strong>O(n`2)<strong> is Time Complexity
	 *
	 * @param a array of integer to be sort
	 * @return integer sorted array
	 */
	public static int[] bubbleSortReturn(int[] a) {
		for (int i = 0; i < a.length - 1; i++) { // we need to do n-1 pass
			boolean swapped = false;
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					// swap adjacent positions
					a[j] = a[j] + a[j + 1];
					a[j + 1] = a[j] - a[j + 1];
					a[j] = a[j] - a[j + 1];
					swapped = true;
				}
			}
			if (!swapped) {
				break; /* or return a; */
			}
		}
		return a;
	}

	public static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) { // we need to do n-2 pass
			boolean swapped = false;
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					// swap adjacent positions
					a[j] = a[j] + a[j + 1];
					a[j + 1] = a[j] - a[j + 1];
					a[j] = a[j] - a[j + 1];
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}

	/**
	 * Insertion sort is a simple sorting algorithm that works the way we sort
	 * playing cards in our hands.
	 *
	 * <pre>
	 *    |2|7|4|1|5|3|  given array
	 *    |2|4|1|5|3|7|  1st iteration
	 *    |2|1|4|3|5|7|  2nd iteration
	 *    |1|2|3|4|5|7|  3rd iteration
	 *    no change in 4th and 5th iteration
	 * </pre>
	 *
	 * <strong>O(n`2)<strong> is Time Complexity and <strong>O(n)<strong> is best
	 * case
	 *
	 * @param a array of integer to be sort
	 * @return integer sorted array
	 */
	public static int[] insertionSortReturn(int[] a) {
		for (int i = 1; i < a.length; i++) { // we need to do n-1 pass
			final int value = a[i];
			int hole = i;
			while (hole > 0 && a[hole - 1] > value) {
				a[hole] = a[hole - 1];
				hole--;
			}
			a[hole] = value;
		}
		return a;
	}

	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) { // we need to do n-1 pass
			final int value = a[i];
			int hole = i;
			while (hole > 0 && a[hole - 1] > value) {
				a[hole] = a[hole - 1];
				hole--;
			}
			a[hole] = value;
		}
	}

	/**
	 * 
	 * Like {@link #quickSort}, Merge Sort is a Divide and Conquer algorithm. It
	 * divides input array in two halves, calls itself for the two halves and then
	 * merges the two sorted halves.
	 * <p>
	 * Below are the properties of {@link #mergeSort}
	 * 
	 * <ul style="list-style-type:circle;">
	 * <li>Divide and Conquer
	 * <li>Recursive
	 * <li>Stable
	 * <li>Not in place
	 * </ul>
	 * 
	 * Best case O(n) worst case O(nlogn)
	 *
	 * @param a array of int to be sort
	 * @return int[] sorted array
	 */
	public static int[] mergeSortReturn(int[] a) {
		final int n = a.length;
		if (n < 2) {
			return a;
		}
		final int mid = n / 2; // 2,7,4,1,5,3

		int[] l = Arrays.copyOf(a, mid); // // 2,7,4 we can use like there in place of for loop
		int[] r = Arrays.copyOfRange(a, mid, n); // 1,5,3

		mergeSort(l);
		mergeSort(r);
		merge(l, r, a);
		return a;
	}

	public static void mergeSort(int[] a) {
		final int n = a.length;
		if (n < 2) {
			return;
		}
		final int mid = n / 2; // 2,7,4,1,5,3
		final int[] l = new int[mid]; // 2,7,4 // 2 //7,4
		final int[] r = new int[n - mid]; // 1,5,3

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		mergeSort(l);
		mergeSort(r);
		merge(l, r, a);
	}

	private static void merge(int[] l, int[] r, int[] a) {
		int i = 0;
		int j = 0;
		int k = 0;
		final int nL = l.length;
		final int nR = r.length;

		while (i < nL && j < nR) {
			if (l[i] < r[j]) {
				a[k] = l[i];
				k++;
				i++;
			} else {
				a[k] = r[j];
				k++;
				j++;
			}
		}
		while (i < nL) {
			a[k] = l[i];
			k++;
			i++;
		}
		while (j < nR) {
			a[k] = r[j];
			k++;
			j++;
		}
		Arrays.stream(a).forEach(System.out::print);
		System.out.println();
	}

	/**
	 * Like {@link #mergeSort} , QuickSort is a Divide and Conquer algorithm. It
	 * picks an element as pivot and partitions the given array around the picked
	 * pivot.
	 * <p>
	 * There are many different versions of quickSort that pick pivot in different
	 * ways.
	 * <ul style="list-style-type:square;">
	 * <li>Always pick first element as pivot.
	 * <li>Always pick last element as pivot (implemented below)
	 * <li>Pick a random element as pivot.
	 * <li>Pick median as pivot
	 * </ul>
	 * <p>
	 * Below are the properties of {@link #quickSort}
	 * <ul style="list-style-type:circle;">
	 * <li>Divide and Conquer
	 * <li>Recursive
	 * <li>Not stable
	 * <li>In place
	 * </ul>
	 * 
	 * <p>
	 * 
	 * <pre>
	 * Time Complexity <strong> O(nlogn) </strong> in average and best case
	 * 		  <strong> O(n'2) </strong> worst case
	 * but it can be avoided by using pivot randomly so it is <strong> O(nlogn) </strong>
	 * with very high probability
	 * </pre>
	 * 
	 * @param a array of int to be sort
	 * @return int[] sorted array
	 */
	public static int[] quickSortRerurn(int[] a) {
		quickSortReturn0(a, 0, a.length - 1);
		return a;
	}

	public static void quickSort(int[] a) {
		quickSort0(a, 0, a.length - 1);
	}

	private static int[] quickSortReturn0(int[] a, int start, int end) {
		if (start >= end) {
			return a;
		}
		final int pivot = partition(a, start, end);
		quickSortReturn0(a, start, pivot - 1);
		quickSortReturn0(a, pivot + 1, end);
		return a;

	}

	private static void quickSort0(int[] a, int start, int end) {
		if (start < end) {
			final int pivot = partition(a, start, end);
			quickSort0(a, start, pivot - 1);
			quickSort0(a, pivot + 1, end);
		}
	}

	private static int partition(int[] a, int start, int end) {
		int pivot = a[end]; // tacking last index as pivot always
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (a[i] < pivot) {
				int temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		a[end] = a[pIndex];
		a[pIndex] = pivot;
		return pIndex;
	}

	public static void main(String[] args) {
		final int[] o = Sorting.selectionSortReturn(new int[] { 2, 7, 4, 1, 5, 3 });
		System.err.println();
		int[] a = { 2, 7, 4, 1, 5, 3 };
		bubbleSort(a);
		Arrays.stream(quickSortRerurn(new int[] { 2, 7, 4, 1, 5, 3 })).forEach(System.out::print);
	}
}
