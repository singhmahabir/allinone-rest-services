package z.ds;

import java.util.Arrays;

public class FibonacciSequence {

	static int[] f;

	/**
	 * O(n)
	 * 
	 * <pre>
	 * 
	 * F[N] =      { F[N-1] + F[N-2] }    If N >0
	 * 		   { N   	     } 	  If N == 0,1
	 * </pre>
	 * 
	 * @param n
	 * @return
	 */
	public static int fibonacciSequenceWithMeMoization(int n) {
//	if (n <= 1) {
//	    return n;
//	}
		if (f[n] != -1) {
			return f[n];
		}
		f[n] = fibonacciSequenceWithMeMoization(n - 1) + fibonacciSequenceWithMeMoization(n - 2);

		return f[n];
	}

	/**
	 * O(2^n)
	 */
	public static int fibonacciSequence(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacciSequence(n - 1) + fibonacciSequence(n - 2);

	}

	/**
	 * O(n)
	 */
	public static int fibonacciSequenceWithIteratoin(int n) {
		if (n <= 1) {
			return n;
		}
		int f1 = 0;
		int f2 = 1;
		int f = 0;
		for (int i = 2; i <= n; i++) {
			f = f1 + f2;
			f1 = f2;
			f2 = f;
			if (i != n) {
			}
		}
		return f;
	}

	public static void main(String[] args) {
		f = new int[55];
		Arrays.fill(f, -1);
		f[0] = 0;
		f[1] = 1;
		int result = fibonacciSequenceWithIteratoin(400);
		System.out.println(result);
//	int result = fibonacciSequence(45);
//	System.out.println(result);
	}
}
