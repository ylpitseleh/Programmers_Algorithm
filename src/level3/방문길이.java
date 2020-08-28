package level3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
/*
 * 소요 시간: 3시간
 * ★★★☆☆, Cheating : O
 * 다른 사람들 코드에서 4차원 배열 쓰는 이유 : 1, 2차원 지점에서 3, 4차원 지점으로 이동했다는 것을 기록하기 위해.
 * 4차원 배열을 나는 용납할 수 없다. 내장 class를 새로 만들어서 그냥 ArrayList에 넣는다.  
 * 남 코드 보니까 HashSet에 그냥 String으로 "sy sx ey ex" 이렇게 저장해도 된다. 왜 이런 생각을 못하지?
 * 처음에 Queue로 bfs처럼 난리치고 값을 시작 지점에 저장할지 도착 지점에 저장할지 엄청 고민하면서 뻘짓하다가
 * 양쪽에 다 저장해야한다는걸 남의 코드 검색해보고 알았다. 멍청한 나.
 * 그리고 객체 값 비교할 때 contains했다가 안 돼서 equals 다 안 됐다. => 객체 필드가 한 개일때만 되는듯? 여러개면 Comparator나 compareTo를 써야한다 !!!
 */
public class 방문길이 {
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, 1, -1};
	static int map[][] = new int[11][11];
	static ArrayList<Pos> al = new ArrayList<>();
	static class Pos {
		int sy;
		int sx;
		int ey;
		int ex;
		Pos (int sy, int sx, int ey, int ex) {
			this.sy = sy;
			this.sx = sx;
			this.ey = ey;
			this.ex = ex;
		}
	}
	static class PosComparator implements Comparator<Pos> {
		  @Override
		  public int compare(Pos p1, Pos p2) {
		   if(p1.sy == p2.sy && p1.sx == p2.sx && p1.ey == p2.ey && p1.ex == p2.ex) 
			   return 1;
		   else 
			   return 0;
		  }
	 }
	
	public static void main(String[] args) {
		String dirs = "ULURRDLLU";
		//String dirs = "LULLLLLLU";
		//String dirs = "LRDULRDU"; //왼 오 아래 위 x2
		//String dirs = "LLRRLLRR";
		//String dirs = "LLLLLLLL";
		//String dirs = "LURDLURD"; // 왼 위 오 아래 x2
		int answer = 0;
		
		int ny = 5; int nx = 5; // 시작 지점
		int beforeY = 0; int beforeX = 0;
		
		//U:0, D:1, R:2; L:3
		int idx = -1;
		for (int i=0; i<dirs.length(); i++) {
			beforeY = ny;
			beforeX = nx;
			
			if (dirs.charAt(i) == 'U')
				idx = 0;
			else if (dirs.charAt(i) == 'D')
				idx = 1;
			else if (dirs.charAt(i) == 'R')
				idx = 2;
			else if (dirs.charAt(i) == 'L')
				idx = 3;
			
			ny = beforeY + dy[idx];
			nx = beforeX + dx[idx];
			
			if (ny < 0 || ny >= 11 || nx < 0 || nx >= 11) {
				ny -= dy[idx];
				nx -= dx[idx];
				continue ;
			}
			
			// (0,0)에서 (1,0) = (1,0)에서 (0,0)과 같다. 
			// 여기서 !al.contains(new Pos(beforeY, beforeX, ny, nx))를 쓰면 주소값 비교를 해버리는 것 같다. 
			boolean answerFlag = true;
			for (int j=0; j<al.size(); j++) {
				if (Objects.compare(al.get(j), new Pos(ny, nx, beforeY, beforeX), new PosComparator()) == 1 || 
						Objects.compare(al.get(j), new Pos(beforeY, beforeX, ny, nx), new PosComparator()) == 1) {
					//Pos p = al.get(j);
					//System.out.println("same = "+p.sy+" "+p.sx+" "+p.ey+" "+p.ex);
					answerFlag = false;
					break ;
				}
			}
			
			if (answerFlag) {
				al.add(new Pos(beforeY, beforeX, ny, nx));
				al.add(new Pos(ny, nx, beforeY, beforeX));
				answer++;
			}
			
			for (int j=0; j<al.size(); j++) {
				Pos p = al.get(j);
				System.out.print(p.sy+" "+p.sx+" "+p.ey+" "+p.ex+" / ");
			}
			System.out.println();
		}
		
		System.out.println(answer);
	}

}
