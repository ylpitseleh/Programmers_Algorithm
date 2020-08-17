package level3;
/*
 * 소요 시간: 10분
 * ☆☆☆☆☆, Cheating : X
 */
//d[n-2]의 사각형 오른쪽에 누워진 직사각형 2개가 붙음
//d[n-1]의 사각형 오른쪽에 세워진 직사각형 1개가 붙음
public class _2xn타일링 {

	public static void main(String[] args) {
		int n = 4;
		
		int answer = 0;
		
		int dp[] = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i=3; i<=n; i++)
			dp[i] = dp[i-1] % 1000000007 + dp[i-2] % 1000000007;
       
		answer = dp[n] % 1000000007;
		
		System.out.println(dp[n]);
	}

}
