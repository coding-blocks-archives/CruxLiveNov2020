package L1_Basics;

import java.util.Scanner;

public class SumN {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in) ;
		
		int n = scn.nextInt() ;
		
		int sum = 0 ;
		
		int i = 1 ;
		
		while(i <= n) {
			
			sum = sum + i ;
			i++ ;
		}

		System.out.println(sum);
	}

}
