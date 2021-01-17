package L17_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetCase2UserRespect {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2 };

		Arrays.sort(arr);
		List<List<Integer>> main = new ArrayList<>();
		List<Integer> temp = new ArrayList<Integer>();
		userRespect(arr, 0, temp, main);

		System.out.println(main);

	}

	public static void userRespect(int[] arr, int vidx, String ans) {

		System.out.println(ans);

		for (int i = vidx; i < arr.length; i++) {

			if (i > vidx && arr[i] == arr[i - 1])
				continue;

			userRespect(arr, i + 1, ans + arr[i]);
		}
	}

	public static void userRespect(int[] arr, int vidx, List<Integer> temp, List<List<Integer>> main) {

		main.add(new ArrayList<Integer>(temp));

		for (int i = vidx; i < arr.length; i++) {

			if (i > vidx && arr[i] == arr[i - 1])
				continue;

			temp.add(arr[i]);
			userRespect(arr, i + 1, temp, main);
			temp.remove(temp.size() - 1);

		}
	}
}
