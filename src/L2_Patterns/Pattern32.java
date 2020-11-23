package L2_Patterns;

public class Pattern32 {

	public static void main(String[] args) {

		int n = 5;

		int val = 1;

		int nst = 1;

		int row = 1;

		while (row <= 2 * n - 1) {

			// work
			for (int cst = 1; cst <= nst; cst++) {

				if (cst % 2 == 0)
					System.out.print("* ");
				else
					System.out.print(val + " ");
			}

			// prep
			System.out.println();

			if (row <= n - 1) {
				nst += 2;
				val++ ;
			}
			else {
				nst -= 2;
				val-- ;
			}

			row++;

		}
	}
}
