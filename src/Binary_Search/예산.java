package Binary_Search;

import java.util.Arrays;

public class 예산 {

	public static void main(String[] args) {	
		int budgets[] = {120, 110, 140, 150};
		int M = 485;
		
		int answer =0 ;
		
		Arrays.sort(budgets);
		
		int left = budgets[0];
		int right = budgets[budgets.length - 1];
		
		int mid = 0;
		while (left <= right) {
			long sum = 0;
			mid = (left + right) / 2;
			
			for (int budget : budgets) {
				if (budget >= mid)
					sum += mid;
				else
					sum += budget;
			}
			
			if (sum > M)
				right = mid - 1;
			else {
				answer = mid;
				left = mid + 1;
			}
		}
		
		System.out.println(answer);
		
	}

}
