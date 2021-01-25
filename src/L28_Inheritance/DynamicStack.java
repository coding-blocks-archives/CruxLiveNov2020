package L28_Inheritance;

import L27_ExceptionStackQueue.Stack;

public class DynamicStack extends Stack{

	public void push(int item) throws Exception {
		
		if(isFull()) {
			
			// create  a new array of double size
			int[] na = new int[data.length * 2] ;
			
			// copy previous elements
			for(int i = 0 ; i < data.length ; i++) {
				na[i] = data[i] ;
			}
			
			// ref change
			data = na ;
			
		}
		
		super.push(item);
		
	}
}
