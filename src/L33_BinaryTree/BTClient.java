package L33_BinaryTree;

public class BTClient {

	public static void main(String[] args) {
		
		// 10 true 20 true 40 false false true 50 false false true 30 false true 60 false false
		BinaryTree bt = new BinaryTree() ;
		bt.display();
		
		System.out.println(bt.size());
		System.out.println(bt.max());
		System.out.println(bt.find(50));
		System.out.println(bt.ht());
		

	}

}
