package level3;

import java.util.Arrays;
/*
 * 소요 시간: 30분
 * ★☆☆☆☆, Cheating : O
 * 내가 푼 건 효율성 한 개가 틀려서 베꼈는데 이 방법이 훨씬 깔끔하다. 
 * 다 나눠준다음에 나머지 값만 분산해서 추가해주면 된다! 
 * 엄청 쉬운 문제.
 */
public class 최고의집합 {

	public static void main(String[] args) {
		int n = 2;
		int s = 1;
		/*
		int n = 2;
		int s = 1;
		*/
		/*
		int n = 2;
		int s = 8;
		*/
		
		int[] answer = new int[n];
		if (n > s) {
			answer = new int[1];
			answer[0] = -1;
		}
		for (int i=0; i<n; i++)
			answer[i] = s / n;
		for (int i=0; i<s%n; i++)
			answer[i]++;
		Arrays.sort(answer);
		/*
		n=3, s=13인 경우
		첫 번쨰 for문에서 4 4 4만들고
		두 번째 for문에서 5 4 4만든다.	
		*/
	}

}
