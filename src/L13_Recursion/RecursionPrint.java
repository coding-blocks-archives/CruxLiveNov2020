package L13_Recursion;

public class RecursionPrint {

	public static void main(String[] args) {

		subsequences("abc", "");
	}

	public static void subsequences(String ques, String ans) { // abc ""

		if(ques.length() == 0) {
			System.out.println(ans);
			return ;
		}
		
		char ch = ques.charAt(0); // a
		String roq = ques.substring(1); // bc

		subsequences(roq, ans); // bc , ""
		subsequences(roq, ans + ch); // bc , a

	}

}
