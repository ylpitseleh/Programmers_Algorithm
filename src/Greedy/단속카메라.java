package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
	
	public static void main(String[] args) {
		int routes[][] = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
		int answer = 1;
		
		Arrays.sort(routes, new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return Integer.compare(o1[1], o2[1]);
				return Integer.compare(o1[0], o2[0]);
			}
		});
		int cur = routes[0][1];
		
		for (int i=1; i<routes.length-1; i++) {
			if (routes[i][1] < cur)
				cur = routes[i][1];
			
			if (cur < routes[i+1][0]) {
				answer++;
				cur = routes[i+1][1];
			}
		}
		System.out.println(answer);
		
	}

}
