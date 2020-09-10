package level3;

import java.util.LinkedList;
import java.util.Queue;
/*
 * 소요 시간: 30분
 * ★★☆☆☆, Cheating : X
 * Pos 클래스에 이전 방문했던 값만 저장해주고 최소값 계산해주면 되는 쉬운 문제.
 * 근데 굳이 befY, befX 이렇게 저장 안 하고도 이전에 bfs클래스 안에서 for문 i값을 dir로 저장해줘도 된다. (일직선일 때 = i값이 같을 때 = 100원이니까)
 */
public class 경주로건설 {
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static class Pos {
		int y;
		int x;
		int befY; //beforeY
		int befX; //beforeX
		int cost;
		Pos (int y, int x, int befY, int befX, int cost) {
			this.y = y;
			this.x = x;
			this.befY = befY;
			this.befX = befX;
			this.cost = cost;
		}
	}
	static Queue<Pos> q = new LinkedList<>();
	static int[][] map;
	
	public static void main(String[] args) {
		//int board[][] = {{0,0,0},{0,0,0},{0,0,0}};
		//int board[][] = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		//int board[][] = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		int board[][] = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		//int board[][] = {{0, 0, 1},{1,0,0},{1,0,0}};
		//int board[][] = {{0,1,0,0,0,1},{0,1,0,1,0,1},{0,0,0,1,0,1},{1,1,1,1,0,0}};
		//int board[][] = {{0,0,1},{1,0,0},{1,1,0}};
		int answer = 0;
		
		map = new int[board.length][board[0].length];
		bfs(0, 0, board);
		
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[0].length; j++) {
				System.out.printf("%4d ", map[i][j]);
			}
			System.out.println();
		}
		answer = map[map.length-1][map[0].length-1];
		System.out.println("answer : "+answer);
	}
	
	private static void bfs(int y, int x, int board[][]) {
		q.add(new Pos(y, x, 0, 0, 0));
		
		while (!q.isEmpty()) {
			Pos p = q.poll();
			
			for (int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if (ny < 0 || ny >= map.length || nx < 0 || nx >= map[0].length)
					continue ;
				if (board[ny][nx] == 1)
					continue ;
				int nextCost = 100;
				if ((p.befY+1 == ny && p.befX+1 == nx) || (p.befY-1 == ny && p.befX+1 == nx) 
						|| (p.befY+1 == ny && p.befX-1 == nx) || (p.befY-1 == ny && p.befX-1 == nx))
					nextCost += 500;
				if (map[ny][nx] != 0 && map[ny][nx] < p.cost + nextCost)
					continue ;
				
				q.add(new Pos(ny, nx, p.y, p.x, p.cost + nextCost));
				map[ny][nx] = p.cost + nextCost;
			}
		}
	}

}
