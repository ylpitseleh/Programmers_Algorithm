package level2;

import java.util.LinkedList;
import java.util.Queue;
/*
 * 소요 시간: 2시간 30분
 * ★★★★☆, Cheating : X
 * 두 시간 반 동안 붙들고 있다가 결국 해결한 나에게 근성의 박수를... 
 * 처음엔 엿같았는데 테케 몇 개 손으로 풀어보니까 규칙 알겠어서 결국 풀었다. 만세 만만세.
 */
public class re괄호변환 {
	//static String answer = "";
	public static void main(String[] args) {
		//String p = "(()())()";
		//String p = ")(";
		//String p = "()))((()";
		String p = ")()()()(";
		
		String answer = "";
		
		answer = recursive(0, p, false);
		System.out.println("answer : "+answer);
	}
	// vFlag = true면 아직 만들고있는 문자열이라서 answer에 붙이면 안 됨.
	private static String recursive (int depth, String s, boolean vFlag) {
		int openCnt = 0;
		int closeCnt = 0;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) == '(')
				openCnt++;
			else 
				closeCnt++;
			if (openCnt == closeCnt)
				break ;
		}
		String u = s.substring(0, openCnt+closeCnt);
		String v = s.substring(openCnt+closeCnt, s.length());
		System.out.println("u = "+u);
		System.out.println("v = "+v);
		System.out.println();
		
		Queue<Character> q = new LinkedList<>();
		// u가 올바른 괄호 문자열인지 검사
		if (!u.equals("")) {
			q.add(u.charAt(0));
			for (int i=1; i<u.length(); i++) { 
				char peek = q.peek();
				char c = u.charAt(i);
				if (peek == '(' && c == ')')
					q.poll();
				else
					q.add(c);
			}
		}
		// u가 올바른 괄호 문자열 O
		if (q.isEmpty()) {
			System.out.println(u+"는 올바른 괄호 문자열이다.");
			
			if (u.equals(""))
				return u;
			if (!v.equals("") )
				v = recursive(depth + 1, v, false);
			System.out.println("여기서 u = "+u+" v = "+v);
			//answer = u + v;
			u = u + v;
		}
		else {
			System.out.println(u+"는 올바른 괄호 문자열이 아니다.");
			// u가 올바른 괄호 문자열 X
			String tmp = "("; 
			String add = recursive(depth + 1, v, true); // 문자열 v에 대해 1단계부터 재귀적으로 수행
			//System.out.println("add = "+add);
			tmp += add;
			tmp += ")";
			u = s.substring(1, u.length()-1);
			String newU = "";
			for (int i=0; i<u.length(); i++) {
				if (u.charAt(i) == '(')
					newU += ")";
				else
					newU += "(";
			}
			tmp += newU;
			u = tmp;
			System.out.println("변환된 u "+u);
			//answer += u;
		}
		
		return u;
		
		
		
		//return v;
	}
}
