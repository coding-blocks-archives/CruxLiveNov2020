package L2_Patterns;

public class Pattern21 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;
		int nsp = 2 * n - 3;

		int row = 1;

		while (row <= n) {

			// stars
			int cst1 = 1;
			while (cst1 <= nst) {
				System.out.print("* ");
				cst1++;
			}

			// spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print("  ");
				csp++;
			}

			// stars
			int cst2 = 1;
			
			if(row == n)
				cst2 = 2 ;
			
			while (cst2 <= nst) {
				System.out.print("* ");
				cst2++;
			}

			// prep
			System.out.println();
			row++;
			nst++;
			nsp -= 2;

		}
	}
}
