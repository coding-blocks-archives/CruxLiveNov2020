package L51_DP;

public class UglyNumber {

	public static void main(String[] args) {
		
		System.out.println(uglyNumberRec(10));
		
	}

	public static int uglyNumber(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 1;

		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		for (int i = 1; i <= n; i++) {

			int candidate2 = 2 * strg[i2];
			int candidate3 = 3 * strg[i3];
			int candidate5 = 5 * strg[i5];

			int minimum = Math.min(candidate2, Math.min(candidate3, candidate5));

			strg[i] = minimum;

			if (candidate2 == minimum)
				i2++;

			if (candidate3 == minimum)
				i3++;

			if (candidate5 == minimum)
				i5++;

		}
		
		return strg[n-1] ;

	}
	
	public static int uglyNumberRec(int n) {

		if(n == 0)
			return 1 ;
		
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		int minimum = 1;
		
		for (int i = 1; i <= n; i++) {

			int candidate2 = 2 * uglyNumberRec(i2);
			int candidate3 = 3 * uglyNumberRec(i3);
			int candidate5 = 5 * uglyNumberRec(i5);

			minimum = Math.min(candidate2, Math.min(candidate3, candidate5));

			if (candidate2 == minimum)
				i2++;

			if (candidate3 == minimum)
				i3++;

			if (candidate5 == minimum)
				i5++;

		}
		
		return minimum ;

	}

}
