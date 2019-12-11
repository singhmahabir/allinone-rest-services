package z.ds;

public class CalculatePow {

	/**
	 * x pow n
	 * 
	 * <pre>
	 * 
	 * X^N =     { X * (X^N-1) }  	 If N is odd or even
	 * 		 { 1   	       }	 If N is 0
	 * </pre>
	 * 
	 * O(n)
	 * 
	 * @param x it is a positive number
	 * @param n it is a positive number which is power of x
	 * @return
	 */
	public static int pow(int x, int n) {
		if (n == 0) {
			return 1;
		} else {

			return x * pow(x, n - 1);
		}
	}

	/**
	 * x pow n
	 * 
	 * <pre>
	 * 
	 * X^N =     { (X^N/2) * (X^N/2) }   If N is even
	 * 		 { X * (X^N-1) } 	 If N is odd 
	 * 		 { 1           }	 If N is 0
	 * </pre>
	 * 
	 * O{logn)
	 * 
	 * @param x it is a positive number
	 * @param n it is a positive number which is power of x
	 * @return
	 */
	public static int powFast(int x, int n) {
		if (n == 0) {
			return 1;
		} else if (n % 2 == 0) {
			int y = powFast(x, n / 2);
			return y * y;
		} else {
			return x * pow(x, n - 1);
		}
	}

	/**
	 * x pow n
	 * 
	 * <pre>
	 * X^N % M =   { {(X^N/2 % M) * (X^N/2 % M)} % M}    If N is even
	 * 		   { {(X % M) * (X^N-1 % M)} % M} 	 If N is odd 
	 * 		   { 1   			}  	 If N is 0
	 * </pre>
	 * 
	 * O{logn)
	 * 
	 * @param x it is a positive number
	 * @param n it is a positive number which is power of x
	 * @return
	 */
	public static int powMod(int x, int n, int m) {
		if (n == 0) {
			return 1;
		} else if (n % 2 == 0) {
			int y = powMod(x, n / 2, m);
			return (y * y) % m;
		} else {
			return (x % m * powMod(x, n - 1, m)) % m;
		}
	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static void main(String[] args) {
		int pow = factorial(4);
		System.out.println(pow);
	}
}
