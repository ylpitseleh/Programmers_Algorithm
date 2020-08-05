package level2;
/*
 * 소요 시간: 40분
 * ★★★☆☆, Cheating : X
 * 역시 그리디가 제일 어려워 하고 봤는데 직접 자리수마다 가능한 index 써보면서 해보니까 
 * 이중포문에 안 쪽 포문 index만 변화시키면서 하면 돼서 생각보다 금방 했다.
 */
public class 큰수만들기 {

	public static void main(String[] args) {
		/*
		String number = "1924";
		int k = 2;
		*/
		/*
		String number = "1231234";
		int k = 3;
		*/
		
		String number = "4177252841";
		int k = 4;
		
		StringBuilder answer = new StringBuilder();
		
		int startIdx = 0;
		int len = number.length() - k; // answer가 몇 자리 수 인지
		for (int i=0; i<len; i++) {
			int max = -1;
			//System.out.println(startIdx+" "+(k+i));
			for (int j=startIdx; j<=k+i; j++) {
				if (max < number.charAt(j)-'0') {
					max = number.charAt(j)-'0';
					startIdx = j + 1;
				}
			}
			//System.out.println(max);
			answer.append(max);
		}
		String answerS = answer.toString();
        //return answerS;
		System.out.println(answer);
	}

}
