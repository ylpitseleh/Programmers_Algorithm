package KakaoIntern2020;

import java.util.HashSet;

public class _3 {

	public static void main(String[] args) {
		 String gems[] = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE","DIA"};
		 //String gems[] = {"AA", "AB", "AC", "AA", "AC"};
		 //String gems[] = {"XYZ", "XYZ", "XYZ"};
		//String gems[] = { "ZZZ", "YYY", "NNNN", "YYY", "BBB" };
		// 3, 7 / 1, 3 / 1, 1/ 1, 5
		int answer[] = {};

		answer = new int[2];
		HashSet hs = new HashSet<String>();
		int N = gems.length;
		for (int i = 0; i < N; i++) {
			hs.add(gems[i]);
		}
		// System.out.println(hs);
		int start = 0;
		int end = 0;
		int min = 100001;
		
		int endIdx = 0;
		for (int i = 0; i < N; i++) {
			HashSet ans = new HashSet<String>();
			for (int j = i; j < N; j++) {
				if (min <= j - i)
					break ;
				if (hs.size() > j - i + 1)
					continue ;
				System.out.println((i+1)+" "+" "+(j+1)+" "+min);
				for (int k = i; k <= j; k++) {
					ans.add(gems[k]);
				
					if (ans.size() != hs.size())
						continue ;
					if (ans.equals(hs)) {
						if (min > j - i) {
							min = j - i;
							start = i + 1;
							end = j + 1;
							if (min == 0) {
								answer[0] = start;
								answer[1] = end;
								//return answer;
							}
							break ;
						}
					}
				}
				
			}
		}
		System.out.println(start + " " + end + " " + min);
		answer[0] = start;
		answer[1] = end;

	}

}
