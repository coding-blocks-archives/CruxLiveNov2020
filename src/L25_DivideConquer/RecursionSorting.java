package L25_DivideConquer;

public class RecursionSorting {

	public static void main(String[] args) {

//		int[] one = { 10, 30, 50, 80, 100 };
//		int[] two = { 15, 20, 25, 60, 70 };
//
//		int[] ans = mergeTwoSortedArrays(one, two);
//		for(int val : ans)
//			System.out.print(val + " ");

		int[] arr = { 80, 10, 50, 30, 60, 20, 70, 25 };

//		int[] ans = mergeSort(arr, 0, arr.length - 1);
//		for (int val : ans) {
//			System.out.print(val + " ");
//		}

		quickSort(arr, 0, arr.length - 1);
		for (int val : arr)
			System.out.print(val + " ");

	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {

		int[] ans = new int[one.length + two.length];

		int i = 0; // one
		int j = 0; // two
		int k = 0; // ans

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				ans[k] = one[i];
				i++;
				k++;
			} else {
				ans[k] = two[j];
				j++;
				k++;
			}

		}

		if (j == two.length) {

			while (i < one.length) {
				ans[k] = one[i];
				i++;
				k++;
			}
		}

		if (i == one.length) {

			while (j < two.length) {
				ans[k] = two[j];
				j++;
				k++;
			}
		}

		return ans;
	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fp = mergeSort(arr, lo, mid);
		int[] sp = mergeSort(arr, mid + 1, hi);

		int[] merged = mergeTwoSortedArrays(fp, sp);

		return merged;

	}

	public static void quickSort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		// partitioning
		int left = lo;
		int right = hi;

		while (left <= right) {

			// left stop problem
			while (arr[left] < pivot)
				left++;

			// right stop problem
			while (arr[right] > pivot)
				right--;

			// swap
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}

		}

		quickSort(arr, lo, right);
		quickSort(arr, left, hi);

	}
}
