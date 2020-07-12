package Dynamic_Programming;
public class N으로표현1 {

	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		//int N = 2;
		//int number = 11;
		int answer = 0;
		
		int dp[] = new int[100000];
		
		int n = N; //N==5 일 때, 55, 555, 5555, ...
		int n_value = 0;
		for (int i=0; i<dp.length; i++) {
			if (i == n) {
				n_value++;
				dp[i] = n_value;
				n += (Math.pow(10, n_value) * N);
			}
			
		}
		
	}

}
