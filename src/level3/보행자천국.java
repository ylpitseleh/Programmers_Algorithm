package level3;
/*
 * 소요 시간: 1시간 30분
 * ★★★★☆, Cheating : O
 * 테케 틀려서 보니까 내가 푼 로직이랑 거의 똑같은데 dp 이차원배열을 두개를 썼다. 난 한 개에 다 쑤셔넣으려고 했다. 
 * 왜 굳이 두 개로 나눠서 해야하는건지 이해가 잘 안 된다. 나중에 다시 보기.  
 */
public class 보행자천국 {
	static int MOD = 20170805;
	
	public static void main(String[] args) {
		/*
		int cityMap[][] = {{0,0,0}, {0,0,0}, {0,0,0}};
		int m = 3;
		int n = 3;
		*/
		/*
		int cityMap[][] = {{0,2,0,0,0,2}, {0,0,2,0,1,0}, {1,0,0,2,2,0}};
		int m = 3;
		int n = 6;
		*/
		
		int cityMap[][] = {{0,0,0,1}, {0,0,2,0}, {0,0,0,0}, {1,0,0,0}, {0,2,0,0}};
		int m = 5;
		int n = 4;
		
		int answer = 0;
		
		int rightMap[][] = new int[m+1][n+1];
		int downMap[][] = new int[m+1][n+1];
		
		rightMap[1][1] = 1; // 시작점 
		downMap[1][1] = 1; 
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (cityMap[i-1][j-1] == 1) {
					continue ;
				}
				else if (cityMap[i-1][j-1] == 2 ) {
					downMap[i][j] = downMap[i-1][j];
					rightMap[i][j] = rightMap[i][j-1];
				}
				else if (cityMap[i-1][j-1] == 0) {
					rightMap[i][j] += (downMap[i-1][j] + rightMap[i][j-1]) % MOD;
					downMap[i][j] += (downMap[i-1][j] + rightMap[i][j-1]) % MOD;
				}
			}
		}
		
		answer = (rightMap[m][n-1] + downMap[m-1][n]) % MOD;
		System.out.println(answer);
	}

}
