package L2_Patterns;

public class Pattern15 {

	public static void main(String[] args) {

		int n = 5;

		int nst = n;
		int nsp = 0;

		int row = 1;

		while (row <= 2 * n - 1) {

			// work
			// spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print("  ");
				csp++;
			}

			// stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print("* ");
				cst++;
			}

			// prep
			System.out.println();

			if (row <= n - 1) {
				nst--;
				nsp+=2 ;
			} else {
				nst++;
				nsp-=2 ;
			}

			row++;

		}

	}
}
