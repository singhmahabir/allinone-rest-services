/**
 * Copyright 2018 Mercedes Benz Research & Development, A Daimler Company. All rights reserved.
 */

package z.interview;

/**
 * @author Mahabir Singh
 *
 */
public class CheckDuplicatesWithinK {

    static boolean checkDuplicatesWithinK(int[] arr, int k) {

        // Traverse the input array
        for (int i = 0; i < (arr.length - k - 1); i++) {
            if (arr[i] == arr[i + k + 1]) {
                return true;
            }
        }
        return false;
    }

    // Driver method to test above method
    public static void main(String[] args) {
        final int[] arr = {10, 1, 6, 4, 3, 5, 6};
        if (checkDuplicatesWithinK(arr, 3))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
