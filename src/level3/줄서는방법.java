package level3;

import java.util.ArrayList;
// https://medium.com/@leeth0610/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%88%9C%EC%97%B4-%EC%A4%84-%EC%84%9C%EB%8A%94-%EB%B0%A9%EB%B2%95-java-2f558274088
/*
 * 소요 시간: 3시간
 * ★★★☆☆, Cheating : O
 * 뭔가 풀릴듯 말듯 안 풀려서 빡쳤던 문제 ㅠㅠ 나중에 다시 풀어보긴 귀찮다. 그냥 연산이여서..
 */
public class 줄서는방법 {
	public static void main(String[] args) {
		int n = 3;
		long k = 5; // 3 1 2
		
		int answer[] = new int[n];
		ArrayList<Integer> al = new ArrayList<>();
		long factorial = 1;
		for (int i=1; i<=n; i++) {
			al.add(i);
			factorial *= i;
		}
		
		long remain = k - 1; // k가 1부터 시작하므로
		int i = 0;
		while (i < n) {
			factorial = factorial / (n-i); // i번째 숫자가 나오는 총 경우의 수 (n=3이면 2)
			long value = remain / factorial;
			answer[i] = al.get((int)value);
			al.remove((int)value);
			remain = remain % factorial;
			i++;
		}
		
		for (int j=0; j<n; j++)
			System.out.print(answer[j]+" ");
		//return answer;
	}
	
}
