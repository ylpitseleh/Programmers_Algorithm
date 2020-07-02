package KakaoIntern2020;

import java.util.ArrayList;
import java.util.Arrays;

public class 다시풀기_2 {

	public static void main(String[] args) {
		//String expression = "100-200*300-500+20";
		String expression = "50*6-3*2";
		//String expression = "100-215*458+12";
		//String expression = "1-999";
		//String expression = "100-200-300-500*20";
		//String expression = "1-2+4*302*1*1-1";
		long answer = 0;
		
		// 연산자 우선순위 모든 경우의 수 
		String operPrior[] = {"*-+", "*+-", "-+*", "-*+", "+-*", "+*-"};
		
		// expression에서 숫자만 추출해서 ArrayList에 넣기
		ArrayList numsOrig = new ArrayList<Long>();
		String[] numStr = expression.split("[-+*]");
		for (int i=0; i<numStr.length; i++) {
			numsOrig.add(Long.parseLong(numStr[i]));
		}
		
		// expression에서 연산자만 추출해서 ArrayList에 넣기
		ArrayList opersOrig = new ArrayList<Character>();
		for (int i=0; i<expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '*' || c == '-' || c == '+')
				opersOrig.add(c);
		}
		
		for (int i=0; i<operPrior.length; i++) {
			ArrayList nums = new ArrayList<Long>();
			nums.addAll(numsOrig);
			ArrayList opers = new ArrayList<Character>();
			opers.addAll(opersOrig);
			//System.out.println();
			//System.out.println("["+i+"] 현재 우선순위 : "+operPrior[i]);
			// i번째 우선순위의 몇 번째 연산자인지
			for (int j=0; j<3; j++) {
				//System.out.println(j+" "+operPrior[i].charAt(j));
				while (opers.contains(operPrior[i].charAt(j))) {
					for (int k=0; k<opers.size(); k++) {
						if ((char)opers.get(k) == operPrior[i].charAt(j)) {
							char operator = (char)opers.remove(k);
							long n =  (long) nums.remove(k+1);
							if (operator == '*')
								nums.set(k, (long)nums.get(k) * n);
							else if (operator == '+')
								nums.set(k, (long)nums.get(k) + n);
							else if (operator == '-')
								nums.set(k, (long)nums.get(k) - n);
							/*
							 * break 해주는 이유
							 * ex) - - - 일 때 (-) - - 연산하고 나면  (-) - 이걸 검사해야하는데
							 * break 안 해주면 - (-) 두 번째 -를 검사하므로 break 해서 index 0 부터 다시 연산하게 해야함. 
							 */
							break ; 
						}
						//System.out.println(nums);
						//System.out.println(opers);
					}
				}
				
			}
			answer = Math.max(Math.abs((long)nums.get(0)), answer);
			System.out.println(Math.abs((long)nums.get(0)));
		}
		
		System.out.println("answer : "+answer);
	}

}
