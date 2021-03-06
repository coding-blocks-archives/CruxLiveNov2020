package L6_Arrays;

import java.util.Scanner;

public class ArrayOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] a = { 10, -20, 30, 40 };
		// display(a);
		// reverse(a);
		// rotate2(a, 4);
		// int[] res = inverse(a);
		// display(res);
		// barGraph(a) ;

		// maxSumOfSubarray(a);
		maxSumOfSubarray2lLoops(a);

	}

	public static int[] takeInput() {

		System.out.println("Size ?");
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] : ");
			arr[i] = scn.nextInt();

		}

		return arr;

	}

	public static void display(int[] arr) {

		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();

	}

	public static int maximum(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}

		return max;
	}

	//
	// public static int search(int[] arr, int item) {
	//
	// }

	public static void reverse(int[] arr) {

		int si = 0;
		int ei = arr.length - 1;

		while (si < ei) {

			// swap
			int temp = arr[si];
			arr[si] = arr[ei];
			arr[ei] = temp;

			si++;
			ei--;

		}

	}

	public static void reverse(int[] arr, int i, int j) {

		int si = i;
		int ei = j;

		while (si < ei) {

			// swap
			int temp = arr[si];
			arr[si] = arr[ei];
			arr[ei] = temp;

			si++;
			ei--;

		}

	}

	public static void rotate(int[] arr, int rot) {

		rot = rot % arr.length;

		if (rot < 0)
			rot = rot + arr.length;

		for (int r = 1; r <= rot; r++) {

			int temp = arr[arr.length - 1];

			for (int i = arr.length - 1; i >= 1; i--) {
				arr[i] = arr[i - 1];
			}

			arr[0] = temp;

		}

	}

	public static void rotate2(int[] arr, int rot) {

		rot = rot % arr.length;

		if (rot < 0)
			rot = rot + arr.length;

		reverse(arr, 0, arr.length - rot - 1);
		reverse(arr, arr.length - rot, arr.length - 1);
		reverse(arr);

	}

	public static int[] inverse(int[] arr) {

		int[] na = new int[arr.length];

		// logic ...

		for (int i = 0; i < arr.length; i++)
			na[arr[i]] = i;

		return na;
	}

	public static void barGraph(int[] arr) {

		int rows = maximum(arr);

		for (int row = 1; row <= rows; row++) {

			for (int col = 0; col < arr.length; col++) {

				if (row <= rows - arr[col]) {
					System.out.print(" ");
				} else {
					System.out.print("| ");
				}

			}

			System.out.println();

		}

	}

	public static void printSubarray(int[] arr) {

		for (int si = 0; si <= arr.length - 1; si++) {

			for (int ei = si; ei <= arr.length - 1; ei++) {

				for (int k = si; k <= ei; k++) {
					System.out.print(arr[k] + " ");
				}

				System.out.println();

			}

		}

	}

	public static void sumOfSubarray(int[] arr) {

		for (int si = 0; si <= arr.length - 1; si++) {

			for (int ei = si; ei <= arr.length - 1; ei++) {

				int sum = 0;
				for (int k = si; k <= ei; k++) {
					sum = sum + arr[k];
				}

				System.out.println(sum);

			}

		}

	}

	public static void maxSumOfSubarray(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int si = 0; si <= arr.length - 1; si++) {

			for (int ei = si; ei <= arr.length - 1; ei++) {

				int sum = 0;
				for (int k = si; k <= ei; k++) {
					sum = sum + arr[k];
				}

				if (sum > max)
					max = sum;

			}

		}

		System.out.println(max);

	}

	public static void sumOfSubarray2lLoops(int[] arr) {

		for (int si = 0; si <= arr.length - 1; si++) {

			int sum = 0;

			for (int ei = si; ei <= arr.length - 1; ei++) {

				sum = sum + arr[ei];

				System.out.println(sum);

			}

		}

	}

	public static void maxSumOfSubarray2lLoops(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int si = 0; si <= arr.length - 1; si++) {

			int sum = 0;

			for (int ei = si; ei <= arr.length - 1; ei++) {

				sum = sum + arr[ei];

				if (sum > max)
					max = sum;

			}

		}

		System.out.println(max);

	}

}
