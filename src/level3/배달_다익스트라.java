package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 소요 시간: 3시간
 * ★★★★☆, Cheating : O
 * 다익스트라 문제 => 힙(Priority Queue) & ArrayList의 List사용! 2중 for문 & 2차원 배열은 시간 초과난다. ex) 노드가 100만개인데 비용 정보가 2개일 때 매우 비효율적.
 */
public class 배달_다익스트라 {
	static ArrayList<Pair>[] a;
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
	/*
	a배열에 들어가는 값들 (실제로는 index-1임)
	a[1] Pair(2, 1), Pair(4, 2) // 1에서 출발하는 값들(도착 지점, 비용)
	a[2] Pair(3, 3) // 2에서 출발
	a[3]
	a[4]
	a[5] Pair(2, 2), Pair(3, 1), Pair(4, 2)
	*/
	public static void main(String[] args) {
		
		int N = 5;
		int road[][] = {{1, 2, 1}, // 0 1 1
						{2, 3, 3}, // 1 2 3
						{5, 2, 2}, // 4 1 2
						{1, 4, 2}, // 0 3 2
						{5, 3, 1}, // 4 2 1
						{5, 4, 2}};// 4 3 2
		int K = 3;
		
		/*
		int N = 6;
		int road[][] = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
		int K = 4;
		*/
		int answer = 0;
		// a[i] i는 출발 지점, a[i].get(j).dest = 도착 지점, a[i].get(j).cost = 비용
		a = new ArrayList[N];
		for (int i=0; i<N; i++)
			a[i] = new ArrayList<Pair>();
		for (int i=0; i<road.length; i++) {
			a[road[i][0]-1].add(new Pair(road[i][1]-1, road[i][2]));
			a[road[i][1]-1].add(new Pair(road[i][0]-1, road[i][2]));
		}
		d = new int[N]; // 0 부터 각 원소들까지 최소 비용
		
		Arrays.fill(d, Integer.MAX_VALUE);
		// 시작 노드값 초기화
		dijkstra(0);
		for (int i=0; i<N; i++) {
			System.out.print(d[i]+" ");
			if (d[i] <= K)
				answer++;
		}
		System.out.println(answer);
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
			
			for (int i=0; i<a[p.dest].size(); i++) { // p.dest 노드에서 출발하는 것들 
				int next = a[p.dest].get(i).dest; // 선택된 노드의 인접 노드
				int nextDist = a[p.dest].get(i).cost + p.cost; // ★중요, 선택된 노드를 인접 노드로 거쳐서 가는 비용
				System.out.println("next : "+next+" nextDist : "+nextDist);
				if (nextDist < d[next]) { // 기존 보다 더 저렴하면 교체
					d[next] = nextDist;
					pq.add(new Pair(next, nextDist));
				}
			}
		}
	}
	

}
