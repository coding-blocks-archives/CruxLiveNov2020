package L35_BST;

public class BSTClient {

	public static void main(String[] args) {
		
		int[] in = {10,20,30,40,50,60,70} ;
		
		BST bst = new BST(in) ;
		bst.display();
		
		System.out.println(bst.max());
		System.out.println(bst.find(65));
		
//		bst.replaceWithSumOfLarger();
//		bst.display();
		
		bst.printInRange(25, 65);

	}

}
