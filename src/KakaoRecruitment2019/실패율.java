package KakaoRecruitment2019;

import java.util.Arrays;
/*
 * 소요 시간: 47분
 * ★★☆☆☆, Cheating : X
 * 레벨1이고 쉬운 문제지만 문제 해석하는데 시간을 대부분 쓰고 java의 NaN값이란걸 처음 알았다. 
 * 이런 주는 문제들은 정말 빨리 풀어야하는데 연습이 조금 더 필요하다. 
 */
public class 실패율 {
	static class Pair implements Comparable<Pair>{
		int stageNum;
		double value;
		Pair (int stageNum, double value) {
			this.stageNum = stageNum;
			this.value = value;
		}
		
		public int compareTo(Pair p){
			return -Double.compare(value, p.value);
		}
	}
	
	public static void main(String[] args) {
		/*
		int N = 5;
		int stages[] = {2, 1, 2, 6, 2, 4, 3, 3};
		*/
		/*
		int N = 4;
		int stages[] = {4, 4, 4, 4, 4};
		*/
		
		int N = 4;
		int stages[] = {1, 2, 3};
		
		int [] answer = new int[N];

		// 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수
		Pair arr[] = new Pair[N];
		for (int i=0; i<N; i++) { // 스테이지 
			int stageButnotClear = 0;
			int stage = 0;
			for (int j=0; j<stages.length; j++) {
				if (stages[j] == i+1)
					stageButnotClear++;
				if (stages[j] >= i+1)
					stage++;
			}
			System.out.println(stageButnotClear+" "+stage);
			arr[i] = new Pair(i+1, (double)stageButnotClear / (double)stage);
			if (Double.isNaN(arr[i].value)) //java는 0으로 나눌 경우 NaN이라는 값 반환함. 
				arr[i].value = 0; // stage에 도달한 플레이어가 없을 때 NaN이 아닌 0을 넣어줘야 함.
		}
		
		Arrays.sort(arr);
		System.out.println();
		for (int i=0; i<N; i++) {
			System.out.println(arr[i].stageNum+" "+arr[i].value);
			answer[i] = arr[i].stageNum;
		}
		
	}

}
