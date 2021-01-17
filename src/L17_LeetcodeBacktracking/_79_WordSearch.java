package L17_LeetcodeBacktracking;

public class _79_WordSearch {

	static boolean ans;

	public static void main(String[] args) {

		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "SEE";

		ans = false;

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int r = 0; r < board.length; r++) {

			for (int c = 0; c < board[0].length; c++) {

				if (board[r][c] == word.charAt(0)) {
					boolean res = wordSearchR(board, r, c, word, 0, visited);
					System.out.println(res);
				}
			}
		}

//		System.out.println(ans);

	}

	public static void wordSearch(char[][] board, int row, int col, String word, int vidx, boolean[][] visited) {

		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(vidx)
				|| visited[row][col]) {
			return;
		}

		if (vidx == word.length() - 1) {
			ans = true;
			return;
		}

		visited[row][col] = true;

		wordSearch(board, row - 1, col, word, vidx + 1, visited); // top

		if (ans)
			return;

		wordSearch(board, row, col + 1, word, vidx + 1, visited); // right

		if (ans)
			return;

		wordSearch(board, row, col - 1, word, vidx + 1, visited); // left

		if (ans)
			return;

		wordSearch(board, row + 1, col, word, vidx + 1, visited); // bottom

		visited[row][col] = false;

	}

	public static boolean wordSearchR(char[][] board, int row, int col, String word, int vidx, boolean[][] visited) {

		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(vidx)
				|| visited[row][col]) {
			return false;
		}

		if (vidx == word.length() - 1) {
			return true;
		}

		visited[row][col] = true;

		boolean res = wordSearchR(board, row - 1, col, word, vidx + 1, visited)
				|| wordSearchR(board, row, col + 1, word, vidx + 1, visited)
				|| wordSearchR(board, row, col - 1, word, vidx + 1, visited)
				|| wordSearchR(board, row + 1, col, word, vidx + 1, visited);

		visited[row][col] = false;

		return res;

	}

}
