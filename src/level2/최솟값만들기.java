package level2;

import java.util.Arrays;
/*
 * 소요 시간: 10분
 * ☆☆☆☆☆, Cheating : X
 * permutation으로 풀었다가 시간초과나서 sort했더니 됐다.
 */
public class 최솟값만들기 {

	public static void main(String[] args) {
		
		int[] a = {1, 4, 2};
		int[] b = {5, 4, 4};
		
		/*
		int[] a = {1, 2};
		int[] b = {3, 4};
		*/ 
		int answer = 0;

		Arrays.sort(a);
		Arrays.sort(b);
		
		for (int i=0; i<b.length/2; i++) {
			int tmp = b[i];
			b[i] = b[b.length-i-1];
			b[b.length-i-1] = tmp;
		}
		/*
		for (int i=0; i<b.length; i++) {
			System.out.println(b[i]);
		}
		*/
		for (int i=0; i<a.length; i++) {
			answer += a[i] * b[i];
		}
		System.out.println(answer);
	}
	

}
