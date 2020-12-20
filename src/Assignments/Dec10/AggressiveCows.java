package Assignments.Dec10;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int nos = scn.nextInt();
		int noc = scn.nextInt();

		int[] stalls = new int[nos];

		for (int i = 0; i < stalls.length; i++) {
			stalls[i] = scn.nextInt();
		}

		Arrays.sort(stalls);

		// logic ...
		int lo = 0;
		int hi = stalls[stalls.length - 1] - stalls[0];
		int finalAns = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isItPossible(stalls, noc, mid)) {
				finalAns = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}

		}
		
		System.out.println(finalAns);
		

	}

	private static boolean isItPossible(int[] stalls, int noc, int mid) {

		int cowsPlaced = 1 ;
		int pos = stalls[0] ;
		
		for(int i = 1 ; i < stalls.length ; i++) {
			
			if(stalls[i] - pos >= mid) {
				cowsPlaced++ ;
				pos = stalls[i] ;
				
				if(cowsPlaced == noc)
					return true ;
			}
		}
		
		
		return false;
	}

}

















