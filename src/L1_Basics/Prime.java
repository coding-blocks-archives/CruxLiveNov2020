package L1_Basics;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in) ;
		
		int n = scn.nextInt() ;

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
