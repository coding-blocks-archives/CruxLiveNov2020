package L43_SegmentTree;

public class STClient {

	public static void main(String[] args) {
		
		int[] arr = {5,2,10,3,-6,-4,12,13} ;
		
		SegmentTree st = new SegmentTree(arr, new SegmentTreeMax()) ;
		st.display();
		
		System.out.println(st.rangeQuery(2, 5));
		st.update(3, 10);
		
		st.display();

	}

}
