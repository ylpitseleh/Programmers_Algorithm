package level3Second;

import java.util.Arrays;
import java.util.Comparator;
/*
 * 소요 시간: 20분
 * ★☆☆☆☆, Cheating : X
 * 기초 Greedy. 
 */
public class 단속카메라 {

	public static void main(String[] args) {
		int routes[][] = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
		int answer = 1;
		
		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		
		for (int i=0; i<routes.length; i++) {
			System.out.println(routes[i][0]+" "+routes[i][1]);
		}
		
		int includeStart = routes[0][0]; // 겹치는 부분 시작점
		int includeEnd = routes[0][1]; // 겹치는 부분 끝나는점
		for (int i=1; i<routes.length; i++) {
			if (includeEnd < routes[i][0]) {
				answer++;
				includeStart = routes[i][0];
				includeEnd = routes[i][1];
				continue ;
			}
			
			includeStart = Math.max(includeStart, routes[i][0]);
			includeEnd = Math.min(includeEnd, routes[i][1]);
			System.out.println("GO "+includeStart+" "+includeEnd);
		}
		
		System.out.println(answer);
	}

}
