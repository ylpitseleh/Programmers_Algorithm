package level3Second;

public class 방문길이 {

	public static void main(String[] args) {
		String dirs = "ULURRDLLU";
		//String dirs = "LULLLLLLU";
		//String dirs = "LRDULRDU"; //왼 오 아래 위 x2
		//String dirs = "LLRRLLRR";
		//String dirs = "LLLLLLLL";
		//String dirs = "LURDLURD"; // 왼 위 오 아래 x2
		int answer = 0;
		
		int[][] map = new int[11][11];
		
		int nowY = 5;
		int nowX = 5;
		map[nowY][nowX] = 1;
		for (int i=0; i<dirs.length(); i++) {
			for (int j=0; j<11; j++) {
				for (int k=0; k<11; k++) {
					System.out.print(map[j][k]+" ");
				}
				System.out.println();
			}
			System.out.println();
			char c = dirs.charAt(i);
			int moveY = 0, moveX = 0;
			if (c == 'U') {
				moveY = -1;
			}
			else if (c == 'D') {
				moveY = 1;
			}
			else if (c == 'R') {
				moveX = 1;
			}
			else if (c == 'L') {
				moveX = -1;
			}
			if (map[nowY+moveY][nowX+moveX] == 0)
				answer++;
			map[nowY+moveY][nowX+moveX]++;
			nowY = nowY + moveY;
			nowX = nowX + moveX;
		}
		
		System.out.println("ANSWER = "+answer);
	}

}
