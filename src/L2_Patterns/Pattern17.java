package L2_Patterns;

public class Pattern17 {

	public static void main(String[] args) {

		int n = 13;

		int nst = n / 2;
		int nsp = 1;

		int row = 1;

		while (row <= n) {

			// work

			// stars
			int cst1 = 1;
			while (cst1 <= nst) {
				System.out.print("*");
				cst1++;
			}

			// spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			// stars
			int cst2 = 1;
			while (cst2 <= nst) {
				System.out.print("*");
				cst2++;
			}

			// prep
			System.out.println();

			if (row <= n / 2) {
				nst--;
				nsp += 2;
			} else {
				nst++;
				nsp -= 2;
			}
			
			row++ ;

		}

	}
}
