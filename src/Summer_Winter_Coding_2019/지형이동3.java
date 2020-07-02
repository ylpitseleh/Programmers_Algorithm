package Summer_Winter_Coding_2019;

import java.util.Arrays;
import java.util.HashMap;

public class 지형이동3 {
	static boolean visited[][];
	static int color[][];
	static int colorN = 0;
	//static int land[][] = {{1,4,8,10},{5,5,5,5},{10,10,10,10},{10,10,10,20}};
	static int[][] land = {{10,11,10,11},{2,21,20,10},{1,20,21,11},{2,1,2,1}};
	static class Pos{
        int y;
        int x;
        Pos(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static int n;
	//static int height = 3;
	static int height = 1;
	static HashMap<Integer, Integer> hm = new HashMap<>();
	
	public static void main(String[] args) {
		
		n = land[0].length;
		visited = new boolean[n][n];
		color = new int[n][n];
		
		// 색깔 칠하기
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (!visited[i][j]) {
					colorN++;
					dfs(i, j);
				}
			}
		}
		/*
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(color[i][j]+" ");
			}
			System.out.println();
		}*/
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				for (int k=0; k<4; k++) {
					if (i+dy[k] < 0 || i+dy[k] >= n || j+dx[k] < 0 || j+dx[k] >= n)
						continue ;
					if (color[i+dy[k]][j+dx[k]] != color[i][j]) {
						hm.put(color[i+dy[k]][j+dx[k]], Math.abs(land[i][j] - land[i+dy[k]][j+dx[k]]));
						System.out.println(i+" "+j);
					}
				}
			}
		}
		//System.out.println(hm);
		
	}
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		color[y][x] = colorN;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny < 0 || ny >= n || nx < 0 || nx >= n)
				continue;
			
			if (!visited[ny][nx] && Math.abs(land[ny][nx] - land[y][x]) <= height) {
				dfs(ny, nx);
				color[ny][nx] = colorN;
			}
			
			
			
		}
	}
}
