package L17_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class CoinCombinationCase1UserRespect {

	public static void main(String[] args) {

		int[] denom = { 1, 2};
		
		List<List<Integer>> main = new ArrayList<>() ;
		List<Integer> temp = new ArrayList<Integer>() ;
		userRespect(denom, 0, 3, temp, main);
		
		System.out.println(main);

	}

	public static void userRespect(int[] denom, int vidx, int amount, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0)
			return;

		for (int i = vidx; i < denom.length; i++) {
			userRespect(denom, i , amount - denom[i], ans + denom[i]);
		}
	}
	
	public static void userRespect(int[] denom, int vidx, int amount, List<Integer> temp , List<List<Integer>> main ) {

		if (amount == 0) {
			main.add(new ArrayList<Integer>(temp)) ;
 			return;
		}

		if (amount < 0)
			return;

		for (int i = vidx; i < denom.length; i++) {
			
			temp.add(denom[i]) ;
			userRespect(denom, i , amount - denom[i], temp , main);
			temp.remove(temp.size()-1) ;
		}
	}

}
