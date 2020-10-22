package level3Second;

import java.util.LinkedList;
import java.util.Queue;

public class 보행자천국 {
	static int MOD = 20170805;
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

		int rightMap[][] = new int[m+1][n+1];
		int upMap[][] = new int[m+1][n+1];
		
		rightMap[1][1] = 1; // 시작점 
		upMap[1][1] = 1; 
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) { // 못 지나가는 길
				if (cityMap[i-1][j-1] == 1) {
					continue ;
				}
				else if (cityMap[i-1][j-1] == 2 ) { // 좌회전, 우회전 X
					upMap[i][j] = upMap[i-1][j];
					rightMap[i][j] = rightMap[i][j-1];
				}
				else if (cityMap[i-1][j-1] == 0) { // 지나갈 수 있는 길
					rightMap[i][j] += (upMap[i-1][j] + rightMap[i][j-1]) % MOD;
					upMap[i][j] += (upMap[i-1][j] + rightMap[i][j-1]) % MOD;
				}
			}
		}
		answer = (rightMap[m][n-1] + upMap[m-1][n]) % MOD;
		
	}

}
