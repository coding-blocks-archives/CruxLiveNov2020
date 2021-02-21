package L33_BinaryTree;

public class BTClient {

	public static void main(String[] args) {

		// 10 true 20 true 40 false false true 50 false false true 30 false true 60
		// false false

		// 10 true 20 true 40 true 60 true 80 false false false false true 50 false true
		// 70 false true 90 false false true 30 false false

		int[] pre = { 10, 20, 40, 50, 30, 70 };
		int[] in = { 40, 20, 50, 10, 30, 70 };

		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();

//		System.out.println(bt.size());
//		System.out.println(bt.max());
//		System.out.println(bt.find(50));
//		System.out.println(bt.ht());
//
//		System.out.println(bt.diameter3());
//
//		System.out.println(bt.isBalanced3());

//		BinaryTree bt1 = new BinaryTree() ;
//		bt1.display();
//		
//		System.out.println(bt.flipEquivalent(bt1));

//		bt.preorderI();
//		System.out.println(bt.maxSubtreeSum3());

	}

}
