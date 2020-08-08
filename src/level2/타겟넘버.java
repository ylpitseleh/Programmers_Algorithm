package level2;

public class 타겟넘버 {

	public static void main(String[] args) {
		int numbers[] = {1,1,1,1,1};
		int target = 3;

		boolean[] visited = new boolean[numbers.length];
		
		int n[] = new int[numbers.length];
		n[0] = 1;
		dfs(n, 0, "", visited, numbers, target);
		
	}
	
	private static void dfs(int[] n, int depth, String s, boolean[] visited, int[] numbers, int target) {
		if (depth == numbers.length) {
			System.out.println(s);
			return ;
		}
		
		for (int i=depth; i<numbers.length; i++) {
			//if (visited[i])
				//continue;
			//if (visited[i] == false) {
			visited[i] = true;
			dfs(n, depth+1, s+Integer.toString(n[i]), visited, numbers, target);
			visited[i] = false;
			//}
		}
		
		
		
	}

}
