package L2_Patterns;

public class PatternNumber {

	public static void main(String[] args) {

		int n = 5;

		int nsp = n - 1;
		int nst = 1;

		int val = 1 ;
		int row = 1;

		while (row <= n) {
			
			val = row ;
			
			// work
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print("\t");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val + "\t");
				
				if(cst <= nst/2)
					val++ ;
				else
					val-- ;
			}

			// prep
			System.out.println();
			row++;
			nsp--;
			nst += 2;

		}
	}

}
