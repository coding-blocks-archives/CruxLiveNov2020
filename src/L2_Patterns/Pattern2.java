package L2_Patterns;

public class Pattern2 {

	public static void main(String[] args) {
		
		int n = 5 ;
		
		int nst = 1 ; 
		int row = 1;
		
		// n no. of rows
		while(row <= n) {
			
			// work : print nst stars
			int col = 1;
			while(col <= nst) {
				System.out.print("*");
				col++ ;
			}
			
			// prep
			System.out.println();
			row++ ;
			nst++ ;
			
		}

	}

}
