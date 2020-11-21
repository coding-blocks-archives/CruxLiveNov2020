package L2_Patterns;

public class Pattern5 {

	public static void main(String[] args) {

		int n = 7;

		int nsp = 0;
		int nst = n;
		int row = 1;

		while (row <= n) {

			// work

			// spaces : nsp spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print("  ");
				csp++;
			}

			// stars : nst stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print("* ");
				cst++;
			}

			// prep
			System.out.println();
			row++;
			nsp++;
			nst--;

		}

	}

}
