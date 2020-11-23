package L3_NS;

import java.util.Scanner;

public class Rotation {

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

		// logic for just 1 rotation
		for (int i = 1; i <= rot; i++) {
			
			int ld = n % 10;
			int rest = n / 10;
			int mult = (int) Math.pow(10, nod - 1);
			int newno = ld * mult + rest;
			n = newno ;
		}

		System.out.println(n);
		

	}

}
