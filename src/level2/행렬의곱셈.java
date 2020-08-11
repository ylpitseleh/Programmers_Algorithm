package level2;
/*
 * 소요 시간: 40분
 * ★☆☆☆☆, Cheating : X
 * 완죠니 헷갈려서 Sysout으로 다 찍어보고 풀었당.
 */
public class 행렬의곱셈 {

	public static void main(String[] args) {
		/*
		int arr1[][] = {{1, 4},
						{3, 2},
						{4, 1}};
		int arr2[][] = {{3, 3}, 
						{3, 3}};
		*/
		
		int arr1[][] = {{2, 3, 2},{4, 2, 4},{3, 1, 4}};
		int arr2[][] = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
		
		
		int[][] answer = {};
		answer = new int[arr1.length][arr2[0].length];

		for (int i=0; i<arr1.length; i++) { // 3
				
				for (int j=0; j<arr2[0].length; j++) { // 2
					int sum = 0;
					System.out.println("answer["+i+"]"+"["+j+"]");
					for (int k=0; k<arr2.length; k++) { // 2
						System.out.println(i+" "+k+" / "+j+" "+k);
						System.out.println();
					//answer[0][0] = arr1[0][0]*arr2[0][0] + arr1[0][1] * arr2[1][0];
					//answer[0][1] = arr1[0][0]*arr2[0][1] + arr1[0][1] * arr2[1][1];
					
					//answer[1][0] = arr1[1][0]*arr2[0][0] + arr1[1][1] * arr2[1][0];
					//answer[1][1] = arr1[1][0]*arr2[0][1] + arr1[1][1] * arr2[1][1];
						sum += arr1[i][k] * arr2[k][j];
					}
					answer[i][j] = sum;
			}
		}
		
		for (int i=0; i<answer.length; i++) {
			for (int j=0; j<answer[0].length; j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	}

}
