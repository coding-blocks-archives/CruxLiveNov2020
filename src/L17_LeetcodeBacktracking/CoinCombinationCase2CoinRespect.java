package L17_LeetcodeBacktracking;

public class CoinCombinationCase2CoinRespect {

	public static void main(String[] args) {

		int[] denom = { 2, 2, 3 };
		coinRespect(denom, 0, 5, "");

	}

	public static void coinRespect(int[] denom, int vidx, int amount, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0 || vidx == denom.length)
			return;

		// include
		coinRespect(denom, vidx + 1, amount - denom[vidx], ans + denom[vidx]);
		// exclude
		coinRespect(denom, vidx + 1, amount, ans);
	}

}
