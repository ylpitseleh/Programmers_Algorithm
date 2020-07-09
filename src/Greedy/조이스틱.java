package Greedy;

public class 조이스틱 {

	public static void main(String[] args) {
		//String name = "JEROEN"; //처음에 AAAAAA로 시작
		//String name = "JAN"; //처음에 AAA로 시작
		String name = "BBBBAAAAABBB";
		
		int answer = 0;
		
		// 알파벳 움직이기 + 커서 움직이기
		int exp = name.length() - 1; // 첫글자부터 끝글자까지 순서대로 이동하는 경우.
		for (int i=0; i<name.length(); i++) {
			if (name.charAt(i) <= 'M')
				answer += name.charAt(i) - 'A';
			else
				answer += 'Z' - name.charAt(i) + 1;
			
			// A 아닌 모든 문자를 들릴 수 있는 최소 좌우 이동
			// 모든 위치에서 역으로 돌아가는 경우 최소를 찾는다.
			if (name.charAt(i) == 'A') {
				int nextIdx = i+1; // 다음 A가 나오는 위치
				int countA = 0;
				// A가 연속해서 나오는 개수만큼 countA++;
				while (nextIdx < name.length() && name.charAt(nextIdx)=='A') {
					countA++;
					nextIdx++;
				}
				//System.out.println(countA);
				int tmp = (i-1)*2 + (name.length()-1-i-countA);
				/*
				 * tmp = (i-1)*2 + (name.length()-1-i-countA);
				 * BBBB[A]AAAABBB 일 때 
				 * 0에서 []위치로 갔다가 다시 0으로 가기 = (i-1)*2
				 * 맨 끝에서 []로 가기 = (name.length()-1-i-countA)  
				 */
				if (exp > tmp)
					exp = tmp;
			}
		}
		answer += exp;
		System.out.println(answer);
	}
}
