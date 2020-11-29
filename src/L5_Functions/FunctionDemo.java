package L5_Functions;

public class FunctionDemo {

	static int val = 100;

	// start your program
	public static void main(String[] args) {

		System.out.println("------------ Case 1 ------------");

		addition(); // calling the function
		subtraction();

		System.out.println("------------ Case 2 ------------");
		additionParams(10, 20);

		System.out.println("------------ Case 3 ------------");
		int res = additionReturn(10, 20);
		System.out.println(res);

		System.out.println("------------ Case 4 ------------");
		System.out.println(val); // 200
		int val = 200; // new local variable
		System.out.println(val); // local win
		System.out.println(FunctionDemo.val); // global

		fun(val);

		System.out.println(val);
		System.out.println(FunctionDemo.val);

		System.out.println("------------ Case 5 ------------");
		int one = 20;
		int another = 30;

		System.out.println(one + " " + another);
		Swap(one, another);
		System.out.println(one + " " + another);

		System.out.println("bye");

	}

	public static void Swap(int one, int two) {

		System.out.println(one + ", " + two);

		int temp = one;
		one = two;
		two = temp;

		System.out.println(one + ", " + two);
	}

	public static void fun(int a) {

		int val = 20;
		System.out.println(val);
		System.out.println(FunctionDemo.val);

		val = val + 60;

		FunctionDemo.val = val + 10;

		System.out.println(val);
		System.out.println(FunctionDemo.val);
	}

	public static int additionReturn(int a, int b) {

		int sum = a + b;

		return sum;

	}

	public static void additionParams(int a, int b) {

		int sum = a + b;
		System.out.println(sum);

	}

	// function definition
	public static void addition() {

		int a = 10;
		int b = 20;

		int sum = a + b;

		subtraction();

		System.out.println(sum);

	}

	public static void subtraction() {

		int a = 100;
		int b = 40;

		int diff = a - b;

		System.out.println(diff);
	}

}
