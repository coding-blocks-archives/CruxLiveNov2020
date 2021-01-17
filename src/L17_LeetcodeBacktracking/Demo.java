package L17_LeetcodeBacktracking;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {

//		ArrayList<Integer> list = new ArrayList<Integer>() ;
//		list.add(10) ;
//		list.add(20) ;
//		list.add(30) ;
//		list.add(40) ;
//		System.out.println(list);
//		
//		ArrayList<Integer> list1= new ArrayList<Integer>() ;
//		list1.add(50) ;
//		list1.add(60) ;
//		list1.add(70) ;
//		System.out.println(list1);
//		
//		ArrayList<ArrayList<Integer>> big = new ArrayList<ArrayList<Integer>>() ;
//		big.add(list) ;
//		big.add(list1) ;
//		System.out.println(big);
//		
//		System.out.println(big.get(1).get(0));

//		ArrayList<ArrayList<Integer>> big = new ArrayList<ArrayList<Integer>>() ;
//		
//		ArrayList<Integer> temp = new ArrayList<Integer>() ;
//		temp.add(10) ;
//		temp.add(20) ;
//		temp.add(30) ;
//		
//		big.add(temp) ;
//		System.out.println(big);
//		
//		temp.add(40) ;
//		temp.add(50) ;
//		
//		big.add(temp) ;
//		System.out.println(big);
//		
//		temp.add(60) ;
//		temp.add(70) ;
//		
//		big.add(temp) ;
//		
//		System.out.println(big);
//		

//		ArrayList<Integer> temp = new ArrayList<Integer>() ;
//		temp.add(10) ;
//		temp.add(20) ;
//		temp.add(30) ;
//		temp.add(40) ;
//		
//		// way 1 
////		ArrayList<Integer> l1 = new ArrayList<Integer>() ;
////		for(int val : temp)
////			l1.add(val) ;
//		
//		// way 2 
//		ArrayList<Integer> l1 = new ArrayList<Integer>(temp) ;
//		
//		ArrayList<ArrayList<Integer>> big = new ArrayList<ArrayList<Integer>>() ;
//		big.add(temp) ;
//		big.add(l1) ;
//		System.out.println(big);
//		
//		temp.add(50) ;
//		System.out.println(big);

		ArrayList<ArrayList<Integer>> big = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(10);
		temp.add(20);
		temp.add(30);

		big.add(new ArrayList<Integer>(temp));
		System.out.println(big);

		temp.add(40);
		temp.add(50);

		big.add(new ArrayList<Integer>(temp));
		System.out.println(big);

		temp.add(60);
		temp.add(70);

		big.add(new ArrayList<Integer>(temp));
		System.out.println(big);

	}

}
