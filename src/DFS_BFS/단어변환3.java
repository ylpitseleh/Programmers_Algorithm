package DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 단어변환3 {
	static Queue q = new LinkedList<String>();
	static class StringAndIdx {
		String s;
		int idx;
		StringAndIdx (String s, int idx) {
			this.s = s;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		//String[] words = {"hot", "dot", "dog", "lot", "log"};
		//String[] words = {"hot", "dot", "cog", "cot"};
		int answer = 0;
		
		//words에 target이 없는 경우 0 리턴
		int containFlag = 0;
		for (int i=0; i<words.length; i++) {
			if (target.equals(words[i]))
				containFlag = 1;
		}
		if (containFlag == 0) {
			System.out.println(answer);
			return ;
			//return answer;
		}
		
		int map[] = new int[words.length];
		Arrays.fill(map, Integer.MAX_VALUE);
		
		int len = words[0].length();
		q.add(new StringAndIdx(begin, -1));
		while (!q.isEmpty()) {
			StringAndIdx str =  (StringAndIdx) q.poll();
			if (str.s.equals(target)) {
				answer = map[str.idx];
				break ;
			}
			for (int i=0; i<words.length; i++) {
				int sameCharCnt = 0;
				for (int j=0; j<len; j++) {
					if (str.s.charAt(j) == words[i].charAt(j))
						sameCharCnt++;
				}
				if (sameCharCnt >= len-1) {
					if (str.idx == -1)
						map[i] = 1;
					else
						map[i] = Math.min(map[i], map[str.idx]+1);
					q.add(new StringAndIdx(words[i], i));
				}
			}
		}
		
		for (int i=0; i<words.length; i++)
			System.out.print(map[i]+" ");
		System.out.println("answer : "+answer);
	}

}
