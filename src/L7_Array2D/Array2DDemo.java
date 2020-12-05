package L7_Array2D;

public class Array2DDemo {

	public static void main(String[] args) {

		int[][] arr = null;
		System.out.println(arr);

		arr = new int[3][6];
		System.out.println(arr);

		// no. of rows
		System.out.println(arr.length);
		// no. of cols
		System.out.println(arr[0].length);

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		for (int r = 0; r < arr.length; r++) {

			int[] a = arr[r]; // 3k 4k 5k

			for (int c = 0; c < a.length; c++) {
				System.out.print(a[c] + " ");
			}

			System.out.println();

		}

		// printing a particular row
		for (int i = 0; i < arr[1].length; i++) {
			System.out.print(arr[1][i] + " ");
		}
		System.out.println();

		// update
		arr[1][3] = 60;

		// print
		for (int r = 0; r < arr.length; r++) {

			// int[] a = arr[r];
			for (int c = 0; c < arr[0].length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();

		}

		// efl
		for (int[] a : arr) {

			for (int val : a) {
				System.out.print(val + " ");
			}
			System.out.println();
		}

		// Jagged Array
		int[][] jarr = new int[3][];

		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

		jarr[0] = new int[3];
		jarr[1] = new int[4];
		jarr[2] = new int[1];

		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

		// printing
		for (int[] a : jarr) {

			for (int val : a) {
				System.out.print(val + " ");
			}
			System.out.println();
		}

		for (int r = 0; r < jarr.length; r++) {

			for (int c = 0; c < jarr[r].length; c++) {
				System.out.print(jarr[r][c] + " ");
			}
			System.out.println();

		}

	}

}
