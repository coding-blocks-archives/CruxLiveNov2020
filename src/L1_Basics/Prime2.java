package L1_Basics;

public class Prime2 {

	public static void main(String[] args) {
		
		int n = 12 ;
		
		int flag = 0 ;
		
		int div = 2 ;
		
		while(div <= n-1) {
			
			if(n % div == 0) {
				flag = 1;
				break ;
			}
			
			div++ ;
		}
		
		if(flag == 1) {
			System.out.println("Not Prime");
		}else {
			System.out.println("Prime");
		}

	}
	
	

}
