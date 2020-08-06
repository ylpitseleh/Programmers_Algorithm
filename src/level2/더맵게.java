package level2;

import java.util.PriorityQueue;
/*
 * 소요 시간: 1시간
 * ★★☆☆☆, Cheating : O
 * while(!pq.isEmpty())로 했더니 scoville[] = {0,0,0,1}인 경우를 못 잡는 것 같아서 그냥 배꼈다. pq는 poll이나 peek하면 항상 제일 작은게 온다는 사실을 명심.
 */
public class 더맵게 {

	public static void main(String[] args) {
		int scoville[] = {1, 2, 3, 9, 10, 12};
		//int scoville[] = {0, 0, 0, 1};
		int K = 7;
		int answer = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue();
		for (int n : scoville) {
			pq.offer(n);
		}
		System.out.println(pq);
		
		while (pq.peek() <= K) {
			if (pq.size() == 1)
				break ;
			int a = pq.poll();
			int b = pq.poll();
			
			int res = a + (b*2);
			pq.offer(res);
			answer++;
		}
		
		System.out.println(answer);
	}

}
