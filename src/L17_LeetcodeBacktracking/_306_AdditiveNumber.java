package L17_LeetcodeBacktracking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class _306_AdditiveNumber {

	static boolean ans ;
	
	public static void main(String[] args) {

		ans = false ;
		
		additive("12012122436", new ArrayList<BigInteger>());
		
		System.out.println(ans) ;

	}

	public static void additive(String ques, List<BigInteger> temp) {

		if (ques.length() == 0) {

			if (temp.size() >= 3) {
				// System.out.println(temp);
				ans = true ;
			}

			return;
		}

		for (int i = 1; i <= ques.length(); i++) {

			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			BigInteger num = new BigInteger(part) ;

			if (isAdditiveSeq(temp, num) && noLeadingZeros(part)) {
				temp.add(num);
				additive(roq, temp);
				temp.remove(temp.size() - 1);
			}
		}

	}

	// true : no leading zeros
	// false : leading zeros
	public static boolean noLeadingZeros(String str) {

		if (str.length() <= 1)
			return true;

		return str.charAt(0) != '0';

	}

	public static boolean isAdditiveSeq(List<BigInteger> temp, BigInteger num) {

		if (temp.size() <= 1)
			return true;

		BigInteger lastNum = temp.get(temp.size() - 1);
		BigInteger lastSecondNum = temp.get(temp.size() - 2);

		BigInteger sum = lastNum.add(lastSecondNum) ;
		
		return sum.equals(num) ;
	}

}
