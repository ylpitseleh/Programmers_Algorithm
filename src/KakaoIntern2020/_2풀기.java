package KakaoIntern2020;

import java.util.ArrayList;

public class _2풀기 {

	public static void main(String[] args) {
		//String expression = "100-200*300-500+20";
		// * > + > -
		String expression = "50*6-3*2";
		// - > *
		long answer = 0;
		
		// 연산자 우선순위 모든 경우의 수 
		String operPrior[] = {"*-+", "*+-", "-+*", "-*+", "+-*", "+*-"};
		
		// 연산자 제외한 모든 숫자 ArrayList에 넣기
		ArrayList alNumOriginal = new ArrayList<Integer>();
		ArrayList alOperOriginal = new ArrayList<Character>();
		
		int N = 0; // 연산자 제외한 숫자들의 수 
		String s = "";
		for (int i=0; i<expression.length(); i++) {
			if (expression.charAt(i) == '*' || expression.charAt(i) == '+'
					|| expression.charAt(i) == '-') {
				N++;
				alNumOriginal.add(Integer.parseInt(s));
				alOperOriginal.add(expression.charAt(i));
				s = "";
			}
			else {
				s += expression.charAt(i);
				if (i == expression.length() - 1) {
					alNumOriginal.add(Integer.parseInt(s));
				}
			}
		}
		N++;
		
		ArrayList alNum = new ArrayList<Integer>();
		ArrayList alOper = new ArrayList<Character>();
		//alNum.addAll(alNumOriginal);
		//alOper.addAll(alOperOriginal);
		
		System.out.println(alNum);
		System.out.println(alOper);
		System.out.println(alNumOriginal);
		System.out.println(alOperOriginal);
		System.out.println("N : " + N);
		System.out.println();
		
		int operLen = alOperOriginal.size();
		for (int i=0; i<operPrior.length; i++) { // oper.length = 6
			alNum.clear();
			alOper.clear();
			alNum.addAll(alNumOriginal);
			alOper.addAll(alOperOriginal);
			for (int j=0; j<operPrior[i].length(); j++) { // ex) *, -, +
				while (true) {
					int isNotContains = 1;
					for (int k=0; k<alOper.size(); k++) { // ex) -, *, -, +
						if ((char)alOper.get(k) == operPrior[i].charAt(j)) {
							isNotContains = 0;
							break ;
						}
					}
					if (isNotContains == 1)
						break ;
					for (int k=0; k<alOper.size(); k++) { // ex) -, *, -, +
						
						if ((char)alOper.get(k) == operPrior[i].charAt(j)) {
							char c = (char)alOper.get(k);
							if (c == '*') {
								alNum.set(k+1, (int)alNum.get(k) * (int)alNum.get(k+1));
								alNum.remove(k);
								alOper.remove(k);
							}
							else if (c == '-') {
								alNum.set(k+1, (int)alNum.get(k) - (int)alNum.get(k+1));
								alNum.remove(k);
								alOper.remove(k);
							}
							else if (c == '+') {
								alNum.set(k+1, (int)alNum.get(k) + (int)alNum.get(k+1));
								alNum.remove(k);
								alOper.remove(k);
							}
						}
					}
					
					
				}
				
			}
			int n = (int) alNum.get(0);
			answer = Math.max(answer, Math.abs(n));
			System.out.println(answer);
			System.out.println("alNum : "+alNum);
			System.out.println(alOper);
			System.out.println();
		}
		
	}

}
