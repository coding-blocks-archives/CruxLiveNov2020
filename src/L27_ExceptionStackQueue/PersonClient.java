package L27_ExceptionStackQueue;

public class PersonClient {

	public static void main(String[] args) {

		System.out.println("hello main");

		Person p = new Person();
		p.fun(-10);

		System.out.println(p.getAge());

		System.out.println("bye main");

	}

}
