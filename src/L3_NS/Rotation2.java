package L3_NS;

import java.util.Scanner;

public class Rotation2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int rot = scn.nextInt();

		int temp = n;
		// count the no. of digits
		int nod = 0;
		while (temp != 0) {
			nod++;
			temp = temp / 10;
		}
		
		rot = rot % nod ;
		if(rot < 0)
			rot = rot + nod ;

		int divisor = (int) Math.pow(10, rot) ; // 10^4
		int rem = n % divisor ; // 3456
		int rest = n/ divisor ; // 12
		
		int mult = (int)Math.pow(10, nod-rot) ; // 10^2
		int ans = rem * mult + rest ; // 345600 + 12 = 345612
		
		System.out.println(ans);
		

	}

}








