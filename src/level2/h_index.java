package level2;

import java.util.Arrays;
/*
 * 소요 시간: 30분
 * ★★☆☆☆, Cheating : O
 * 진짜 설명 그지같은 문제. 걍 베껴서 내고 내 인생에서 꺼져버려.
 */
public class h_index {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		
		int answer = 0;
		
		Arrays.sort(citations);
		for (int i=0; i<citations.length; i++)
			System.out.print(citations[i]+" ");
		System.out.println();
		
		int h = 0, k = 0;
		for (int i = 0; i < citations.length; i++) {
            h = citations[i];
            k =  citations.length - i;
            if (k <= h) {
                answer = k;
                break;
            }
        }
		
		System.out.println(answer);

	}

}
