package L2_Patterns;

public class Pattern3 {

	public static void main(String[] args) {
		
		int n = 5 ;
		
		int nst = n ; 
		int row = 1;
		
		// n no. of rows
		while(row <= n) {
			
			// work : print nst stars
			int cst = 1;
			while(cst <= nst) {
				System.out.print("*");
				cst++ ;
			}
			
			// prep
			System.out.println();
			row++ ;
			nst-- ;
			
		}

	}

}
