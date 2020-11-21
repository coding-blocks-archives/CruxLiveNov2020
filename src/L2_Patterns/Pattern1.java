package L2_Patterns;

public class Pattern1 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;

		// loop for rows
		while (row <= n) {

			// work
			int col = 1;
			while (col <= n) {
				System.out.print("*");
				col++;
			}
		

			// prep
			System.out.println();
			row++;

		}

	}

}
