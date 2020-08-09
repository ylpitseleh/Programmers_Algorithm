package level2;
/*
 * 소요 시간: 20분
 * ☆☆☆☆☆, Cheating : X
 * 기초 DP 문제. 프로그래머스 레벨2 난이도도 진짜 중구난방이구나 싶다.
 */
public class 땅따먹기 {

	public static void main(String[] args) {
		int[][] land = {{1,2,3,5},
						{5,6,7,8},
						{4,3,2,1}};
		
		int answer = 0;
		
		int[][] dp = new int[land.length][4];
		dp[0] = land[0];
		for (int i=1; i<dp.length; i++)	{
			
			for (int j=0; j<4; j++) {
				int max = 0;
				for (int k=0; k<4; k++) {
					if (j==k)
						continue ;
					max = Math.max(max, dp[i-1][k]);
				}
				System.out.println(max+" "+land[i][j]);
				dp[i][j] = max + land[i][j];
			}
		}
		
		for (int i=0; i<dp.length; i++) {
			for (int j=0; j<4; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
