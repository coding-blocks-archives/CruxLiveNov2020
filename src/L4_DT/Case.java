package L4_DT;

import java.util.Scanner;

public class Case {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in) ;
		
		char ch = scn.next().charAt(0) ;
		
		// logic ....
		if(ch >= 'A' && ch <= 'Z') {
			System.out.println("Uppercase");
		}else if(ch >= 'a' && ch <= 'z') {
			System.out.println("Lowercase");
		}else {
			System.out.println("Invalid");
		}
		
	}

}
