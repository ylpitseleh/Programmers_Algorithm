package level3Second;
/*
 * 소요 시간: 3시간
 * ★★★☆☆, Cheating : X
 * 후.... DFS로 풀다가 계속 테케 틀려서 로그 찍어보니까 visited때문에 dfs가 제대로 안돌아서 보니까
 * 백트래킹을 써야했다. 몇 시간 동안 싸우다가 겨우 해결. 
 */
public class 단어변환 {
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		/*
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		*/
		
		String begin = "hot";
		String target = "lot";
		String[] words = {"dot", "dog", "lot", "log", "cog"};
		
		/*
		String begin = "hit";
		String target = "hhh";
		String[] words = {"hhh", "hht"};
		*/
		//String begin = "her";
		//String target = "cog";
		//String[] words = {"hes", "ces", "cos", "cog"};
		
		//String[] words = {"hot", "dot", "dog", "lot", "log"};
		//String[] words = {"hot", "dot", "cog", "cot"};
		//String[] words = {"hot", "cog"};
		
		// words 배열에 target이 없으면 0 리턴
		boolean endFlag = true;
		for (int i=0; i<words.length; i++) {
			if (words[i].equals(target))
				endFlag = false;
		}
		if (endFlag) {
			answer = 0;
			return ;
		}
		
		for (int i=0; i<words.length; i++) {
			int diffCnt = 0;
			for (int j=0; j<begin.length(); j++) {
				if (begin.charAt(j) != words[i].charAt(j))
					diffCnt++;
			}
			// 한 글자만 다른 것 dfs로 탐색
			if (diffCnt == 1) {
				boolean[] visited = new boolean[words.length];
				visited[i] = true;
				System.out.println("들어간다. "+words[i]);
				dfs (1, words[i], visited, words, target);
			}
		}
		if (answer == Integer.MAX_VALUE)
			answer = 0;
		System.out.println("ANS = "+answer);
	}

	private static void dfs (int depth,  String word, boolean[] visited, String[] words, String target) {
		System.out.println(word+" depth = "+depth);
		/*
		for (int i=0; i<visited.length; i++) {
			System.out.print(visited[i]+" ");
		}
		System.out.println();
		*/
		if (word.equals(target)) {
			answer = Math.min(answer, depth);
			if (depth == 0)
				answer = 1;
			System.out.println("target == word 일 때 depth = "+depth);
		}
		
		for (int i=0; i<words.length; i++) {
			int diffCnt = 0;
			if (visited[i])
				continue ;
			for (int j=0; j<word.length(); j++) {
				if (word.charAt(j) != words[i].charAt(j))
					diffCnt++;
			}

			System.out.println(word+"랑 비교 "+words[i]+", diff = "+diffCnt);
			System.out.println();
			if (diffCnt == 1) {
				visited[i] = true;
				dfs (depth + 1, words[i], visited, words, target);
				visited[i] = false;
			}
		}
	}
}
