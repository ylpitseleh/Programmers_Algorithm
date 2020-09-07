package level3;

public class 징검다리건너기 {
	/*
	 * 소요 시간: 4시간
	 * ★☆☆☆☆, Cheating : X
	 * 결국 정답 못 맞춤. 효율성 1개 때문에.
	 * 정말 이상한 문제다. 최적화 할 대로 했는데 심지어 거의 같은 코드 다른사람은 맞았던데 난 왜.. 
	 */
	public static void main(String[] args) {
		//int stones[] = {2, 4, 5,5, 3, 2, 1, 4, 2, 5, 1};
		int stones[] = {1,1,1,1, 2, 4, 5, 3, 2, 1, 4, 2, 5, 1,1,1,1,1,1,1,1,1,1,1,2};
		//int stones[] = { 1, 0, 0, 3, 2, 1, 4, 2, 5, 1 };
		//int stones[] = {6, 7, 8, 9, 10, 1, 5, 4, 3, 2, 5};
		//int stones[] = {1, 5, 4, 3, 2, 6, 7, 2, 1, 3, 3, 3, 2};
		//int k = 6;
		int k = 3;
		
		// k개 연속인 것 중에 k개 중 최대값이 가장 작은 것
		int answer = 200000001;
		int i = 0;
		
		while (i <= stones.length - k) {
			System.out.println("i = "+stones[i]+" answer = "+answer);
			int maxIdx = 0;
			int max = stones[i];
			for (int j=1; j<k; j++) {
				System.out.println("j = "+stones[i+j]);
				// 범위 내에 stones[i]보다 큰 값이 있을 때 제일 큰 값의 인덱스를 biggerIdx로 저장. 최대값만 정답 후보니까. 
				if (max < stones[i+j]) {
					max = stones[i+j];
					maxIdx = j;
				}
			}
			System.out.println("max = "+max);
			System.out.println();
			answer = Math.min(answer, max);
			i += maxIdx + 1; // 최대값에 해당하는 구간 + 1로 이동 
		}
		System.out.println(answer);
	}

}
