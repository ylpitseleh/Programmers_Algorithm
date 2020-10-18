package level3Second;
/*
 * 소요 시간: 20분
 * ★☆☆☆☆, Cheating : X
 * 아주 기초 dfs 문제. 
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
					System.out.println(i+" "+j);
					answer++;
					dfs(i, computers, visited, n);
				}
			}
		}
		
		System.out.println(answer);
		
		
	}
	
	private static void dfs (int idx, int computers[][], boolean[] visited, int n) {
		for (int i=0; i<n; i++) {
			if (computers[idx][i] == 1 && !visited[i]) {
				System.out.println("연결된다 "+idx+" "+i);
				visited[i] = true;
				dfs (i, computers, visited, n);
			}
		}
	}
}
