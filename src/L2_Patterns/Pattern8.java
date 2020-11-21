package L2_Patterns;

public class Pattern8 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;

		// loop for rows
		while (row <= n) {

			// work
			int col = 1;
			while (col <= n) {

				if (row == col || row + col == n + 1)
					System.out.print("*");
				else
					System.out.print(" ");

				col++;
			}

			// prep
			System.out.println();
			row++;

		}

	}

}
