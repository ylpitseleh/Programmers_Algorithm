package level2;

import java.util.Stack;
/*
 * 소요 시간: 40분
 * ★★☆☆☆, Cheating : O
 * StringBuilder로 일일이 구하다가 효율성 다 터져서 어떻게 팰린드롬을 한번에 없앨까 (ex. edcbaabcde) 고민하다가
 * 질문에 누가 스택쓰면 된다해서 스택으로 간단하게 구현했다. 
 * 이걸 스택이라고 바로바로 생각해내는게 중요한데 말이야... 효율성 안나올거같으면 자료구조 뭐써야할지 바로 떠올리자. 
 */
public class 짝지어제거하기 {

	public static void main(String[] args) {
		String s = "baabaa";
		//String s = "cdcd";
		//String s = "edcbaabcdeaa";
		
		int answer = 0;
		
		Stack<Character> st = new Stack<>();
		st.add(s.charAt(0));
		for (int i=1; i<s.length(); i++) {
			if (!st.empty()) {
				if (st.peek() == s.charAt(i)) {
					st.pop();
					continue ;
				}
			}
			st.add(s.charAt(i));
		}
		
		if (st.empty())
			answer = 1;
		else
			answer = 0;
		
		System.out.println(answer);
	}

}
