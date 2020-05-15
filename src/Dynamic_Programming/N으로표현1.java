package Dynamic_Programming;
// 못 풀었음. 이해도 안 감. DFS 연습하고 다시 보기
public class N으로표현1 {

	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		//int N = 2;
		//int number = 11;
		int answer = 0;
		
		int dp[] = new int[99999];
		//dp[0]은 비워놓기
		dp[1] = 2;
		dp[2] = 3;
		int squareIdx = 1;
		int seqN = 1; 
		int mulTen = 10;
		for (int i=0; i<dp.length; i++) {
			if (i%N == 0 && i != 0) {// 5 10 15 
				dp[i] = dp[i-N] + 1;
			}
			else if (i == N * squareIdx) { // 5 25 125
				dp[i] = dp[i/5] + 1;
				squareIdx++;
			}
			else if (i == seqN * N) { //5 55 555
				dp[i] = (int)Math.log10(i)+1;
				seqN += mulTen;
				mulTen *= 10;
			}
			else {
				if (i>=1 && i<99998) {
					dp[i] = Math.min(dp[i+1] + dp[1], dp[i-1] + dp[1]);
				}
			}
			
			
		}
		for (int i=1; i<=60; i++) {
			System.out.println("dp["+i+"] : "+dp[i]);
		}
		
		/* 답 
		 class Solution {
    static int answer =-1;
    
    public int solution(int N, int number) {
        
        dfs(N, number, 0,0);
        return answer;
    }
    static void dfs(int N, int number , int cnt, int prev) {
        //N의 카운트를 늘려가며 dfs 로 수행한다. 
        //그 값을 저장하고 그 값이 number와 동일한지 확인한다. 
        int temp_N = N;
        if (cnt > 8) {
            answer = -1;
            return;
        }
        
        if (number == prev ) {
            if (answer == -1 || answer > cnt)
                answer = cnt;
            return;
        }
        
        for (int i = 0; i < 8-cnt; i++) {
            dfs(N, number, cnt+i+1, prev-temp_N);
            dfs(N, number, cnt+i+1, prev+temp_N);
            dfs(N, number, cnt+i+1, prev*temp_N);
            dfs(N, number, cnt+i+1, prev/temp_N);
            
            temp_N =  increaseNumber(temp_N, N);
        }
    }
    static int increaseNumber(int value, int N) {
        return value * 10 + N;
    }
}
		 */
		
	}

}
