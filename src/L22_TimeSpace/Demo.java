package L22_TimeSpace;

public class Demo {

	public static void main(String[] args) {

		int n = 10000;

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n/3; j++) {
				System.out.println("hello");
			}
		}

		for (int i = 1; i <= n / 2; i++) {
			System.out.println("bye");
		}

	}
}
