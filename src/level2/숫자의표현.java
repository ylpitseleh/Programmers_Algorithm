package level2;
/*
 * 소요 시간: 45분
 * ★☆☆☆☆, Cheating : X
 * 그냥 인덱스 내려주고 올려주고 하면서 돌면 된다. 이중포문 필요없다구~!
 */
public class 숫자의표현 {

	public static void main(String[] args) {
		int n = 15;
		
		int answer = 0;
		
		int start = 1;
		int end = 1;
		int sum = 0;
		
		while (start <= n) {
			System.out.println(start+" "+end+" sum = "+sum);
			if (sum < n) {
				sum += end;
				end++;
			}
			else if (sum > n) { // 1~5가 n보다 크면 2~6 탐색
				sum -= start;
				start++;
			}
			else { //sum == n이면
				answer++;
				sum -= start;
				sum += end;
				start++;
				end++;
			}
		}
		System.out.println(answer);
		
	}

}
