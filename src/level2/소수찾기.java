package level2;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * 소요 시간: 1시간
 * ★★★☆☆, Cheating : X
 * permutation 아무것도 안 보고 나 혼자 구현해서 풀었다. 이것은 기적.
 * 알고보니 내가 아는 permutation이 c++에서 next_permutaiton이라 
 * 예를들어 numbers = "1231" 인 경우 1231, 1312, 1321, 2113,... 는 구할 수 있으나
 * 1123, 1213 은 포함하지 못하는 현상이 발생했다. (백준 이전순열 참조)
 * 이건 c++로 prev_permutaiton 써버리면 되는데
 * java에서 직접 구현하려면 swap하고 뭐 난리치길래 그냥 애초에 numbers를 오름차순 정렬해버리는 꼼수를 사용했다. 답만 맞으면 됐지!
 * 프로그래머스 풀이 보니까 나처럼 한 사람 있길래 좀 웃겼다.
 */
public class 소수찾기 {
	static int N;
	static ArrayList<Integer> al = new ArrayList<>();

	public static void main(String[] args) {
		 String numbers = "17";
		// String numbers = "123";
		//String numbers = "011";
		//String numbers = "1231";

		int answer = 0;

		N = numbers.length();

		// --- numbers를 오름차순으로 정렬시켜서 num으로 만들기 -- 
		char[] arr = numbers.toCharArray();
        Arrays.sort(arr);
		
		String num = "";
		for (int i = 0; i < N; i++) {
			num += Character.toString(arr[i]);
		}
		// ------------------------------------------

		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N];
			recursive(0, "", i, visited, num);
		}

		//System.out.println(al);
		answer = findPrimeNum(0);
		System.out.println("answer: " + answer);
	}
	
	// permutation 
	private static void recursive(int depth, String num, int len, boolean visited[], String numbers) {
		if (depth == len) {
			if (!al.contains(Integer.parseInt(num)))
				al.add(Integer.parseInt(num));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				recursive(depth + 1, num + numbers.charAt(i), len, visited, numbers);
				visited[i] = false;
			}
		}
	}

	// 소수 판별
	private static int findPrimeNum(int cnt) { // 에라토스테네스의 체 이용
		boolean prime[] = new boolean[al.get(al.size() - 1) + 1];

		// 소수는 false. 1은 소수가 아니므로 제외
		prime[0] = true;
		if (prime.length > 1)
			prime[1] = true;

		for (int i = 2; i * i <= prime.length - 1; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= prime.length - 1; j += i)
					prime[j] = true;
			}
		}
		
		for (int i = 0; i < al.size(); i++) {
			if (prime[al.get(i)] == false) {
				cnt++;
			}
		}
		return cnt;
	}
}
