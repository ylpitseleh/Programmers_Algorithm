package level3;
/*
 * 소요 시간: 20분
 * ☆☆☆☆☆, Cheating : X
 */
public class 멀리뛰기 {

	public static void main(String[] args) {
		int n = 1;
		//int n = 3;
		
		long answer = 0;
		
		long dp[] = new long[n+1];
		
		dp[1] = 1;
		if (n >= 2)
			dp[2] = 2;
		for (int i=3; i<=n; i++) {
			dp[i] = dp[i-1] % 1234567 + dp[i-2] % 1234567;
		}
		
		answer = dp[n];
		System.out.println(answer);
	}

}
