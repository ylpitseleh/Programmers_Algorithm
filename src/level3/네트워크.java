package level3;
/*
 * 소요 시간: 40분
 * ★☆☆☆☆, Cheating : X
 * dfs 진심 오랜만에 풀었더니 이 기초를 푸는데 40분이나 걸렸다. 옛날에는 보니까 visited 2차원배열로 풀었던데
 * 일차원으로 최적화 성공쿠. 렙3 풀면서 dfs 정복하는게 목표.
 */
public class 네트워크 {

	public static void main(String[] args) {
		/*
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int n = 3;
		*/
		
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		int n = 3;
		
		int answer = 0;
		
		boolean[] visited = new boolean[n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (computers[i][j] == 1 && !visited[i]) {
					visited[i] = true;
					dfs(j, visited, computers);
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
	
	private static void dfs(int x, boolean[] visited, int[][] computers) {
		visited[x] = true;
		//System.out.println("dfs 내부 x = "+x);
		for (int i=0; i<visited.length; i++) {
			if (computers[x][i] == 1 && !visited[i]) {
				dfs(i, visited, computers);
			}
		}
	}

}
