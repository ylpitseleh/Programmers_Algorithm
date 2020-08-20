package level3;

import java.util.LinkedList;
import java.util.Queue;

// 1 13
public class re섬연결하기 {

	public static void main(String[] args) {
		int costs[][] = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
		int n = 4;
		
		int answer = 0;
		
		int[][] price = new int[n][n];
		
		for (int i=0; i<costs.length; i++) {
			price[costs[i][0]][costs[i][1]] = costs[i][2];
			price[costs[i][1]][costs[i][0]] = costs[i][2];
			for (int j=0; j<costs.length; j++) {
				if (price[i][j] == 0)
					price[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(price[i][j]+" ");
			}
			System.out.println();
		}
		
		boolean[][] minCost = new boolean[n][n];
		//for (int i=0; i<n; i++)
		
		
		
	}

}
