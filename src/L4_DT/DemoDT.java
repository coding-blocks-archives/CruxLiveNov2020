package L4_DT;

public class DemoDT {

	public static void main(String[] args) {

		byte b = 10;
		short s = 10;
		int i = 10;
		long l = 10;

		// case 1
		// b = s ;
		// b = i ;
		// b = l ;

		s = b;
		// s = i ;
		// s = l ;

		i = b;
		i = s;
		// i = l ;

		l = b;
		l = s;
		l = i;

		// for (byte by = 0; by <= 126; by++) {
		// System.out.println(by);
		// }

		// case 2
		b = 100; // implicit typecasting
		b = (byte) 130; // explicit typecasting\

		// case 3
		i = (int) 10000000000L;
		System.out.println(i);

		// case 4
		float f = 3.4f;
		double d = 4.5;

		// f = d ;
		d = f;

		// case 5
		i = (int) f;
		System.out.println(i);

		f = i;
		System.out.println(f);

		// case 6
		boolean bl = false;
		// bl = 0 ;

		if (bl) {

		}
		
		// case 7
		char ch = 'a' ;
		System.out.println(ch);
		System.out.println((int)ch); // corresponding integer value
		
		ch =  100 ;
		System.out.println(ch);
		
		int in = 'z' ;
		System.out.println(in);
	
		ch = (char)(ch + 1);
		// ch++ ;
		System.out.println(ch);
		
		// case 8
		System.out.println(10 + 20 + "Hello" + 10 + 20); // 30Hello1020
		System.out.println(2 + ' ' + 5); //  39
		System.out.println(2 + " " + 5); // 2 5
		System.out.println("Hello" + '\t' + "World");
		System.out.println("Hello" + "\t" + "World");
		System.out.println((int)'\t');
		
		
		
		
		
	}

}













