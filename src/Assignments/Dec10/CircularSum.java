package Assignments.Dec10;

public class CircularSum {

	public static void main(String[] args) {

		// int[] arr = { 2, 3, -6, 1, 2, 3, -4, 5, -10, 6 };
		// System.out.println(kadane(arr));

		int[] arr = { 8, -8, 9, -9, 10, -11, 12 };
		System.out.println(maxCircularSum(arr));
	}

	public static int maxCircularSum(int[] arr) {

		// case 1 : CE are not wrapping : kadane
		int sumNotWrapping = kadane(arr);

		// case 2 : CE are wrapping : NCE are not wrapping
		int totalSum = 0;
		for (int i = 0; i < arr.length; i++) {
			totalSum += arr[i];
			arr[i] = -arr[i];
		}

		int sumNCE = kadane(arr);

		int sumWrapping = totalSum + sumNCE;

		return Math.max(sumNotWrapping, sumWrapping);
	}

	public static int kadane(int[] arr) {

		int sum = arr[0];
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {

			sum = Math.max(sum + arr[i], arr[i]);

			if (sum > max)
				max = sum;
		}

		return max;

	}

}
