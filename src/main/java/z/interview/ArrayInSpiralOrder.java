package z.interview;

/**
 *
 * @author Mahabir Singh
 *
 */
public class ArrayInSpiralOrder {

	public static void main(String[] args) {
		final int[][] ar = { { 2, 4, 6, 8 }, { 5, 9, 12, 16 }, { 2, 11, 5, 9 }, { 3, 2, 1, 8 } };
		spiralOrder(ar, 4, 4);
	}

	/**
	 * <pre>
	 *
	 * 	  t=2-->4-->6-->8
	 * 			        |
	 * 		5-->9-->12 16
	 * 		|       |   |
	 * 		2  11<--5   9
	 * 		|	    	|
	 * 	  b=3<--2<--1<--8
	 * 	    l  	   		r
	 * </pre>
	 *
	 * @param ar array to print in spiral order
	 */
	private static void spiralOrder(int[][] ar, int row, int column) {
		int top = 0;
		int bottom = row - 1;
		int left = 0;
		int right = column - 1;
//	dir 0 mean right 1 mean down 2 mean left and 3 mean up so initially dir is 0
		int dir = 0;

		while (top <= bottom && left <= right) {

			switch (dir) {
			// dir 0 mean left to right L to R
			case 0: {
				for (int i = left; i <= right; i++) {
					System.out.print(ar[top][i] + " ");
				}
				top++;
				dir = 1;
				break;
			}
			// dir 1 mean top to down T to B
			case 1: {
				for (int i = top; i <= bottom; i++) {
					System.out.print(ar[i][right] + " ");
				}
				right--;
				dir = 2;
				break;
			}
			// dir 2 mean left to right R to L
			case 2: {
				for (int i = right; i >= left; i--) {
					System.out.print(ar[bottom][i] + " ");
				}
				bottom--;
				dir = 3;
				break;
			}
			// dir 3 mean down to up B to T
			case 3: {
				for (int i = bottom; i >= top; i--) {
					System.out.print(ar[i][left] + " ");
				}
				left++;
				dir = 0;
				break;
			}
			default:
				break;
			}
		}
	}

}
