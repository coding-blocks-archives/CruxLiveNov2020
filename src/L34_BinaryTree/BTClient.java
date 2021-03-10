package L34_BinaryTree;

public class BTClient {

	public static void main(String[] args) {

		// 10 true 20 true 40 false false true 50 false false true 30 false true 60
		// false false

		// 10 true 20 true 40 true 60 true 80 false false false false true 50 false true
		// 70 false true 90 false false true 30 false false

//		int[] pre = { 20, 15, 16, 17, 50, 30, 55 };
//		int[] in = { 16, 15, 17, 20, 30, 50, 55 };

//		int[] pre = { 50, 30, 20, 40, 35, 45, 42, 47, 70, 60, 80 };
//		int[] in = { 20, 30, 35, 40, 42, 45, 47, 50, 60, 70, 80 };

		int[] pre = { 10, 20, 40, 50, 80, 110, 120, 90, 130, 30, 60, 70, 100 };
		int[] in = { 40, 20, 110, 80, 120, 50, 90, 130, 10, 60, 30, 70, 100 };
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

//		bt.isBST3();
		
		bt.verticalOrderTraversal();

	}

}
