package level3;
/*
 * 소요 시간: 30분
 * ★★☆☆☆, Cheating : O
 * i==0 이거나 j==0일 때 무조건 1로 채웠더니 테케 몇 개가 틀려서 답 보니까 dp[0][j] = dp[0][j-1] 이런식으로 해줘야하는거였다. 
 */
public class 등굣길 {

	public static void main(String[] args) {
		int puddles[][] = { { 2, 2 } };
		int m = 4;
		int n = 3;

		int answer = 0;

		int dp[][] = new int[n][m];
		for (int i = 0; i < puddles.length; i++) {
			dp[puddles[i][1] - 1][puddles[i][0] - 1] = -1; // 웅덩이
		}
		
		dp[0][0] = 1; // 시작점 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dp[i][j] == -1) {
					dp[i][j] = 0; // 0으로 안 하면 다음 거에서 -1 플러스해버림 
					continue;
				}
				if (i == 0 && j > 0)
					dp[0][j] = dp[0][j - 1];
				if (j == 0 && i > 0)
					dp[i][0] = dp[i - 1][0];
				if (i > 0 && j > 0)
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		answer = dp[n - 1][m - 1];
	}

}
