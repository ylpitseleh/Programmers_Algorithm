package KakaoRecruitment2019;

import java.util.Arrays;
/*
 * 소요 시간: 4시간
 * ★★★★★, Cheating : O
 * 너무 복잡하다. 이걸 어떻게 생각해내는지 모르겠다.
 * 위에 while문은 그렇다 쳐도 while문 밑에를 이해를 잘 못하겠다. 
 */
public class 무지의먹방라이브 {

	public static void main(String[] args) {
		
		int[] food_times = {3, 1, 2};
		long k = 5;
		
		/*
		int[] food_times = {30, 1, 9};
		long k = 8;
		*/
		int answer = 0 ;
		int N = food_times.length;
		int[] sortFood = sort(N, food_times);
		
		/*
		 * 우리가 알고 싶은 것은 K초 후에 무지가 어떤 음식을 먹느냐이다.
		 * K초 근처에서의 값이 중요하지, K초까지 가는 모든 값이 중요한 것은 아니다.
		 * 따라서 시간을 증가할 때 음식의 남은 개수만큼 더해주며 증가시킨다.
		 */
		int time = 0;
		int foodTimesLeft = N; // 남은(0이 아닌) food_times의 개수
		int round = 0; // 한 라운드씩 카운트한다. (food_times 한 바퀴 도는게 한 라운드)
		int idx = 0; // foodTimesLeft가 -- 될 때 인덱스 올려줘서 0인거 제외하기 위함 
		while (time + foodTimesLeft <= k) {
			time += foodTimesLeft;
			round++;
			for (int i=idx; i<N; i++) {
				if (sortFood[i] == round) {
					foodTimesLeft--;
					idx++;
				}
				else // sortFood가 오름차순 정렬돼있기 때문에 round랑 같은게 없으면 바로 break해도 됨. 
					break ;
			}
		}

		// while문이 끝난다면 k초 근처에 다가왔다는 뜻
		// 이제 남은 음식 중에 k초 후에 몇 번 음식을 먹게 되는지 순차 검색으로 탐색한다. 
		long cnt = k - time + 1; // k == time인 경우 때문에 +1 하는 것 같다. 
		for (int i=0; i<N; i++) {
			System.out.println("foodtimes[i] round "+food_times[i]+" "+round);
			if (food_times[i] > round)
				cnt--;
			System.out.println("cnt / k-time "+cnt+" "+(k-time));
			if (cnt == 0) {
				answer = i + 1;
				break ;
			}
				
		}
		System.out.println(time+" "+round);
		System.out.println("answer = "+answer);
	}

	private static int[] sort (int n, int[] food_times) {
		int[] res = new int[n];
		System.arraycopy(food_times, 0, res, 0, n);
		// (전송원 배열, 소스 배열의 개시 위치, 전송처 배열, 전송처 데이터내의 게시 위치, 카피되는 배열 요소의 수)
		Arrays.sort(res);
		return res;
	}
}
