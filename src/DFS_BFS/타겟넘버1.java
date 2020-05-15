package DFS_BFS;

public class 타겟넘버1 {
	static int answer = 0;
	static int target;
	public static void main(String[] args) {
		int numbers[] = {1,1,1,1,1};
		target = 3;
		
		dfs(numbers, 0);
        System.out.println(answer);
	}
	
	public static void dfs(int[] numbers, int cnt) {
        if(cnt==numbers.length){
            int sum=0;
            for(int i=0; i<numbers.length; i++) {
                sum += numbers[i];
            }
            if(sum==target)
                answer++;
            return;
        }
        else {
            numbers[cnt]*=1;
            dfs(numbers, cnt+1);
            
            numbers[cnt]*=-1;
            dfs(numbers, cnt+1);
        }
    }

}
