package KakaoIntern2019;

import java.util.ArrayList;

public class 크레인인형뽑기게임1 {

	public static void main(String[] args) {
		//int board[][] = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
		//int moves[] = {1, 5, 3, 5, 1, 2, 1, 4};
		
		int board[][] = {{1,2}, {1,2}};
		int moves[] = {1, 1, 2, 2};
		
		ArrayList<Integer> al = new ArrayList<>();
		
		for (int i=0; i<moves.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				if (board[j][moves[i]-1] != 0) {
					//ArrayList에 해당 원소 추가
					al.add(board[j][moves[i]-1]);
					//해당 원소가 있던 자리는 0으로 변경
					board[j][moves[i]-1] = 0;
					break ;
				}
			}
		}
		
		//System.out.println(al);
		//System.out.println();
		int ans = 0;
		int size = al.size();
		for (int i=0; i<size/2; i++) {
			for (int j=1; j<al.size(); j++) {
				if (al.get(j) == al.get(j-1)) {
					al.remove(j);
					al.remove(j-1);
					ans += 2;
				}
			}
		}
		System.out.println(ans);
	}

}
