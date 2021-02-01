package L29_StackQueueQs;

public class MinStackClient {

	public static void main(String[] args) throws Exception {
		
		MinStack ms = new MinStack() ;
		
		ms.push(10) ;
		ms.push(50) ;
		ms.push(40) ;
		ms.push(6) ;
		ms.push(45) ;
		ms.push(2) ;
		
		System.out.println(ms.pop()) ;
		System.out.println(ms.min());
		System.out.println(ms.pop()) ;
		System.out.println(ms.min());
		
	}

}
