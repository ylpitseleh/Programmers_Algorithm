package level3Second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 소요 시간: 1시간
 * ★★☆☆☆, Cheating : X
 * 이거 완전 쌩 개 기초 bfs인데 한 시간이나 걸린 나.. 연습만이 살 길이다. 
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
		
		ArrayList<Integer>[] a;
		a = new ArrayList[n];
		for (int i=0; i<n; i++)
			a[i] = new ArrayList<Integer>();
		
		for (int i=0; i<edge.length; i++) {
			a[edge[i][0]-1].add(edge[i][1]-1);
			a[edge[i][1]-1].add(edge[i][0]-1);
		}
		
		
		for (int i=0; i<n; i++)
			System.out.println(a[i]);
		int[] dist = new int[n];
		Queue<Integer> q = new LinkedList<>();
	
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		q.add(0);
		
		while (!q.isEmpty()) {
			int val = q.poll();
			System.out.println("VAL = "+val);
			for (int i=0; i<a[val].size(); i++) {
				if (dist[a[val].get(i)] == Integer.MAX_VALUE) {
					System.out.println("후보다 "+a[val].get(i));
					System.out.println(dist[val]);
					dist[a[val].get(i)] = dist[val] + 1;
					q.add(a[val].get(i));
				}
			}
		}
		
		for (int i=0; i<dist.length; i++) {
			System.out.print(dist[i]+" ");
		}
		int max = 0;
		for (int i=0; i<dist.length; i++) {
			max = Math.max(max, dist[i]);
		}
		for (int i=0; i<dist.length; i++) {
			if (dist[i] == max)
				answer++;
		}
		
		System.out.println("ANSWER = "+answer);
		
	}
	
}
