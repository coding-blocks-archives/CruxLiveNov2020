package L10_Strings;

public class SBDemo {

	public static void main(String[] args) {

		// string to sb
		String str = "hello";
		StringBuilder sb = new StringBuilder();

		// print
		System.out.println(sb);

		// length
		System.out.println(sb.length());

		// charAt : 0 -> length-1
		System.out.println(sb.charAt(3)); // l

		// substring
		System.out.println(sb.substring(2)); // llo
		System.out.println(sb.substring(1, 4)); // ell

		// append
		sb.append("bye");
		System.out.println(sb);

		// insert : 0 -> length
		sb.insert(2, "hi");
		System.out.println(sb);

		// setCharAt
		sb.setCharAt(1, 'y');
		System.out.println(sb);

		// remove
		sb.deleteCharAt(3);
		System.out.println(sb);

		sb.delete(2, 5);
		System.out.println(sb);

		// sb to string
		String s = sb.toString();

	}

	public static String fun() {

		// concatenation
		StringBuilder sb = new StringBuilder();

		return sb.toString();
	}

}
