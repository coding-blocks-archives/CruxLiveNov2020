package L11_Recursion;

public class Recursion {

	public static void main(String[] args) {

		// PD(10);
		// PI(4);
		// PDI(5) ;

		// System.out.println(factorial(4));
		// System.out.println(power(3, 10));
		// System.out.println(fibonacci(8));

		int[] arr = { 10, 30, 90, 80, 50, 30, 60, 30, 30 };
		// reverseDisplayArray(arr, 0);
		// System.out.println(max(arr, 0));
		System.out.println(firstOccIndex(arr, 0, 30));
		System.out.println(lastOccIndex(arr, 0, 30));
		int[] res = allIndex(arr, 0, 30, 0);
		for (int val : res)
			System.out.println(val);

	}

	public static void PD(int n) { // BP : n to 1 counting dec

		if (n == 0)
			return;

		System.out.println(n);
		PD(n - 1); // SP : n-1 to 1 dec

	}

	public static void PI(int n) {

		if (n == 0)
			return;

		PI(n - 1);
		System.out.println(n);

	}

	public static void PDI(int n) {

		if (n == 0) {
			return;
		}

		System.out.println("hi " + n);
		PDI(n - 1);
		System.out.println("bye " + n);
	}

	public static int factorial(int n) { // bp

		if (n == 1) {
			return 1;
		}

		int fnm1 = factorial(n - 1); // sp
		int fn = fnm1 * n; // sw

		return fn;

		// return factorial(n - 1) * n;

	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int sp = power(x, n - 1);
		int bp = sp * x;

		return bp;

	}

	public static int fibonacci(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		int fn = fnm1 + fnm2;

		return fn;

	}

	public static void displayArray(int[] arr, int idx) {

		if (idx == arr.length) {
			return;
		}

		System.out.println(arr[idx]); // sw
		displayArray(arr, idx + 1); // sp

	}

	public static void reverseDisplayArray(int[] arr, int idx) { // 50 40 30 20 10

		if (idx == arr.length) {
			return;
		}

		reverseDisplayArray(arr, idx + 1); // sp : 50 40 30 20
		System.out.println(arr[idx]); // sw : 10
	}

	public static int max(int[] arr, int idx) {

		if (idx == arr.length) {
			return Integer.MIN_VALUE;
		}

		int maxTillNow = max(arr, idx + 1);
		int maxTotal = Math.max(maxTillNow, arr[idx]);

		return maxTotal;

	}

	public static int firstOccIndex(int[] arr, int idx, int item) {

		if (idx == arr.length) {
			return -1;
		}

		if (arr[idx] == item) { // item first occ index
			return idx;
		}

		return firstOccIndex(arr, idx + 1, item);

	}

	public static int lastOccIndex(int[] arr, int idx, int item) {

		if (idx == arr.length) {
			return -1;
		}

		int rr = lastOccIndex(arr, idx + 1, item);

		if (arr[idx] == item && rr == -1) { // item first occ index
			return idx;
		}

		return rr;

	}

	public static int[] allIndex(int[] arr, int idx, int item, int count) {

		if (idx == arr.length) {
			int[] br = new int[count];
			return br;
		}

		int[] rr;

		if (arr[idx] == item) {
			rr = allIndex(arr, idx + 1, item, count + 1);
			rr[count] = idx;
		} else {
			rr = allIndex(arr, idx + 1, item, count);
		}

		return rr ;

	}

}
