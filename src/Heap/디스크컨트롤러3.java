package Heap;

import java.util.PriorityQueue;

public class 디스크컨트롤러3 {

	public static void main(String[] args) {
		int jobs[][] = {{0, 3}, {1, 9}, {2, 6}};
		int answer = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue();
		int N = jobs.length;
		for (int i=0; i<N; i++) {
			pq.add(jobs[i][1]);
		}
		System.out.println(pq);
		
		for (int i=0; i<N; i++) {
			
		}
		
	}

}
