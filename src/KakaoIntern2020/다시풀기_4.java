package KakaoIntern2020;

import java.util.LinkedList;
import java.util.Queue;
// 원래 Pos 객체에 cost를 안 만들고 그냥 map에다가 최소값 갱신하는 식으로 했는데 테케가 몇 개가 자꾸 틀려서
// 결국 왜 그런지 못 알아내고 객체에 cost 추가하고 성공했다. 아직도 의문이다. 
public class 다시풀기_4 {
		static Queue<Pos> q = new LinkedList<Pos>();
		static int n;
		static int[][] map;
		static int dy[] = {0, 0, -1, 1};
		static int dx[] = {-1, 1, 0, 0};
		static class Pos{
			int y;
			int x;
			int cost;
			int dir;

			Pos(int y, int x, int cost, int dir) {
				this.y = y;
				this.x = x;
				this.cost = cost;
				this.dir = dir;
			}
		}

	public static void main(String[] args) {
		//int board[][] = {{0,0,0},{0,0,0},{0,0,0}};
		//int board[][] = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		//int board[][] = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		int board[][] = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		//int board[][] = {{0, 0, 1},{1,0,0},{1,0,0}};
		//int board[][] = {{0,1,0,0,0,1},{0,1,0,1,0,1},{0,0,0,1,0,1},{1,1,1,1,0,0}};
		//int board[][] = {{0,0,1},{1,0,0},{1,1,0}};
		int answer = 0;
		
		n = board.length;
		map = new int[n][n];
		answer = bfs(board, Integer.MAX_VALUE);
		System.out.println(answer);
	}
	
	public static int bfs(int[][] board, int answer) {
		initialize();
		map[0][0] = 0;
		q.add(new Pos(0, 0, 0, -1));
		
		while (!q.isEmpty()) {
			Pos p = q.poll();
			
			if (p.y == n-1 && p.x == n-1) {
				answer = Math.min(answer, map[n-1][n-1]);
			}
			for (int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if (ny < 0 || ny >= n || nx < 0 || nx >= n)
					continue ;
				
				if (board[ny][nx] == 1)
					continue ;
				/*
				if ((p.dir == 0 || p.dir == 1) && (i == 2 || i == 3)) {
					pricePlus += 500;
				}
				else if ((p.dir == 2 || p.dir == 3) && (i == 0 || i == 1)) {
					pricePlus += 500;
				}*/
				// 같은 방향이 아니고 시작 지점이 아니면 + 500
				/*
				int pricePlus = 100;
				if (p.dir != i && p.dir != -1)
					pricePlus += 500;
				*/
				int nCost = p.cost + 100;
				// → ← 이렇게 갈 일은 없으니까 그냥 같은 방향만 100원 추가, 다른 방향이면 500원 추가로 하면 됨.
				if (p.dir != i && p.dir != -1)
					nCost += 500;
				
				if (map[ny][nx] < nCost)
					continue ;
				
				map[ny][nx] = nCost;
				q.add(new Pos(ny, nx, nCost, i));
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.printf("%12d", map[i][j]);
			}
			System.out.println();
		}
		return answer;
	}
	
	public static void initialize() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.MAX_VALUE;
			}
		}
	}

}
