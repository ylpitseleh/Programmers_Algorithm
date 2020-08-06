package Heap;

import java.util.PriorityQueue;

public class 더맵게1 {

	public static int main(String[] args) {
		//int scoville[] = {1, 2, 3, 9, 10, 12};
		int scoville[] = {0,1,0,0};
		int K = 7;
		int answer = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue();
		for (int n : scoville) {
			pq.offer(n);
		}
		
		while (pq.peek() <= K) {
			if (pq.size() == 1)
				return -1;
			// 두 개를 섞어서 새로운걸 만드는거니까 둘 다 poll
			int a = pq.poll();
			int b = pq.poll();
			
			int res = a + (b*2);
			pq.offer(res);
			answer++;
		}
		
		return answer;

	}

}
