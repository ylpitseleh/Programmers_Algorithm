package KakaoIntern2020;

import java.util.PriorityQueue;

public class _4 {
	//static Queue q = new LinkedList<Pos>();
	static PriorityQueue<Pos> pq = new PriorityQueue();
	//static boolean[][] visited;
	static int[][] map;
	static int dy[] = {0, 0, -1, 1};
	static int dx[] = {-1, 1, 0, 0};
	static class Pos implements Comparable<Pos>{
		int y;
		int x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		 @Override
		    public int compareTo(Pos p) {
		        return this.y == p.y  && this.x == p.x ? 1 : - 1;
		    }
	}
	
	public static void main(String[] args) {
		//int board[][] = {{0,0,0},{0,0,0},{0,0,0}};
		//int board[][] = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		//int board[][] = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		int board[][] = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		int answer = 0;
		
		int N = board.length;		
		//visited = new boolean[N][N];
		map = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(board[i][j]);
				map[i][j] = 25 * 25 + 1;
				if (board[i][j] == 1)
					map[i][j] = -1;
			}
			System.out.println();
		}
		
		pq.add(new Pos(0, 0));
		//visited[0][0] = true;
		map[0][0] = 0;
		while (!pq.isEmpty()) {
			Pos p = (Pos) pq.poll();
			
			for (int j=0; j<4; j++) {
				int ny = p.y + dy[j];
				int nx = p.x + dx[j];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N)
					continue ;
				if (map[ny][nx] == -1)
					continue ;
				if (map[ny][nx] < map[p.y][p.x] + 1)
					continue ;
				map[ny][nx] = map[p.y][p.x] + 1;
				pq.add(new Pos(ny, nx));
				//visited[ny][nx] = true;
			}
		}
		
		System.out.println();
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}

}
