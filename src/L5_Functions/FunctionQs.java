package L5_Functions;

public class FunctionQs {

	public static void main(String[] args) {

		printAllArmstrong(1, 1000);

	}

	public static void printAllArmstrong(int ll, int ul) {

		for (int i = ll; i <= ul; i++) {

			boolean res = isArmstrong(i);

			if (res)
				System.out.println(i);

		}

	}

	public static boolean isArmstrong(int n) {

		int temp = n ;
		int sum = 0 ;
		
		int nod = numberOfDigits(n) ;
		
		while(n != 0) {
			
			int rem = n% 10 ;
			sum += Math.pow(rem, nod);
			n = n/10 ;
			
		}
		
		if(sum == temp)
			return true ;
		else
			return false ;
		
	}

	public static int numberOfDigits(int n) {

		int nod = 0;

		while (n > 0) {
			nod++;
			n = n / 10;
		}

		return nod;

	}

}
