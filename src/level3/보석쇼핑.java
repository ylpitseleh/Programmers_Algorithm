package level3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 소요 시간: 3시간
 * ★★★★☆, Cheating : O
 * 전형적인 투포인터 문제. 
 * end를 모든걸 포함하는만큼 뒤로 쭉 밀고 start 모든원소 포함할 때 까지 밀어주는게 답이 아니었다. 
 * 최소값이 그 뒤에 있을수도 있으니까.. 
 * 답 베꼈는데 큐로 이 부분 처리하는건 진짜 미친 천재같다. 투 포인터 = 큐 사용. 꼭 기억하고 있어야겠다. 
 */
public class 보석쇼핑 {

	public static void main(String[] args) {
		//String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		//String[] gems = {"AA", "AB", "AC", "AA", "AC"};
		//String[] gems = {"XYZ", "XYZ", "XYZ"};
		//String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		//String[] gems = {"A", "B", "A", "A", "B", "C"};
		//String[] gems = {"C", "C", "A"};
		String[] gems = {"A", "B", "B", "C", "A", "B", "C"}; // 이 테케를 고려해야함!! 답 : 3 5
		
		HashSet<String> hs = new HashSet<>();
		for (int i=0; i<gems.length; i++) {
			hs.add(gems[i]);
		}
		HashMap<String, Integer> hm = new HashMap<>();
		Queue<String> q = new LinkedList<>(); // 답으로 포함할 보석들
		
		int ansStart = 0;
		int start = 0;
		int maxLen = Integer.MAX_VALUE;
		for (int i=0; i<gems.length; i++) {
			if (!hm.containsKey(gems[i]))
				hm.put(gems[i], 1);
			else
				hm.put(gems[i], hm.get(gems[i]) + 1);
			q.add(gems[i]);
			System.out.println(q+" "+gems[i]);
			// < 핵심 아이디어 >
			// 큐에 첫 번째 보석이 2개 이상이면 tmpStart + 1하고 첫 번째 보석 삭제 (큐는 순서대로 들어오니까)
			while (true) {
				String peek = q.peek();
				if (hm.get(peek) > 1) {
					hm.put(peek, hm.get(peek) - 1);
					q.poll();
					start++;
				}
				else
					break ;
			}
			
			if (hm.size() == hs.size() && q.size() < maxLen) {
				maxLen = q.size();
				ansStart = start;
			}
		}
		System.out.println(ansStart+1+" "+(ansStart + maxLen));
		//return new int[] {ansStart+1, ansStart + maxLen};
	}

}
