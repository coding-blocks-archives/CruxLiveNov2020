package L3_NS;

public class Inverse {

	public static void main(String[] args) {
		
		int n = 23145 ;
		
		int ans  = 0 ;
		
		int pos = 1;
		
		while(n != 0) {
			
			int val = n % 10 ;
			
			ans = ans + pos * (int) Math.pow(10, val-1) ;
			
			n = n/10 ;
			pos++ ;
		}
		
		System.out.println(ans);

	}

}
