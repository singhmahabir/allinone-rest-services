/**
 * Copyright 2019. All rights reserved.
 */

package z.interview;

public class OddOrEvenUsingBitwise {

	public static void main(String[] args) {
		int number = 5;

		System.out.printf("\nChecking  Odd or  Even number using  Remainder  operators\n");

		// Logic : 1

		if ((number % 2) == 0) {
			System.out.printf(number + " is even %n"); // %n for new line
		} else {
			System.out.printf(number + " is odd %n");
		}

		// Logic : 2

		int ld = number % 10;

		if (ld == 1 || ld == 3 || ld == 5 || ld == 7 || ld == 9) {
			System.out.printf(number + " is odd %n");
		} else {
			System.out.printf(number + " is even %n");
		}

		System.out.printf("\nChecking  Odd or  Even number using  Bitwise AND operator \n");

		// Logic : 3

		if ((number & 1) == 0) {
			System.out.printf(number + " is even %n");
		} else {
			System.out.printf(number + " is odd %n");
		}

		System.out.printf("\nChecking  Odd or  Even number using  Divide operator \n");

		// Logic : 4

		if ((number / 2) == ((double) number) / 2) {
			System.out.printf(number + " is even %n");
		} else {
			System.out.printf(number + " is odd %n");
		}
	}

}
