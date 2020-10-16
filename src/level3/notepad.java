package level3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class notepad {

	public static void main(String[] args) {
		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD",
				"SAPPHIRE", "DIA" };
		// String[] gems = {"AA", "AB", "AC", "AA", "AC"};
		// String[] gems = {"XYZ", "XYZ", "XYZ"};
		// String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		// String[] gems = {"A", "B", "A", "A", "B", "C"};
		// String[] gems = {"C", "C", "A"};
		// String[] gems = { "A", "B", "B", "C", "A", "B", "C" }; // 이 테케를
		// 고려해야함!!
		// 답 : 3 5
		HashSet<String> hsTotal = new HashSet<>();

		int N = gems.length;
		for (int i = 0; i < N; i++) {
			hsTotal.add(gems[i]);
		}
		
		int ansStart = -1;
		int ansEnd = -1;
		int minLen = Integer.MAX_VALUE;
		//HashMap<String, Integer> hm = new HashMap<>();
		int start = 0;
		int end = 0;

		
		System.out.println(start + " " + end);
	}
}
