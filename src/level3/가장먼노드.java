package level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 소요 시간: 1시간 
 * ★★☆☆☆, Cheating : O
 * 최단 경로를 DFS로 풀고 앉았다가 테케 틀려서 답 봤다... 대환장... 심지어 행렬도 아니고 인접리스트로 풀어야 하는 거였다.
 * 어쩐지 하나가 시간초과가 나더라. DFS, BFS 진짜 한참 부족하다. 
 */
public class 가장먼노드 {
	
	public static void main(String[] args) {
		int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		int n = 6;
		/*
		int[][] edge = {{1,2},{2,3},{3,4}};
		int n = 4;
		*/
		int answer = 0;
		
		ArrayList<Integer>[] list = new ArrayList[n];
		int[] count = new int[n];
		
		for (int i=0; i<n; i++)
			list[i] = new ArrayList<>();
		
		for (int i=0; i<edge.length; i++) {
			int n1 = edge[i][0] - 1;
			int n2 = edge[i][1] - 1;
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		count[0] = 1;
		int max = 0;
		while (!q.isEmpty()) {
			int x = q.poll();
			
			for (int i=0; i<list[x].size(); i++) {
				if (count[list[x].get(i)] == 0) {
					q.add(list[x].get(i));
					count[list[x].get(i)] = count[x] + 1;
					max = Math.max(max, count[list[x].get(i)]);
				}
			}
		}
		
		for (int i=0; i<n; i++) {
			if (count[i] == max)
				answer++;
		}
		for (int i=0; i<n; i++)
			System.out.print(count[i]+" ");
		System.out.println();
		System.out.println(answer);
	}
}
