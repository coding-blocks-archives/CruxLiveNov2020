package L2_Patterns;

public class Pattern7 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;

		// loop for rows
		while (row <= n) {

			// work
			int col = 1;
			while (col <= n) {

				if (row == 1 || row == n || col == 1 || col == n)
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
