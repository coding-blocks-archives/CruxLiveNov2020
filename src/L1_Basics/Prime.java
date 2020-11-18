package L1_Basics;

public class Prime {

	public static void main(String[] args) {

		int n = 13;

		int factors = 0;

		int div = 1;

		while (div <= n) {

			int rem = n % div;

			if (rem == 0) {
				factors++;
			}

			div = div + 1;
		}

		if (factors == 2)
			System.out.println("Prime");
		else
			System.out.println("Not Prime");
	}
}
