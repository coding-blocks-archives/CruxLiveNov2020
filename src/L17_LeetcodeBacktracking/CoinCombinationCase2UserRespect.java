package L17_LeetcodeBacktracking;

public class CoinCombinationCase2UserRespect {

	public static void main(String[] args) {

		int[] denom = { 2, 2, 3, 4 };
		userRespect(denom, 0, 6, "");

	}

	public static void userRespect(int[] denom, int vidx, int amount, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0)
			return;

		for (int i = vidx; i < denom.length; i++) {
			userRespect(denom, i + 1, amount - denom[i], ans + denom[i]);
		}
	}

}
