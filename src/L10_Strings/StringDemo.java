package L10_Strings;

import java.util.Scanner;

public class StringDemo {

	public static void main(String[] args) {

		String str = "helloo"; // literal

		// print
		System.out.println(str);

		// length
		System.out.println(str.length());

		// charAt
		System.out.println(str.charAt(0));
		char ch = str.charAt(2); // l
		System.out.println(ch);
		System.out.println(str.charAt(str.length() - 1));

		// substring
		System.out.println(str.substring(1, 3)); // el
		System.out.println(str.substring(1, 5)); // ello
		System.out.println(str.substring(3, 4)); // l
		System.out.println(str.substring(1, 1)); // ""
		System.out.println(str.substring(1)); // ello

		// System.out.println(str.substring(3,7)); // error

		// index of
		System.out.println(str.indexOf("oo")); // 4
		System.out.println(str.indexOf("Ll")); // -1 : is not present

		// lastindexof
		System.out.println(str.lastIndexOf("o")); // 5

		// starts With
		System.out.println(str.startsWith("He")); // false
		System.out.println(str.startsWith("hel")); // true

		// ends with
		System.out.println(str.endsWith("lo")); // false

		// concat
		String s1 = "hi";
		String s2 = "bye";
		String s3 = s1 + s2;
		System.out.println(s1 + ", " + s2 + ", " + s3);
		String s4 = s1.concat(s2);
		System.out.println(s1 + ", " + s2 + ", " + s4);

		String s5 = "hhibyee";
		String s6 = s5.substring(1, 6); // hibye

		Scanner scn = new Scanner(System.in);
		// String s7= scn.next() ; // hibye

		// equals and ==
		s1 = "Hello";
		s2 = s1;
		s3 = "Hello";
		s4 = new String("Hello");

		System.out.println((s1 == s2) + ", " + s1.equals(s2));
		System.out.println((s1 == s3) + ", " + s1.equals(s3));
		System.out.println((s1 == s4) + ", " + s1.equals(s4));

		str.replace('l', 'q');
		// System.out.println(str1);
		System.out.println(str);

		long start = System.currentTimeMillis();
		appendString();
		long end = System.currentTimeMillis();

		System.out.println(end - start);

	}

	public static void appendString() {

		int n = 100000;

		// String str = "";
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			// str += i;
			sb.append(i);
		}

	}

}
