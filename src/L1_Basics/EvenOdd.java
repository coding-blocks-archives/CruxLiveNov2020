package L1_Basics;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in) ;
		
		int n = scn.nextInt() ;
		
		if(n % 2 == 0) {
			System.out.println("Even");
		}else {
			System.out.println("Odd");
		}
		
		
	}

}
