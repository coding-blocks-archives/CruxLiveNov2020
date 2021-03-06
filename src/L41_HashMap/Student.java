package L41_HashMap;

public class Student {

	String name;
	int rollNo;
	static int totalStudents;

	public Student(String name) {
		totalStudents++;

		this.rollNo = totalStudents;
		this.name = name;
	}

	// can you access non static variables in non static fxn ? YES
	// can you call non static fxn in non static fxn ? YES
	// can you access static variables in non static fxn ? YES
	// can you call static fxn in non static fxn ? YES
	public void introduceYourself() {
		System.out.println(name + " is having a rollno as " + rollNo);
	}

	// can you access non static variables in static fxn ? NO
	// can you call non static fxn in static fxn ? NO
	// can you access static variables in static fxn ? YES
	// can you call static fxn in static fxn ? YES
	public static void getTotalStudents() {
		System.out.println(totalStudents);
	}
}
