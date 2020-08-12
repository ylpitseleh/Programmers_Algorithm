package level2;
/*
 * 소요 시간: 25분
 * ★☆☆☆☆, Cheating : X
 * dp로 풀었는데 효율성 초과나서 풀이 보니까 그냥 연산문제였당. 백준 숨바꼭질같은거여서 dp로 했는뎅...
 * 역시 이번에도 그렇고 인풋 10억처럼 엄청크면 dp하던가 연산으로 풀어야함.
 */
public class 점프와순간이동 {

	public static void main(String[] args) {
		//int n = 5;
		 //int n = 6;
		 int n = 5000;
		
		int answer = 0;
		/*
		int dp[] = new int[n+1];
		
		dp[1] = 1;
		for (int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + 1;
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i/2]);
		}
		
		for (int i=1; i<=n; i++) {
			//System.out.print(dp[i]+" ");
		}
		System.out.println(dp[n]);
		*/
		
		while (n > 0) {
			if (n % 2 == 0) {
				n /= 2;
			}
			else {
				n--;
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
