package L49_OOPS;

public class Overloading {

	public static void main(String[] args) {

		add(2, 3);
		add(5, 10);

		add(20, 30, 4, 5);

	}

	public static void add(int a, int b) {
		System.out.println("in add");

		System.out.println(a + b);
	}

	public static void add(int a, int b, int c) {
		System.out.println(a + b + c);
	}

	public static void add(String s1, String s2) {
		System.out.println(s1 + s2);
	}

	public static void add(int a, int b, int... arr) {

		for (int val : arr) {
			System.out.println(val);
		}

		System.out.println("in var args");
	}

}
