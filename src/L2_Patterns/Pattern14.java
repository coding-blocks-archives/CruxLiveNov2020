package L2_Patterns;

public class Pattern14 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;
		int nsp = n - 1;

		int row = 1;

		while (row <= 2 * n - 1) {

			// work
			// spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			// stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

			// prep
			System.out.println();

			if (row <= n - 1) {
				nst++;
				nsp-- ;
			} else {
				nst--;
				nsp++ ;
			}

			row++;

		}

	}
}
