package L17_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class CoinCombinationCase1CoinRespect {

	public static void main(String[] args) {

		int[] denom = { 1, 2, 3 };
		// coinRespect(denom, 0, 5, "");
		
		List<List<Integer>> main = new ArrayList<>() ;
		List<Integer> temp = new ArrayList<Integer>() ;
		coinRespect(denom, 0, 3, temp, main);
		
		System.out.println(main);
	}

	public static void coinRespect(int[] denom, int vidx, int amount, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0 || vidx == denom.length)
			return;

		// include
		coinRespect(denom, vidx, amount - denom[vidx], ans + denom[vidx]);
		// exclude
		coinRespect(denom, vidx + 1, amount, ans);
	}

	
	public static void coinRespect(int[] denom, int vidx, int amount, List<Integer> temp, List<List<Integer>> main) {

		if (amount == 0) {
			main.add(new ArrayList<Integer>(temp)) ;
			return;
		}

		if (amount < 0 || vidx == denom.length)
			return;

		// include
		temp.add(denom[vidx]) ;
		coinRespect(denom, vidx, amount - denom[vidx], temp, main);
		temp.remove(temp.size()-1) ;
		// exclude
		coinRespect(denom, vidx + 1, amount, temp, main);
	}

}
