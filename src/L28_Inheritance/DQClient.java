package L28_Inheritance;

public class DQClient {

	public static void main(String[] args) throws Exception {
		
		DynamicQueue dq = new DynamicQueue() ;
		dq.enqueue(10);
		dq.enqueue(20);
		dq.enqueue(30);
		dq.enqueue(40);
		dq.enqueue(50);
		System.out.println(dq.dequeue());
		System.out.println(dq.dequeue());
		dq.enqueue(60);
		dq.enqueue(70);
		dq.enqueue(80);
		dq.display();
	}

}
