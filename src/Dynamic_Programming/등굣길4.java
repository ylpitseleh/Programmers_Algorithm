package Dynamic_Programming;


public class 등굣길4 {
	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = {{2, 2}};
		
		int dp[][] = new int[n][m];
		for (int i=0; i<puddles.length; i++) {
			dp[puddles[i][1]-1][puddles[0][1]-1] = -1;
		}
		dp[0][0] = 1;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				 if (dp[i][j] == -1) {
	                    dp[i][j] = 0;
	                    continue ;
				 }
				if (i==0 && j>0)
					dp[0][j] = dp[0][j-1];
				if (j==0 && i>0)
					dp[i][0] = dp[i-1][0];
                if (i>0 && j>0)
				    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
			}
		}
		
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}

}
