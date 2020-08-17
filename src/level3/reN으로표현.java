package level3;
// 나중에 dfs 공부하고 다시 풀기
public class reN으로표현 {

	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		/*
		int N = 2;
		int number = 11;
		*/
		
		int answer = 0;
		dfs(0, N, number);
	}
	
	private static void dfs (int depth, int N, int number) {
		if (N == number) {
			System.out.println(depth);
			return ;
		}
		if (depth >= 8) {
			//System.out.println(-1);
			return ;
		}
		
		System.out.println(N);
		
		dfs (depth+1, N+N, number);
		dfs (depth+1, N-N, number);
		dfs (depth+1, N*N, number);
		if (N != 0)
			dfs (depth+1, N/N, number);
		N = N*10 + N;
		
	}
}
