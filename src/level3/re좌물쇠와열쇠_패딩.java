package level3;
/*
 * 소요 시간: 3시간
 * ★★★★★, Cheating : O
 * 패딩 만드는게 정말 신개념.. 진짜 좋은 문제고 좋은 풀이다. 나중에 꼭 복습하자.
 * 
 * https://leveloper.tistory.com/27
 */
public class re좌물쇠와열쇠_패딩 {
	static class Pos {
		int y;
		int x;
		Pos (int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int N, M;
	static int[][] paddingLock;
	
	public static void main(String[] args) {
		int key[][] =  {{0,0,0}, 
						{1,0,0}, 
						{0,1,1}};
		
		int lock[][] = {{1,1,1}, 
						{1,1,0}, 
						{1,0,1}}; // lock이 key보다 더 클 수도 있음 
		
		/*
		int lock[][] = {{1,1,1,1}, 
						{1,1,0,1}, 
						{1,0,1,1},
						{1,0,0,1}};
		*/
		
		boolean answer = false;
		N = key.length;
		M = lock.length;
		paddingLock = paddingLock(lock);
		
		for (int i=0; i<paddingLock.length; i++) {
			for (int j=0; j<paddingLock.length; j++) {
				System.out.print(paddingLock[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();

		// 회전시키면서 맞는 곳 있는지 비교
		for (int rotateIdx=0; rotateIdx<4; rotateIdx++) {
			
			// ---------------- 핵심 로직 ----------------------
			for (int x=0; x<paddingLock.length - (N-1); x++) {
				for (int y=0; y<paddingLock.length - (N-1); y++) {
					paddingLock = paddingLock(lock); //padding 초기화
					
					for (int i=0; i<N; i++) {
						for (int j=0; j<N; j++) {
							paddingLock[x+i][y+j] += key[i][j];
						}
					}
					
					for (int i=0; i<paddingLock.length; i++) {
						for (int j=0; j<paddingLock.length; j++) {
							System.out.print(paddingLock[i][j]+" ");
						}
						System.out.println();
					}
					System.out.println();
					if (isFinish()) {
						System.out.println("정답입니다!!!!!!!!!!!!!!");
						answer = true;
						//return true;
					}
				}
			}
			// -----------------------------------------------
			
			key = rotateKey(key);
		}
		
		System.out.println(answer);
		
	}
	// key를 오른쪽으로 90도 회전
	private static int[][] rotateKey (int[][] key) {
		int[][] rotate = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				rotate[i][j] = key[N-1-j][i];
			}
		}
		return rotate;
	}
	// paddingLock배열 = padding + lock
	private static int[][] paddingLock(int[][] lock) {
		int len = M + (2*N-2);
		int[][] res = new int[len][len];
		
		for (int i=0; i<len; i++) {
			for (int j=0; j<len; j++) {
				res[i][j] = 0; // 0으로 초기화하고 
			}
		}
		for (int i=0; i<M; i++) {
			for (int j=0; j<M; j++) {
				res[i+(N-1)][j+(N-1)] = lock[i][j]; // lock부분을 추가해준다. 
			}
		}
		return res;
	}
	// 답이 맞는지 확인 (paddingLock에서 padding제외한 부분(lock 부분)이 모두 1이면 종료. key의 1값과 lock의 0값이 더해지면 1이니까) 
	private static boolean isFinish() {
		for (int i=N-1; i<M+(N-1); i++) {
			for (int j=N-1; j<M+(N-1); j++) {
				if (paddingLock[i][j] != 1)
					return false;
			}
		}
		return true;
	}

	
}
