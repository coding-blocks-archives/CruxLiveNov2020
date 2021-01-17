package L17_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_PermutationsII {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2 };

		Arrays.sort(arr);

		boolean[] available = new boolean[arr.length];
		Arrays.fill(available, true);

		List<List<Integer>> main = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();

		permutations(arr, available, temp, main);

		System.out.println(main);

	}

	public static void permutations(int[] arr, boolean[] available, List<Integer> temp, List<List<Integer>> main) {

		if (temp.size() == arr.length) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 0; i < available.length; i++) {

			if (available[i] == false)
				continue;

			if (i > 0 && arr[i] == arr[i - 1] && available[i] && available[i - 1]) {
				continue;
			}

			available[i] = false;

			temp.add(arr[i]);
			permutations(arr, available, temp, main);
			temp.remove(temp.size() - 1);

			available[i] = true;

		}

	}

}
