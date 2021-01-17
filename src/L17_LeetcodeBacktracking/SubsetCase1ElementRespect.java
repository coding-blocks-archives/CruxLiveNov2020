package L17_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetCase1ElementRespect {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 2 };

		List<List<Integer>> main = new ArrayList<>();
		List<Integer> temp = new ArrayList<Integer>();
		elementRespect(arr, 0, temp, main);

		System.out.println(main);

	}

	public static void elementRespect(int[] arr, int vidx, String ans) {

		if (vidx == arr.length) {
			System.out.println(ans);
			return;
		}

		elementRespect(arr, vidx + 1, ans); // exclude
		elementRespect(arr, vidx + 1, ans + arr[vidx]); // include

	}

	public static void elementRespect(int[] arr, int vidx, List<Integer> temp, List<List<Integer>> main) {

		if (vidx == arr.length) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		elementRespect(arr, vidx + 1, temp, main); // exclude

		temp.add(arr[vidx]);
		elementRespect(arr, vidx + 1, temp, main); // include
		temp.remove(temp.size() - 1);

	}
}
