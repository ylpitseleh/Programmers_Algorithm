package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
// 배꼈당. 문제 이해하는게 힘들었지만 어렵지 않군요.
public class 라면공장2 {

	public static void main(String[] args) {
		int stock = 4;
		int dates[] = {4, 10, 15};
		int supplies[] = {20, 5, 10};
		int k = 30;
		int answer = 0;
		
		// supplies 기준으로 내림차순 정렬됨.
		Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		int idx = 0;
		for (int i=0; i<k; i++) {
			// 날짜가 됐을 때 밀가루를 추가해줌.
			if (idx < dates.length && i == dates[idx]) {
				pq.add(supplies[idx]);
				idx++;
			}
			// stock 다 떨어지면 채워줌. 
			if (stock == 0) {
				stock += pq.poll();
				answer++;
			}
			stock -= 1;
		}
		
		System.out.println(answer);
	}

}
