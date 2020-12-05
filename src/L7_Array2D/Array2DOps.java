package L7_Array2D;

import java.util.Scanner;

public class Array2DOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[][] a = takeInput();
		int[][] a = { { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 }, { 26, 27, 28, 29, 30 } };

		display(a);

		System.out.println("---- Wave Display ----");
		waveDisplay(a);

		System.out.println("---- Spiral Display ----");
		spiralDisplay(a);

		System.out.println("---- MM ----");
		int[][] one = { { 1, 2 } };
		int[][] two = { { 1, 2, 3 }, { 4, 5, 6 } };

		display(matrixMultiplication(one, two));

	}

	public static int[][] takeInput() {

		System.out.println("Rows ?");
		int rows = scn.nextInt();
		System.out.println("Cols ?");
		int cols = scn.nextInt();

		int[][] arr = new int[rows][cols];

		for (int r = 0; r < arr.length; r++) { // row

			for (int c = 0; c < arr[0].length; c++) {

				System.out.println("[" + r + "-" + c + "] ? ");
				arr[r][c] = scn.nextInt();

			}

		}

		return arr;

	}

	public static void display(int[][] arr) {

		for (int r = 0; r < arr.length; r++) { // row

			for (int c = 0; c < arr[0].length; c++) {
				System.out.print(arr[r][c] + " ");
			}

			System.out.println();

		}

	}

	public static void waveDisplay(int[][] arr) {

		for (int c = 0; c < arr[0].length; c++) {

			if (c % 2 == 0) {

				for (int r = 0; r < arr.length; r++) {
					System.out.print(arr[r][c] + " ");
				}

			} else {

				for (int r = arr.length - 1; r >= 0; r--) {
					System.out.print(arr[r][c] + " ");
				}

			}

		}

		System.out.println();

	}

	public static void spiralDisplay(int[][] arr) {

		int minRow = 0;
		int maxRow = arr.length - 1;
		int minCol = 0;
		int maxCol = arr[0].length - 1;

		int total = arr.length * arr[0].length; // total elements which are supposed to be printed
		int count = 0; // elements which are printed till now

		while (count < total) {

			// first col
			for (int r = minRow; r <= maxRow && count < total; r++) {
				System.out.print(arr[r][minCol] + " ");
				count++;
			}
			minCol++;

			// last row
			for (int c = minCol; c <= maxCol && count < total; c++) {
				System.out.print(arr[maxRow][c] + " ");
				count++;
			}
			maxRow--;

			// last col
			for (int r = maxRow; r >= minRow && count < total; r--) {
				System.out.print(arr[r][maxCol] + " ");
				count++;
			}
			maxCol--;

			// first row
			for (int c = maxCol; c >= minCol && count < total; c--) {
				System.out.print(arr[minRow][c] + " ");
				count++;
			}
			minRow++;

		}
		System.out.println();

	}

	public static int[][] matrixMultiplication(int[][] one, int[][] two) {

		int r1 = one.length;
		int c1 = one[0].length;

		int r2 = two.length;
		int c2 = two[0].length;

		int[][] res = new int[r1][c2];

		for (int i = 0; i < res.length; i++) {

			for (int j = 0; j < res[0].length; j++) {

				int sum = 0;
				for (int k = 0; k < c1; k++) {
					sum += one[i][k] * two[k][j];
				}

				res[i][j] = sum;

			}
		}

		return res;

	}

}
