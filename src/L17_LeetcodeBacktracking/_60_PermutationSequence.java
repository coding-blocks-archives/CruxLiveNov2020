package L17_LeetcodeBacktracking;

import java.util.ArrayList;

public class _60_PermutationSequence {

	public static void main(String[] args) {

		int n = 4;
		int k = 18;

		int[] factorial = new int[n];
		factorial[0] = 1;
		for (int i = 1; i <= n - 1; i++) {
			factorial[i] = factorial[i - 1] * i;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= n; i++)
			list.add(i);

		System.out.println(permutation(n, k, factorial, list, ""));

	}

	public static String permutation(int n, int k, int[] factorial, ArrayList<Integer> list, String ans) {

		if (n == 0) {
			return ans ;
		}

		int group = k / factorial[n - 1]; // complete groups of size factorial[n-1]
		if (k % factorial[n - 1] != 0)
			group++;

		int newk = k % factorial[n - 1];
		
		if(newk == 0)
			newk = factorial[n-1] ;
		
		//int newk = k - (group-1) * factorial[n-1] ;

		int num = list.remove(group);

		return permutation(n - 1, newk, factorial, list, ans + num);

	}

}





