package level2;

import java.util.ArrayList;
import java.util.Collections;
/*
 * 소요 시간: 2시간
 * ★☆☆☆☆, Cheating : X
 * 차암내 대체 왜 스택/큐로 분류했는지 알 수가 없다. PQ 써야하는 줄 알고 이중 포문 안 쓰는 최선의 방법 두 시간 동안 고민하다가
 * 그냥 모르겠다 하고 막 풀어서 냈는데 효율성까지 정답처리 됨. 어이 X. 아 시간 아까워.
 */
public class 주식가격 {

	public static void main(String[] args) {
		//int[] prices = {1, 2, 3, 2, 3};
		int[] prices = {3, 2, 1, 3, 2};
		
		int[] answer = {};
		
		answer = new int[prices.length];


		for (int i=0; i<prices.length; i++) {
			int cnt = 0;
			for (int j=i+1; j<prices.length; j++) {
				cnt++;
				if (prices[i] > prices[j]) {
					break ;
				}
			}
			answer[i] = cnt;
		}
		
		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
	}

}
