package level3;

import java.util.Arrays;

public class 거스름돈 {

	public static void main(String[] args) {
		int money[] = {1, 2, 5};
		int n = 5;
		
		int answer = 0;
		
		int[] dp = new int[n+1];
		Arrays.parallelSort(money);
		
		dp[0] = 1;
		for (int i=0; i<money.length; i++) {
			for (int j=money[i]; j<=n; j++) {
				System.out.println(i+" "+j+" "+(j-money[i]));
				dp[j] += dp[j-money[i]];
			}
		}

		answer = dp[n] % 1000000007;
	}

}
