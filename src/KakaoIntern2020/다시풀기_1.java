package KakaoIntern2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 다시풀기_1 {
	static int[][] phone = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
	static int[][] map;
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
		
		int left = -1;
		int right = -1;
		for (int i=0; i<numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7)
				left = numbers[i];
			else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9)
				right = numbers[i];
			else { // 2, 5, 8, 0일 때
				int leftDist = bfs(left, numbers[i]);
				int rightDist = bfs(right, numbers[i]);
				
				left = leftDist < rightDist? numbers[i] : left;
				right = rightDist < leftDist? numbers[i] : right;
				if (leftDist == rightDist) {
					if (hand.equals("right"))
						right = numbers[i];
					else
						left = numbers[i];
				}
			}
			if (left == numbers[i])
				answer += 'L';
			else if (right == numbers[i])
				answer += 'R';
				
		}
		//return answer;
	}
	
	public static int bfs (int n1, int n2) {
		Queue<Pos> q = new LinkedList<Pos>();
		int dist = 0;
		map = new int[4][3];
		Pos start = getArrIndex(n1);
		Pos end = getArrIndex(n2);
		q.add(new Pos(start.y, start.x));
		for (int i=0; i<4; i++)
			Arrays.fill(map[i], 10);
		map[start.y][start.x] = 0;
		
		while (!q.isEmpty()) {
			Pos p = q.poll();
			
			if (p.y == end.y && p.x == end.x) {
				dist = map[p.y][p.x];
				break ;
			}
			for (int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if (ny < 0 || ny >= 4 || nx < 0 || nx >= 3)
					continue ;
				if (map[p.y][p.x] + 1 > map[ny][nx])
					continue ;
				map[ny][nx] = map[p.y][p.x] + 1;
				q.add(new Pos(ny, nx));
			}
		}
		return dist;
	}
	
	public static Pos getArrIndex (int n) {
		Pos p = new Pos(0, 0);
		for (int i=0; i<4; i++) {
			for (int j=0; j<3; j++) {
				if (phone[i][j] == n) {
					p.y = i;
					p.x = j;
				}
			}
		}
		return p;
	}
		
}
