package Greedy;

import java.util.ArrayList;
import java.util.List;

public class 섬연결하기 {

	public static void main(String[] args) {
		int costs[][] = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
		int n = 4;
		
		int answer = 0;
		
		int dist[][] = new int[n][n];
		for (int i=0; i<costs.length; i++)
			dist[costs[i][0]][costs[i][1]] = dist[costs[i][1]][costs[i][0]] = costs[i][2];
		
		boolean visit[] = new boolean[n];
		List<Integer> connectAl = new ArrayList<>(n+1);
		connectAl.add(0);
		visit[0] = true;
		while (connectAl.size() < n) {
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			
			for (int i=0; i<connectAl.size(); i++) {
				int island = connectAl.get(i);
				for (int j=0; j<n; j++) {
					if (!visit[j] && island != j && dist[island][j] > 0 && dist[island][j] < min) {
						min = dist[island][j];
						minIdx = j;
					}
				}
			}
			visit[minIdx] = true;
			connectAl.add(minIdx);
			answer += min;
		}
		
		System.out.println(answer);
	}

}
