package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 소요 시간: 1시간 20분
 * ★☆☆☆☆, Cheating : X
 * 개쉬운 기초 DFS, BFS문제. DFS로 풀면 시간초과인지 메모리초과인지 난다고 함. 
 * 테케는 맞는데 제출하면 틀렸다고 나와서 찾아보니까 전역변수 main 안에서 초기화시켜야 한다고해서 그렇게 함. 개같은 문제. 찾느라 시간 날림.
 */
public class 카카오프렌즈컬러링북 {
	static class Pos {
		int y;
		int x;
		
		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int dy[];
	static int dx[];
	static boolean visited[][];
	static int h, w, cntColor = 0, cntSize = 0;
	
	public static void main(String[] args) {
		
		int[][] picture = 
				{{1, 1, 1, 0}, 
				{1, 2, 2, 0}, 
				{1, 0, 0, 1}, 
				{0, 0, 0, 1}, 
				{0, 0, 0, 3}, 
				{0, 0, 0, 3}};
		int m = 6; // 세로
		int n = 4; // 가로
		dy = new int[]{-1,1,0,0};
		dx = new int[]{0,0,-1,1};
		
		h = m;
		w = n;
		visited = new boolean[m][n];
		
		for (int i=0; i<m; i++) {
			Arrays.fill(visited, false);
		}
		
		int maxSize = 0;
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (picture[i][j] != 0 && !visited[i][j]) {
					cntColor++;
					cntSize = 1;
					bfs(picture, i, j);
					maxSize = Math.max(maxSize, cntSize);
					//System.out.println(cntSize+" "+cntColor);
				}
			}
		}
		System.out.println(maxSize+" "+cntColor);
		
	}
	
	private static void bfs(int[][] map, int y, int x) {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(y, x));
		visited[y][x] = true;
		
		while (!q.isEmpty()) {
			Pos p = q.poll();
			
			for (int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if (ny < 0 || ny >= h || nx < 0 || nx >= w)
					continue ;
				if (visited[ny][nx])
					continue ;
				if (map[ny][nx] != map[p.y][p.x])
					continue;
				
				cntSize++;
				q.add(new Pos(ny, nx));
				visited[ny][nx] = true;
				
			}
			
		}
		
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
	}
}
