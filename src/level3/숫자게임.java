package level3;

import java.util.Arrays;
/*
 * 소요 시간: 15분
 * ★★☆☆☆, Cheating : O
 * 다른 사람이 푼거 보고 아이디어 얻어서 풀긴 풀었는데 왜 이게 정답인지 잘 모르겠당.. 
 */
public class 숫자게임 {

	public static void main(String[] args) {
		/*
		int[] A = {5, 1, 3, 7};
		int[] B = {2, 2, 6, 8};
		*/
		
		int[] A = {2, 2, 2, 2};
		int[] B = {1, 1, 1, 1};
		
		
		int answer = 0;
		
		// B팀이 A팀 출전 순서를 보고 최종 승점을 가장 높이는 방법
		Arrays.sort(A); // 1 3 5 7
		Arrays.sort(B); // 2 2 6 8
		
		int minIdx = 0;
		int[] minArr = new int[B.length]; // B가 A를 이길 수 있는 최소한의 인덱스 배열
		
		Arrays.fill(minArr, -1);
		for (int i=0; i<B.length; i++) {
			for (int j=minIdx; j<A.length; j++) {
				if (B[i] > A[j]) {
					minArr[minIdx] = j;
					minIdx++;
					break ;
				}
			}
			if (minArr[i] != -1)
				answer++;
		}
		
		for (int i=0; i<B.length; i++)
			System.out.print(minArr[i]+" ");
		
		System.out.println(answer);
	}

}
