package L37_BST;

public class BSTClient {

	public static void main(String[] args) {
		
//		int[] in = {10,20,30,40,50,60,70} ;
		
		BST bst = new BST() ;
		bst.display();
		
//		System.out.println(bst.max());
//		System.out.println(bst.find(65));
		
//		bst.replaceWithSumOfLarger();
//		bst.display();
		
//		bst.printInRange(25, 65);
		
//		bst.replaceWithSumOfLarger2();
//		bst.display();
		
		bst.add3(50);
		bst.add3(30);
		bst.add3(60);
		bst.add3(20);
		bst.add3(40);
		bst.add3(55);
		bst.add3(65);
		bst.add3(10);
		bst.add3(25);
		bst.add3(35);
		bst.add3(45);
		bst.add3(7);
		bst.add3(15);
		bst.add3(32);
		
		bst.display();
		
		bst.remove(30) ;
		bst.display();
		bst.remove(20);
		bst.display();

	}

}
