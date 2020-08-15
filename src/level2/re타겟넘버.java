package level2;

// 이해 잘 안 됨. 
public class re타겟넘버 {
	static int answer = 0;
	static int target;

	public static void main(String[] args) {
		int numbers[] = { 1, 1, 1, 1, 1 };
		target = 3;
		System.out.println("hi");
		dfs(numbers, 0);
		System.out.println(answer);
	}
	/*
	 {1, 1, 1, 1, 1}가있다면 
	 +1 +1 +1 +1 +1까지 가게되면 모든 숫자를 사용했기때문에 리턴되고
	 +1 +1 +1 +1 - 1 이됩니다.
	 이후 리턴하게 되면 다음은
	 +1 +1 +1 -1 +1
	 +1 +1 +1 -1 -1 순서가되고 여기서 3이 나오기때문에 카운트가 증가합니다. 이와같이 모든 경우의 수를 찾게되면 끝입니다.
	 */
	public static void dfs(int[] numbers, int depth) {
		// System.out.println("!!depth!! "+depth);
		if (depth == numbers.length) {
			int sum = 0;
			for (int i = 0; i < numbers.length; i++) {
				sum += numbers[i];
			}
			if (sum == target)
				answer++;
			return;
		}

		numbers[depth] *= 1;

		System.out.println("depth = " + depth);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		System.out.println();

		dfs(numbers, depth + 1);

		numbers[depth] *= -1;

		System.out.println("------MINUS-------");
		System.out.println("depth = " + depth);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		System.out.println();

		dfs(numbers, depth + 1);

	}

}
