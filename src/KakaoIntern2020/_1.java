package KakaoIntern2020;

import java.util.LinkedList;
import java.util.Queue;

public class _1 {
	static Queue q = new LinkedList<Pos>();
	static boolean[][] visited;
	static int dy[] = {0, 0, -1, 1};
	static int dx[] = {-1, 1, 0, 0};
	static class Pos {
		int y;
		int x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) {
		//int numbers[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		//int numbers[] = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		
		//String hand = "right";
		//String hand = "left";
		String hand = "right";
		String answer = "";
		
		int L = 0;
		int R = 0;
		int pos[][] = {{1,2,3}, {4,5,6}, {7,8,9}, {0,0,0}};
		boolean visited[][] = new boolean[4][3];
		int map[][] = new int[4][3];
		Pos pl = new Pos(3,0);
		Pos pr = new Pos(3, 2);
		int N = numbers.length;
		for (int i=0; i<N; i++) {
			map = new int[4][3];
			visited = new boolean[4][3];
			
			Pos pCur = findNum(numbers[i]);
			q.add(new Pos(pCur.y, pCur.x));
			visited[pCur.y][pCur.x] = true;
			
			while (!q.isEmpty()) {
				Pos p = (Pos) q.poll();
				for (int j=0; j<4; j++) {
					int ny = p.y + dy[j];
					int nx = p.x + dx[j];
					//System.out.println(ny+" "+nx);
					if (ny < 0 || ny >= 4 || nx < 0 || nx >= 3)
						continue ;
					//System.out.println(ny+" "+nx);
					if (visited[ny][nx] == true || map[ny][nx] > 0)
						continue ;
					map[ny][nx] = map[p.y][p.x] + 1;
					q.add(new Pos(ny, nx));
					visited[ny][nx] = true;
				}
			}
			/*
			for (int j=0; j<4; j++) {
				for (int k=0; k<3; k++) {
					System.out.print(map[j][k]+" ");
				}
			System.out.println();
			}
			System.out.println();
			*/
			System.out.println(numbers[i]);
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				answer += 'L';
				L = numbers[i];
				pl = findNum(L);
			}
			else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer += 'R';
				R = numbers[i];
				pr = findNum(R);
			}
			else { // 2 5 8 0
				
				if (map[pl.y][pl.x] < map[pr.y][pr.x] ) {
					answer += 'L';
					L = numbers[i];
					pl = findNum(L);
				}
				else if (map[pl.y][pl.x] > map[pr.y][pr.x]) {
					answer += 'R';
					R = numbers[i];
					pr = findNum(R);
				}
				else { // 같으면
					if (hand.equals("right")) {
						answer += 'R';
						R = numbers[i];
						pr = findNum(R);
					}
					else if (hand.equals("left")) {
						answer += 'L';
						L = numbers[i];
						pl = findNum(L);
					}
				}
				
			}
		}
		System.out.println(answer);
		
		
	}
	public static Pos findNum(int n) {
		int y = 0, x = 0;
		if (n == 1) {
			y = 0;
			x = 0;
		}
		if (n == 2) {
			y = 0;
			x = 1;
		}
		if (n == 3) {
			y = 0;
			x = 2;
		}
		if (n == 4) {
			y = 1;
			x = 0;
		}
		if (n == 5) {
			y = 1;
			x = 1;
		}
		if (n == 6) {
			y = 1;
			x = 2;
		}
		if (n == 7) {
			y = 2;
			x = 0;
		}
		if (n == 8) {
			y = 2;
			x = 1;
		}
		if (n == 9) {
			y = 2;
			x = 2;
		}
		if (n == 0) {
			y = 3;
			x = 1;
		}
		return new Pos(y, x);
	}

}
