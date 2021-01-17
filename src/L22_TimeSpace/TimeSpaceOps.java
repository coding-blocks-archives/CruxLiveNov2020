package L22_TimeSpace;

import java.util.Arrays;

public class TimeSpaceOps {

	public static void main(String[] args) {

		// System.out.println(polynomial3(3, 7));
		//System.out.println(power(2, 15));
		
		SOE(100) ;
	}

	public static int polynomial(int x, int n) {

		int sum = 0;

		int mult = 1;
		for (int i = 1; i <= n; i++) { // x^ n
			mult = mult * x;
		}

		for (int coeff = 1; coeff <= n; coeff++) {
			sum += coeff * mult;
			mult = mult / x;
		}

		return sum;

	}

	public static int polynomial2(int x, int n) {

		int sum = 0;

		int mult = (int) Math.pow(x, n);

		for (int coeff = 1; coeff <= n; coeff++) {
			sum += coeff * mult;
			mult = mult / x;
		}

		return sum;

	}

	public static int polynomial3(int x, int n) {

		int sum = 0;
		int mult = x;

		for (int coeff = n; coeff >= 1; coeff--) {

			sum += coeff * mult;
			mult = mult * x;
		}

		return sum;

	}

	public static int power(int x, int n) { // x ^ n

		if (n == 0) {
			return 1;
		}

		int sp = power(x, n / 2);
		if (n % 2 == 0) {
			return sp * sp;
		} else {
			return sp * sp * x;
		}

	}

	public static void SOE(int n) {

		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table] == false)
				continue;

			for (int mult = 2; table * mult <= n; mult++) {

				primes[table * mult] = false;

			}
		}
		
		for(int i = 0 ; i < primes.length ; i++) {
			
			if(primes[i])
				System.out.println(i);
		}

	}
}
