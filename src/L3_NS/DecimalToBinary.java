package L3_NS;

public class DecimalToBinary {

	public static void main(String[] args) {
		
		int decimal = 100 ;
		
		int ans = 0 ;
		int mult = 1 ; // 10^0 = 1
		
		while(decimal != 0) {
			
			int rem = decimal % 2 ;
			
			ans = rem * mult + ans ;
			
			mult = mult * 10 ;
			decimal = decimal / 2;
			
		}
		
		System.out.println(ans);

	}

}
