/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.interview;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Mahabir Singh
 *
 */
public class ConnectNRopesWithMinimumCost {

	// Driver program to test above function
	public static void main(String args[]) {
		final Integer[] len = { 4, 3, 6, 2 };
		final int size = len.length;
		System.out.println("Total cost for connecting" + " ropes is " + minCost(len, size));

	}

	static int minCost(Integer[] arr, int n) {
		// Create a priority queue
//        final PriorityQueue<Integer> pq = new PriorityQueue<>();
		final PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(arr));

		// Adding items to the pQueue
//		for (int i = 0; i < n; i++) {
//			pq.add(arr[i]);
//		}

		// Initialize result
		int res = 0;

		// While size of priority queue
		// is more than 1
		while (pq.size() > 1) {
			// Extract shortest two ropes from pq
			final int first = pq.poll();
			final int second = pq.poll();

			// Connect the ropes: update result
			// and insert the new rope to pq
			res += first + second;
			pq.add(first + second);
		}

		return res;
	}

}
