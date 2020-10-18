package KakaoRecruitment2020하반기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
/*
 * 소요 시간: 30분
 * ★★★☆☆, Cheating : O
 * 전에 풀었던 다익스트라 이용해서 뚝딱 풀었다.. 역시 방법만 알면 구현은 쉬운듯...
 */
public class _4 {
	static ArrayList<Pair>[] alList;
	static int d[]; // distance
	static class Pair implements Comparable<Pair>{
		int dest; // 도착지
		int cost; // 비용
		Pair (int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
		
		@Override // pq에 비용이 적은 것 우선
		public int compareTo(Pair p) {
			return this.cost - p.cost;
		}
	}
	public static void main(String[] args) {
		
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, 
				{2,4, 66}, {2, 3, 22}, {1, 6, 25}};
		
		/*
		int n = 7;
		int s = 3;
		int a = 4;
		int b = 1;
		int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
		*/
		/*
		int n = 6;
		int s = 4;
		int a = 5;
		int b = 6;
		int[][] fares = {{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, 
				{2, 4, 8}, {4, 3, 9}};
		*/
		
		// (s->a) + (s->b)랑 (s->i) + (i->a) + (i->b) 비교
		alList = new ArrayList[n];
		for (int i=0; i<n; i++)
			alList[i] = new ArrayList<Pair>();
		
		for (int i=0; i<fares.length; i++) {
			alList[fares[i][0]-1].add(new Pair(fares[i][1]-1, fares[i][2]));
			alList[fares[i][1]-1].add(new Pair(fares[i][0]-1, fares[i][2]));
		}
		d = new int[n]; // 0 부터 각 원소들까지 최소 비용
		
		Arrays.fill(d, Integer.MAX_VALUE);
		// 시작 노드값 초기화
		dijkstra(s-1);
		
		int sameRoad[] = new int[n]; // A, B가 같이가는 길
		for (int i=0; i<n; i++)
			sameRoad[i] = d[i];
		
		int minPath = Integer.MAX_VALUE;
		for (int i=0; i<n; i++) {
			d = new int[n];
			Arrays.fill(d, Integer.MAX_VALUE);
			dijkstra(i);
			int path = d[a-1] + d[b-1] + sameRoad[i];
			if (minPath > path)
				minPath = path;
		}
		System.out.println(minPath);
	}
	
	private static void dijkstra (int start) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		d[start] = 0;
		pq.add(new Pair(start, 0));
		
		// ex) 1에서 4로 가는 비용이 100인데 1->3->4 가 30이라면 d[4]에 30 저장
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			System.out.println("< p.dest : "+p.dest+" p.cost : "+p.cost+" >");
			if (d[p.dest] < p.cost) // 최단 거리가 아닌 경우
				continue ;
			
			for (int i=0; i<alList[p.dest].size(); i++) { // p.dest 노드에서 출발하는 것들 
				int next = alList[p.dest].get(i).dest; // 선택된 노드의 인접 노드
				int nextDist = alList[p.dest].get(i).cost + p.cost; // ★중요, 선택된 노드를 인접 노드로 거쳐서 가는 비용
				//System.out.println("next : "+next+" nextDist : "+nextDist);
				if (nextDist < d[next]) { // 기존 보다 더 저렴하면 교체
					d[next] = nextDist;
					pq.add(new Pair(next, nextDist));
				}
			}
		}
	}
}
