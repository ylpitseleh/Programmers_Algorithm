package level2;
/*
 * 소요 시간: 5분
 * ☆☆☆☆☆, Cheating : X
 */
public class 피보나치수 {

	public static void main(String[] args) {
		// 0 1 1 2 3 5 8 13 21
		//int n = 3;
		 int n = 5;
		
		int answer = 0;
		
		int[] fibo = new int[n+1];
		
		fibo[0] = 0;
		if (n >= 1)
			fibo[1] = 1;
		for (int i=2; i<=n; i++) {
			fibo[i] = fibo[i-1] % 1234567 + fibo[i-2] % 1234567;
		}
		
		System.out.println(fibo[n] % 1234567);
	}

}
