package L17_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class _401_BinaryWatch {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };
		
		List<String> main = new ArrayList<String>() ;
		
		watch(arr, 0, 4, 0, 0, main);
		
		System.out.println(main);

	}

	public static void watch(int[] arr, int vidx, int n, int hr, int min, List<String> main) {

		if(hr >= 12 || min >= 60)
			return ;
		
		// +ve bc
		if (n == 0) {
			
			String fmin = min + "" ;
			
			if(fmin.length() == 1)
				fmin = "0" + fmin ;
			
			main.add(hr + ":" + fmin);
			return ;
		}

		if (vidx == arr.length) {
			return;
		}

		// include : on
		if (vidx < 4) { // hr
			watch(arr, vidx + 1, n - 1, hr + arr[vidx], min,main);
		} else { // min
			watch(arr, vidx + 1, n - 1, hr, min + arr[vidx], main);
		}

		// exclude : off
		watch(arr, vidx + 1, n , hr , min, main);

	}

}
