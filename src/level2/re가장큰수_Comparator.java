package level2;

import java.util.Arrays;
import java.util.Comparator;
/*
 * 소요 시간: 1시간
 * ★★★★☆, Cheating : O
 * Comparator 첫번째 자리부터 세번쨰 자리까지 일일이 비교시키고 별 ㅈㄹ다 했는데 그냥 o1+o2 붙여서 비교만 해주면 되는거였다...
 * 이 문제 꼭 기억하기...
 */
public class re가장큰수_Comparator {

	public static void main(String[] args) {
		int[] numbers = {6, 10, 2};
		// 6210
		//int[] numbers = {3, 30, 34, 5, 9};
		// 9534330
		
		String answer = "";

		String s[] = new String[numbers.length];
		
		for (int i=0; i<numbers.length; i++) {
			s[i] = Integer.toString(numbers[i]);
		}
		
		Arrays.sort(s, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
		
		// 마지막 테케 -> 입력에 0이 여러번 중복되면 답은 "0" 이어야 하는데 "0000" 이런 수가 나오게 된다.
		// 그러므로 배열에 가장 큰 수가 "0" 으로 시작하는 경우에는 "0"을 입력하고 종료한다.
		if (s[0].equals("0")) {
			answer += "0";
			return ;
		}
		for (int i=0; i<s.length; i++)
			answer += s[i];
		
		System.out.println(answer);
		
	}

}
