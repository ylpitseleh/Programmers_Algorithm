package level3Second;

import java.util.LinkedList;
import java.util.Queue;

public class 보행자천국_다시풀기 {
	public static void main(String[] args) {
		
		int cityMap[][] =  {{0,0,0}, 
							{0,0,0}, 
							{0,0,0}};
		int m = 3;
		int n = 3;
		
		/*
		int cityMap[][] = {{0,2,0,0,0,2}, 
						   {0,0,2,0,1,0}, 
						   {1,0,0,2,2,0}};
		int m = 3;
		int n = 6;
		*/
		/*
		int cityMap[][] = {{0,0,0,1}, 
						   {0,0,2,0}, 
						   {0,0,0,0}, 
						   {1,0,0,0}, 
						   {0,2,0,0}};
		int m = 5;
		int n = 4;
		*/
		int answer = 0;

		// 0 : O, 1 : X, 2 : 좌회전, 우회전 X
		int dp[][] = new int[n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				dp[i][j] = -cityMap[i][j];
			}
		}
		// dp에서 -1 : 못 가는 길. -2 : 좌회전, 우회전 X
		dp[0][0] = 1;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (dp[i][j] == -1) { // 못 가는 길
					dp[i][j] = 0; // 0으로 안 하면 다음 거에서 -1 플러스해버림
					continue ;
				}
				if (dp[i][j] == -2) { // 좌회전, 우회전 X
					dp[i][j] = 0;
					continue ;
				}
				if (i == 0 && j > 0)
					dp[0][j] = dp[0][j-1];
				if (j == 0 && i > 0)
					dp[i][0] = dp[i-1][0];
				if (i > 0 && j > 0)
					dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
			}
		}
		
	}

}
