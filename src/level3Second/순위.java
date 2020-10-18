package level3Second;

import java.util.ArrayList;

public class 순위 {
	

	public static void main(String[] args) {
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		int n = 5;
		//int[][] results = {{1, 2}, {2, 3}, {3, 4}, {5, 6}, {6, 7}, {7, 8}};
		//int n = 8;
		//int[][] results = {{1, 2}, {3, 4}};
		//int n = 4;
		
		int answer = 0;

		int map[][] = new int[n][n];
		
		for (int i=0; i<results.length; i++) {
			map[results[i][0]-1][results[i][1]-1] = 1; // 승리
			map[results[i][1]-1][results[i][0]-1] = -1; // 패배
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (map[i][j] != 0) {
					dfs(i, j, map[i][j], map);
				}
			}
		}
		
	}
	// flag = 1 승리, flag = -1, 패배
	private static void dfs (int val1, int val2, int flag, int[][] map) {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map.length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("VAL = "+val2);
		for (int i=0; i<map.length; i++) {
			if (map[val2][i] == 0)
				continue ;
			System.out.println("--- val, i = "+val2+" "+i);
			if (flag == 1) { // 내가 이긴애가 이긴거면 나도 이긴거
				if (map[val2][i] == 1)
					map[val1][i] = 1;
			}
			else if (flag == -1) { // 내가 진 애가 진거면 나도 진거
				if (map[val2][i] == -1)
					map[val1][i] = -1;
			}
			dfs(val2, i, map[val2][i], map);
		}
	}

}
