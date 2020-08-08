package level2;
/*
 * 소요 시간: 50분
 * ★★★☆☆, Cheating : O
 * DP문제. 브루트포스로 풀었다가 효율성 시간초과나서 풀이 봤다. 
 * 쉬운 DP였는데 역시나 이 방법을 떠올리기가 쉽지 않다. 
 */
public class 가장큰정사각형찾기 {

	public static void main(String[] args) {
		/*
		int[][] board = {{0,1,1,1}, 
						 {1,1,1,1}, 
					 	 {1,1,1,1}, 
						 {0,0,1,0}};
		*/
		/*
		int[][] board = {{0,0,1,1}, 
						{1,1,1,1}};
		*/
		int[][] board = {{0}};
		int answer = board[0][0];
		
		int h = board.length;
		int w = board[0].length;
		/* <브루트포스> 
		// 정사각형의 최대 크기 : h, w 중 더 작은 값
		for (int i=Math.min(h, w); i>=0; i--) { // 정사각형의 한 변의 길이
			//System.out.println("i = "+i);
			for (int j=0; j<=h-i; j++) {
				for (int k=0; k<=w-i; k++) {
					System.out.println(j+" "+k);
					boolean trueFlag = true;
					for (int l=j; l<i+j; l++) {
						for (int m=k; m<i+k; m++) {
							if (board[l][m] == 0) {
								trueFlag = false;
								break;
							}
						}
					}
					if (trueFlag) {
						answer = i*i;
						System.out.println(answer);
						return ;
					}
				}
			}
			System.out.println();
		}
		*/
		//int map[][] = new int[h][w];
		
		for (int i=1; i<h; i++) {
			for (int j=1; j<w; j++) {
				if (board[i][j] != 0) {
					// 왼쪽, 위쪽, 왼쪽위대각선 중 최소값 + 1
					board[i][j] = 1 + Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]);
					answer = Math.max(answer, board[i][j]);
				}
			}
		}
		System.out.println(answer * answer);
		/*
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		*/
		
	}

}
