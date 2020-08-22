package level3;

import java.util.Arrays;

/*
 * 소요 시간: 1시간 30분
 * ★★★★☆, Cheating : O
 * DFS로 풀었다가 테케 거의 다 틀려서 보니까 플로이드 와샬 알고리즘을 써야 하는 문제였다. 
 * 플로이드 와샬 뭔지 대략 알긴 하겠는데 100% 이해되는건 아니고 까먹지 않게 나중에 다시 풀어봐야 할듯?
 */
public class re순위 {

	public static void main(String[] args) {
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		int n = 5;
		//int[][] results = {{1, 2}, {2, 3}, {3, 4}, {5, 6}, {6, 7}, {7, 8}};
		//int n = 8;
		//int[][] results = {{1, 2}, {3, 4}};
		//int n = 4;
		
		int answer = 0;

		int INF = 987654321;
		
		int[][] map = new int[n+1][n+1];
		
		// map 최대값으로 채우기
		for (int i=1; i<n+1; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0; // 대각선은 0 (자기 자신)
		}
		// input은 1 넣어주기
		for (int i=0; i<results.length; i++) {
			map[results[i][0]][results[i][1]] = 1;
		}
		// 최단경로 저장 (플로이드 와샬 알고리즘. 여기만 이해하면 됨. )
		for (int k=1; k<n+1; k++) {
			for (int i=1; i<n+1; i++) {
				for (int j=1; j<n+1; j++) { // k 지점을 들렸다가 가는거랑 비교 
					if (map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
		for (int i=1; i<n+1; i++) {
			for (int j=1; j<n+1; j++) {
				System.out.printf("%10d", map[i][j]);
			}
			System.out.println();
			
		}
		
		// 답 찾기
		for (int i=1; i<n+1; i++) {
			boolean answerFlag = true;
			for (int j=1; j<n+1; j++) { 
				if (i!=j && map[i][j] == INF && map[j][i] == INF) { //i와 j가 게임하지 않았으면
					answerFlag = false;
					break ;
				}
			}
			if (answerFlag) answer++;
		}
		
		System.out.println(answer);
		
	}


}
