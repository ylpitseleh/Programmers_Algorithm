package Stack_Queue;

import java.util.Collections;
import java.util.PriorityQueue;
// 이걸 왜 굳이 큐로 풀어야하지..? 이게 왜 머리가 안 돌아가지..?
// 으렵당...이걸 오또케 생각해내지..HashMap 했다가 순서 없는거 깨닫고 다시
// ArrayList 했다가 별 ㅈㄹ다했다. 다시 풀어보자 !!
public class 프린터4 {

	public static void main(String[] args) {
		int priorities[] = {2, 1, 3, 2};
		int location = 2;
		//int priorities[] = {1, 1, 9, 1, 1, 1};
		//int location = 0;
		
		int answer = 1;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i=0; i<priorities.length; i++) {
			pq.add(priorities[i]);
		}
		
		while (!pq.isEmpty()) {
			for (int i=0; i<priorities.length; i++) {
				if (priorities[i] == (int)pq.peek()) {
					if (i == location) {
						System.out.println(answer);
						// return answer;
					}
					pq.poll();
					answer++;
				}
			}
		}
		// return answer;
	}
}
