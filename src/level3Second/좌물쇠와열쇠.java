package level3Second;
// (미완성)
public class 좌물쇠와열쇠 {
	static int N;
	static int M;
	public static void main(String[] args) {
		int key[][] = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };

		int lock[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }; 
		// lock이 key보다 더 클 수도 있음
		/*
		 int lock[][] = {{1,1,1,1}, 
		 				 {1,1,0,1}, 
		 				 {1,0,1,1}, 
		 				 {1,0,0,1}};
		*/
		
		boolean answer = false;
		N = key.length;
		M = lock.length;
		
		// lock에 패딩 붙이기 
		int lockPadded[][] = new int[M+(N-1)*2][M+(N-1)*2];
		lockPadded = makePadding(lockPadded, lock);
					
		System.out.println("=== PADDED LOCK === ");
		for (int j=0; j<lockPadded.length; j++) {
			for (int k=0; k<lockPadded.length; k++) {
				System.out.print(lockPadded[j][k]+" ");
			}
			System.out.println();
		}
		
		int rotateKey[][] = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				rotateKey[i][j] = key[i][j];
			}
		}
		
		for (int i=0; i<4; i++) {
			// key를 시계 방향으로 90도 회전
			rotateKey = rotate(rotateKey);
			
			for (int j=0; j<N; j++) {
				for (int k=0; k<N; k++) {
					System.out.print(rotateKey[j][k]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
			
			// 정답이 될 수 있는지 검사
			for (int j=0; j<lockPadded.length-N+1; j++) {
				for (int k=0; k<lockPadded.length-N+1; k++) {
					System.out.println(j+" "+k);
					answer = checkAnswer(j, k, lockPadded, rotateKey);
					if (answer) {
						System.out.println(answer);
						return ;
						//return answer;
					}
				}
			}
			
			System.out.println(answer);
			// return answer;
		}
		
		
	}
	
	// 시계 방향으로 90도 회전
	private static int[][] rotate(int[][] key) {
		int[][] rotate = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				rotate[i][j] = key[N-1-j][i];
			}
		}
		return rotate;
	}
	
	// 패딩 붙이기 
	private static int[][] makePadding(int[][] lockPadded, int[][] lock) {
		int Iidx = 0;
		int Jidx = 0;
		for (int j=M-1; j<N+(M-1); j++) {
			for (int k=M-1; k<N+(M-1); k++) {
				System.out.println("검사 = "+j+" "+k);
				lockPadded[j][k] = lock[Iidx][Jidx];
				Jidx++;
				if (Jidx == M) {
					Jidx = 0;
					Iidx++;
				}
					
			}
		}
		return lockPadded;
	}
	
	private static boolean checkAnswer(int startI, int startJ, int[][] lockPadded, int[][] key) {
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (lockPadded[startI+i][startJ+j] + key[i][j] != 1)
					return false;
			}
		}
		return true;
	}
	
}
