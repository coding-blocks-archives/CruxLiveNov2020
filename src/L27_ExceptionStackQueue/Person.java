package L27_ExceptionStackQueue;

public class Person {

	private String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void fun(int age){

		System.out.println("hello fun");

		setAge(age);

		System.out.println("bye fun");

		System.out.println("byeeeeeeeeeeeee");
	}

	public void setAge(int age) {

		try {
			System.out.println("hello setAge");

			if (age < 0)
				throw new Exception("Age can't be -ve");

			this.age = age;

			System.out.println("bye setAge");
		} catch (Exception e) {
			System.out.println("in setAge catch");
		}

		System.out.println("byeeee");
	}

}
