package DFS_BFS;
//visited는 일차원 배열로 해도 됐었다.
public class 네트워크2 {

	public static void main(String[] args) {
		//int computers[][] = {{1,1,0}, {1,1,0}, {0,0,1}};
		int n = 3;
		int computers[][] = {{1,1,0}, {1,1,1}, {0,1,1}};
		int answer = 0;

		boolean visited[][] = new boolean[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (computers[i][j] == 1 && !visited[i][j]) {
					dfs(computers, i, visited, n);
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
	public static void dfs(int[][] computers, int idx, boolean[][] visited, int n) {
		for (int i=0; i<n; i++) {
			if (computers[idx][i] == 1 && !visited[idx][i]) {
				visited[idx][i] = visited[i][idx] = true;
				dfs(computers, i, visited, n);
			}
		}
	}

}
