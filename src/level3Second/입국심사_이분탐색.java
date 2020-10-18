package level3Second;

import java.util.Arrays;
/*
 * 소요 시간: 20분
 * ★★★☆☆, Cheating : O
 * 충ㅇㅇㅇㅇㅇ분히 코테 나올 수 있는 유형. 이분탐색에 익숙해지자!!!!!
 * 중요하다고 표시한 for문 부분이 굉장히 새로웠다.
 * 첨에 문제 봤을땐 어떻게 풀어야할지 막막했는데 검색해서 이분탐색인거 알고 보니 되게 신기했다. 이렇게 푸는거라니. 
 */
public class 입국심사_이분탐색 {

	public static void main(String[] args) {
		int[] times = {7, 10};
		int n = 6;
		
		Arrays.sort(times);
		long start = 0;
		long end = (long)times[times.length-1] * n; // 최대 걸릴 수 있는 시간
		long mid = 0;
		long answer = Integer.MAX_VALUE;
		
		while (start <= end) {
			long sum = 0;
			System.out.println("MID = "+mid);
			mid = (start + end) / 2;
			
			for (int i=0; i<times.length; i++) // 중요!!! sum = 각 심사관들이 심사할 수 있는 최대 인원을 모두 합한다.
				sum += mid / times[i];
			System.out.println("SUM = "+sum);
			System.out.println();
			
			if (sum < n) // sum 시간 동안 심사를 다 못한 경우
				start = mid + 1;
			else { // sum 시간 동안 심사를 다 한 경우
				if (answer > mid)
					answer = mid;
				end = mid - 1;
			}
		}
		
		System.out.println(answer);
		
	}

}
