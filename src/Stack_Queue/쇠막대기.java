package Stack_Queue;

import java.util.Stack;

public class 쇠막대기 {

	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		
		int answer = 0;
		
		Stack<Integer> s = new Stack<Integer>();
		int laser = 0;
		
		for (int i=1; i<arrangement.length(); i++) {
			if (arrangement.charAt(i-1)=='(' && arrangement.charAt(i)=='(') {
				s.add(0);
			}
			else if (arrangement.charAt(i-1)=='(' && arrangement.charAt(i)==')') {
				if (s.size() == 0) {
					laser = 0;
					continue ;
				}
				laser++;
				//answer += s.size();
				for (int j=0; j<s.size(); j++) {
					s.set(j, s.get(j)+1);
				}
			}
			else if (arrangement.charAt(i-1)==')' && arrangement.charAt(i)==')') {
				int pop = s.pop();
				System.out.println("pop! : "+pop);
				answer += pop + 1;
				
			}
			System.out.println(s+" "+laser);
		}
		System.out.println("answer : "+answer);
	}

}
