package level2;

import java.util.Arrays;
/*
 * 소요 시간: 40분
 * ★☆☆☆☆, Cheating : X
 * 프로그래머스는... permutaiton 중복 문제 너무 많다.... permu 풀 줄 알면 굳이 안 풀어도 되는 시간낭비 문제..
 */
public class 소수만들기 {
	static int max = 0;
	static int answer = 0;

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4 };
		// int nums[] = {1, 2, 7, 6, 4}; // 1 2 4 6 7

		Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		int[] permu = new int[3];
		for (int i = nums.length - 1; i >= nums.length - 3; i--) { // nums중에 제일 큰 것 3개 더하기
			max += nums[i]; // 답이 될 수 있는 최대값
		}

		findPrimeNum(max);
		permutation(0, permu, nums, visited);

		System.out.println(answer);

	}

	private static void permutation(int depth, int[] permu, int nums[], boolean visited[]) {
		if (depth == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += permu[i];
			}
			if (!prime[sum])
				answer++;
			return;
		}

		for (int i = depth; i < nums.length; i++) {
			if (!visited[i]) {
				if ((depth == 0) || (depth != 0 && permu[depth - 1] < nums[i])) {
					visited[i] = true;
					permu[depth] = nums[i];
					permutation(depth + 1, permu, nums, visited);
					permu[depth] = 0;
					visited[i] = false;
				}
			}

		}
	}

	static boolean prime[];

	// 소수 판별
	private static void findPrimeNum(int n) { // 에라토스테네스의 체 이용
		prime = new boolean[n + 1];

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
	}
	
}
