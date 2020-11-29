package L4_DT;

import java.util.Scanner;

public class Temperature {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in) ;
		
		int minF = scn.nextInt() ;
		int maxF = scn.nextInt() ;
		
		int step = scn.nextInt() ;
		
		for(int f = minF ; f <= maxF ; f = f + step) {
			
			int c = (int) ((5.0/9)*(f-32)) ;
			System.out.println(f + "\t" + c);
		}
	}
}
