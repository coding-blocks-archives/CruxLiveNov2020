package L28_Inheritance;

import L27_ExceptionStackQueue.Queue;

public class DynamicQueue extends Queue{

	@Override
	public void enqueue(int item) throws Exception {
		
		if(isFull()) {
			
			// create a new array
			int[] na = new int[2 * data.length] ;
			
			// elements copy
			for (int i = 0; i < size; i++) {

				int idx = (i + front) % data.length;
				na[i] = data[idx] ;
				
			}
			
			// ref change and front = 0 
			data = na ;
			front = 0 ;
			
		}
		
		super.enqueue(item);
	}
}
