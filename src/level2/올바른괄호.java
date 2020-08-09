package level2;

import java.util.Stack;
/*
 * 소요 시간: 6분
 * ☆☆☆☆☆, Cheating : X
 * easy
 */
public class 올바른괄호 {

	public static void main(String[] args) {
		//String s = "()()";
		//String s = "(())()";
		//String s = ")()(";
		String s = "(())(";
		
		boolean answer = true;
		Stack<Character> st = new Stack<>();
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) == '(') {
				st.add('(');
			}
			else if (s.charAt(i) == ')') {
				if (!st.empty())
					st.pop();
				else {
					answer = false;
					break ;
				}
			}
		}
		if (!st.isEmpty())
			answer = false;
		System.out.println(answer);
		System.out.println(st);
	}

}
