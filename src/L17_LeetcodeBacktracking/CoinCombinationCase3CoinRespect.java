package L17_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinCombinationCase3CoinRespect {

	public static void main(String[] args) {

		int[] denom = { 1,2,2,3,4,5 };
		
		Arrays.sort(denom) ;
		
		List<List<Integer>> main = new ArrayList<>() ;
		List<Integer> temp = new ArrayList<Integer>() ;
		coinRespect(denom, 0, 7, temp, main, true);
		
		System.out.println(main);
		
		
	}

	// call true include , false exclude
	public static void coinRespect(int[] denom, int vidx, int amount, String ans, boolean call) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0 || vidx == denom.length)
			return;

		if (call == false && denom[vidx] == denom[vidx - 1]) {
			coinRespect(denom, vidx + 1, amount, ans, false); // exclude
		} else {
			coinRespect(denom, vidx + 1, amount - denom[vidx], ans + denom[vidx], true); // include
			coinRespect(denom, vidx + 1, amount, ans, false); // exclude
		}

	}

	public static void coinRespect(int[] denom, int vidx, int amount, List<Integer> temp, List<List<Integer>> main,  boolean call) {

		if (amount == 0) {
			main.add(new ArrayList<Integer>(temp)) ;
			return;
		}

		if (amount < 0 || vidx == denom.length)
			return;

		if (call == false && denom[vidx] == denom[vidx - 1]) {
			coinRespect(denom, vidx + 1, amount, temp, main, false); // exclude
		} else {
			temp.add(denom[vidx]) ;
			coinRespect(denom, vidx + 1, amount - denom[vidx], temp, main, true); // include
			temp.remove(temp.size()-1) ;
			
			coinRespect(denom, vidx + 1, amount, temp, main, false); // exclude
		}

	}
}
