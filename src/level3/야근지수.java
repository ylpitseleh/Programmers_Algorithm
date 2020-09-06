package level3;

import java.util.Collections;
import java.util.PriorityQueue;
/*
 * 소요 시간: 38분
 * ★★☆☆☆, Cheating : O
 * 문제 이해하는데 거의 시간 다 썼다. 문제 이해하는거 말고는 그냥 볼 것도 없이 쉬운 문제다.
 * 야근 피로도를 최소화하려면 for문 돌면서 works 배열의 최대값에서 -1씩 빼주면 된다. 
 * 나는 왜 최대값을 그렇게 구하는지 이해를 못 해서 일단 질문 올려놨다. 
 * 왜 첫 번째 테케에서 {3, 0, 3} 이면 result가 9인데 이게 왜 안 되는지 모르겠다. 
 * 그래서 첨엔 퍼뮤로 더해서 4될 수 있는걸 다 구해야하나 생각했는데 그게 아니었다. 
 */
public class 야근지수 {

	public static void main(String[] args) {
		
		int works[] = {4, 3, 3}; // 각 일에 대한 작업량
		int n = 4; // 퇴근까지 남은 시간 
		
		/*
		int works[] = {2, 1, 2};
		int n = 1;
		*/
		/*
		int works[] = {1, 1};
		int n = 3;
		*/
		
		long answer = 0;
		// 야근 피로도 : 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값
		// works에서 제일 큰 숫자부터 줄여가기 시작해야한다. 
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i=0; i<works.length; i++) {
			pq.add(works[i]);
		}
		
		boolean checkZero = false;
		for (int i=0; i<n; i++) {
			int poll = pq.poll();
			poll -= 1;
			if (poll < 0) {
				checkZero = true;
			}
			pq.add(poll);
		}
		
		//for (int i=0; i<works.length; i++)
			//System.out.println(pq.poll());
		if (checkZero)
			answer = 0;
		else {
			for (int i=0; i<works.length; i++) {
				int poll = pq.poll();
				answer += poll * poll;
			}
		}
		System.out.println(answer);
			
	}
	

}
