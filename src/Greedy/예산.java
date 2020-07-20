package Greedy;

import java.util.Arrays;

public class 예산 {

	public static void main(String[] args) {
		//int d[] = {1, 3, 2, 5, 4};
		//int budget = 9;
		
		//int d[] = {2, 2, 3, 3};
		//int budget = 10;
		
		int answer = 0;
		
		Arrays.sort(d);
		for (int i=0; i<d.length; i++) {
			System.out.print(d[i]+" ");
		}
		
		for (int i=0; i<d.length; i++) {
			budget -= d[i];
			if (budget < 0)
				break ;
			answer++;
		}
		
		System.out.println(answer);
	}

}
