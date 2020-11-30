package L6_Arrays;

public class ArrayDemo {

	public static void main(String[] args) {

		int[] arr = new int[5];

		System.out.println(arr.length);
		System.out.println(arr);

		// get
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);

		int a = arr[0];

		// set
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;

		// get
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		// System.out.println(arr[5]);

		// for loop
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		// enhanced for loop
		System.out.println("--EFL--");
		for (int val : arr) {
			System.out.println(val);
			val = 100;
			System.out.println(val);
		}

		for (int val : arr) {
			System.out.println(val);
		}

		char[] carr = null;
		carr = new char[3];

		carr[0] = 'a';
		carr[1] = 'q';
		carr[2] = 'y';

		for (char temp : carr) {
			System.out.println(temp);
		}

		// EFL : 2 limitation : forward only , read only

		int[] other = arr;
		other[2] = 100;

		System.out.println(arr[2]);

		int[] temp = new int[4];
		arr = temp;
		System.out.println(arr[2]);

		other = arr;

		// demos

		int[] one = { 10, 20, 30, 40, 50 }; // hard core
		int[] two = { 100, 200, 300 };

		// case 1
		System.out.println(one[0] + " " + two[0]);
		swap(one[0], two[0]);
		System.out.println(one[0] + " " + two[0]);

		// case 2
		System.out.println(one[0] + " " + two[0]);
		// swap(one, two, 0);
		System.out.println(one[0] + " " + two[0]);

		// case 3
		System.out.println(one[0] + " " + two[0]);
		swap(one, two);
		System.out.println(one[0] + " " + two[0]);

	}

	public static void swap(int[] a, int[] b) {

		int[] temp = a;
		a = b;
		b = temp;

	}

	public static void swap(int[] a, int[] b, int i) {

		int temp = a[i];
		a[i] = b[i];
		b[i] = temp;
	}

	public static void swap(int a, int b) {

		int temp = a;
		a = b;
		b = temp;

	}

}
