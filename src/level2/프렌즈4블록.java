package level2;
/*
 * 소요 시간: 2시간 15분
 * ★★★☆☆, Cheating : O(테케)
 * 아 뭔가 나레기 이거 풀 수 있을까 걱정하다가 결국 풀었는데 테케 2개가 틀려서 프로그래머스 질문 올라온거 보고 고쳤다.
 * 이런걸 빨리 풀어야 실전 코테 합격가능성이 높아지는건데.. 이런류 연습을 많이해야 할 것같다.
 * 뭔가 쉬운것같으면서도 고려할게 꽤 있는 쉬우면서 짜증나는 문제들... 
 */
public class 프렌즈4블록 {
	static int answer = 0;

	public static void main(String[] args) {
		/*
		String board[] = {  "CCBDE", 
							"AAADE", 
							"AAABF", 
							"CCBBF" };
		int m = 4; // h
		int n = 5; // w
		*/
		/*
		String board[] = {  "TTTANT", 
							"RRFACC", 
							"RRRFCC", 
							"TRRRAA", 
							"TTMMMF",
							"TMMTTJ"};
		int m = 6; int n = 6;
		*/
		String board[] = 
		{"HGNHU", 
		 "CRSHV", 
		 "UKHVL", 
		 "MJHQB", 
		 "GSHOT", 
		 "MQMJJ", 
		 "AGJKK", 
		 "QULKK"};
		int m = 8; // h
		int n = 5; // w

		//int answer = 0;
		char boardChar[][] = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boardChar[i][j] = board[i].charAt(j);
			}
		}


		while (true) {
			boolean removeFlag = false; // 지워질 블록 있으면 true
			
			// 지울 블록을  check[][]에 true로 저장해둔다.
			boolean check[][] = new boolean[m][n];
			/*
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(boardChar[i][j] + " ");
				}
				System.out.println();
			}
			*/
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					char compare = boardChar[i][j];
					if (compare == '0')
						continue ;
					if (boardChar[i + 1][j] == compare && boardChar[i][j + 1] == compare && boardChar[i + 1][j + 1] == compare) {
						removeFlag = true;
						check[i][j] = check[i + 1][j] = check[i][j + 1] = check[i + 1][j + 1] = true;
					}
				}
			}
			
			countTrue(check); // check[][] == true인 것들 answer++ 해주기
			
			if (!removeFlag) {
				break ;
			}
			// 블록이 지워진 후에 위에 있는 블록을 아래로 떨어뜨린다.
			boardChar = drop(boardChar, check); 
		
		}
		
		System.out.println(answer);

	}
	
	private static char[][] drop(char[][] boardChar, boolean[][] check) {
		int h = boardChar.length;
		int w = boardChar[0].length;
		char newBoardChar[][] = new char[h][w];
		
		for (int i=h-1; i>=0; i--) { //h는 밑에 부분부터 검사해야한다 !!
			for (int j=0; j<w; j++) {
				if (check[i][j] == false) { // 지우는거 아니면 그대로 넣어줌.
					newBoardChar[i][j] = boardChar[i][j];
				}
				else {
					int tmpI = i;
					boolean endFlag = false;
					while (tmpI >= 0) { //밑에꺼부터 위로 올라가면서 비어있는 부분 바로 위에있는걸로 가져옴.
						if (check[tmpI][j] == false && boardChar[tmpI][j] != '0') {
							newBoardChar[i][j] = boardChar[tmpI][j];
							boardChar[tmpI][j] = '0'; 
							check[tmpI][j] = true; // 이부분!! 때문에 테케 2개 틀렸었음. 가져온 부분은 밑으로 내려갔으니 다시 검사해줘야 함. 
							break ;
						}
						tmpI--;
					}
				}
				if (newBoardChar[i][j] == Character.MIN_VALUE) //char가 null이면
					newBoardChar[i][j] = '0';
			}
		}
		/*
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				System.out.print(newBoardChar[i][j]);
			}
			System.out.println();
		}
		*/
		
		return newBoardChar;
	}
	
	private static void countTrue(boolean[][] check) {
		for (int i=0; i<check.length; i++) {
			for (int j=0; j<check[0].length; j++) {
				if (check[i][j])
					answer++;
			}
		}
	}
}
