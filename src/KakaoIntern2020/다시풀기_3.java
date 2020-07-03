package KakaoIntern2020;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 다시풀기_3 {
	// 대체 이걸 어터케 생각해내지 흡...
	// 좋은 문제. 나중에 다시 꼭 풀어보기.
	
	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		//String[] gems = {"AA", "AB", "AC", "AA", "AC"};
		//String[] gems = {"XYZ", "XYZ", "XYZ"};
		//String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		int[] answer = {};
		
		// HashSet : 모든 보석의 종류
		HashSet<String> hs = new HashSet<String>();
		for (int i=0; i<gems.length; i++) {
			hs.add(gems[i]);
		}
		
		// HashMap : 보석이 몇 개 들어가 있는지 셀 용도
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		// Queue : 답으로 포함할 보석들
		Queue<String> q = new LinkedList<>();
		
		int ansStart = 0;
		int tmpStart = 0;
		int len = Integer.MAX_VALUE;
		for (int i=0; i<gems.length; i++) {
			if (!hm.containsKey(gems[i]))
				hm.put(gems[i], 1);
			else
				hm.put(gems[i], hm.get(gems[i]) + 1);
			
			q.add(gems[i]);
			System.out.println(q+" "+gems[i]);
			
			// 큐에 첫 번째 보석이 중복이면(2개 이상) tmpStart를 +1 해주고 첫 번째 보석을 삭제한다. 
			while (true) {
				String peek = q.peek();
				if (hm.get(peek) > 1) {
					hm.put(peek, hm.get(peek) - 1);
					q.poll();
					tmpStart++;
				}
				else 
					break ;
			}
			System.out.println(q);
			System.out.println();
			
			if (hm.size() == hs.size() && len > q.size()) {
				len = q.size();
				ansStart = tmpStart;
			}
		}
		// return new int[] {start+1, start + len};
		
		
	}

}
