package L26_OOPS;

public class Student {

	// data members
	String name = "_";
	int age = 50;

	// constructor
	public Student() {
		this.name = "XYZ";
		this.age = 25;
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void introduceYourself() {
		System.out.println(name + " is " + age + " years old.");
	}

	public void sayHi(String name) {
		System.out.println(this.name + " says hii to " + name);
	}

	public void fun(Student s) {
		introduceYourself();

	}
}
