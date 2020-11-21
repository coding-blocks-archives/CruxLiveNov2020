package L2_Patterns;

public class Pattern9 {

	public static void main(String[] args) {

		int n = 5;

		int nsp = n-1;
		int nst = 1;
		int row = 1;

		while (row <= n) {

			// work

			// spaces : nsp spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
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
			nsp--;
			nst+=2;

		}

	}

}
