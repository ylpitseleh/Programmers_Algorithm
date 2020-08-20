package level3;
/*
 * 소요 시간: 15분
 * ★☆☆☆☆, Cheating : X
 */
public class 정수삼각형 {

	public static void main(String[] args) {
		int[][] triangle = {{7},{3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		int answer = 0;
		
		int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
		
		dp[0][0] = triangle[0][0];
		for (int i=1; i<triangle.length; i++) {
			for (int j=0; j<triangle[i].length; j++) {
				if (j == 0) 
					dp[i][j] = triangle[i][j] + dp[i-1][j];
				else if (j == triangle[i].length-1)
					dp[i][j] = triangle[i][j] + dp[i-1][j-1];
				else
					dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
		}
		/*
		System.out.println();
		for (int i=0; i<triangle.length; i++) {
			for (int j=0; j<triangle[triangle.length-1].length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		*/
		for (int i=0; i<triangle[triangle.length-1].length; i++)
			answer = Math.max(answer, dp[triangle.length-1][i]);
		System.out.println(answer);
	}

}
