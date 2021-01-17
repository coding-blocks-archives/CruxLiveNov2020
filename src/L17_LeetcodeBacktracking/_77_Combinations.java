package L17_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {

	public static void main(String[] args) {

		System.out.println(combine(4, 2));

	}

	public static List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> main = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();

		elementRespect(1, n, k, temp, main);

		return main;

	}

	public static void userRespect(int sp, int n, int k, List<Integer> temp, List<List<Integer>> main) {

		if (k == 0) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = sp; i <= n; i++) {
			temp.add(i);
			userRespect(i + 1, n, k - 1, temp, main);
			temp.remove(temp.size() - 1);
		}

	}

	public static void elementRespect(int sp, int n, int k, List<Integer> temp, List<List<Integer>> main) {

		if(k == 0) {
			main.add(new ArrayList<Integer>(temp)) ;
			return ;
		}
		
		if(sp > n)
			return ;
		
		// exclude
		elementRespect(sp + 1, n, k, temp, main);

		// include
		temp.add(sp);
		elementRespect(sp + 1, n, k - 1, temp, main);
		temp.remove(temp.size() - 1);

	}

}
