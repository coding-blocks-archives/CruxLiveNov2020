package L17_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class _89_GrayCode {

	public static void main(String[] args) {
		
		System.out.println(grayCode(3));

	}

	public static List<Integer> grayCode(int n) {

		if(n == 1) {
			List<Integer> br = new ArrayList<Integer>() ;
			br.add(0) ;
			br.add(1) ;
			return br ;
		}
		
		List<Integer> rr = grayCode(n - 1);

		List<Integer> mr = new ArrayList<Integer>(rr);

		for (int i = rr.size() - 1; i >= 0; i--) {

			int factor = (int) Math.pow(2, n - 1);
			mr.add(factor + rr.get(i));

		}
		
		return mr ;

	}

}
