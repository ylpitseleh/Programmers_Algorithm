package level2;

import java.util.ArrayList;
/*
 * 소요 시간: 2시간
 * ★★★☆☆, Cheating : O
 * 전에 두 시간만에 풀어서 맞았던 문제. 다시 풀으려니 "xababcdcdababcdcd" 이건 제일 첫 글자부터 자르는게 아니라서 압축을 못 한다는 말이 이해가 안 돼서 
 * 예전 풀이 보고 다시 문제 이해하고 리팩토링 느낌으로 다시 풀었다. 전에 푼 것 보다 훨씬 깔끔해졌다. 
 * 문제는 어렵지 않은데 괜히 내가 어렵게 이해하려고 해서 더 이해 못 한듯. 코테에 흔히 나올만한 좋은 문제인데 이런걸 깔끔하게 빨리 푸는 연습을 해야할듯.
 */
public class 문자열압축 {

	public static void main(String[] args) {
		//String s = "aabbaccc";
		//String s = "aaaaababac";
		//String s = "ababcdcdababcdcd";
		//String s = "abcabcdede";
		//String s = "abcabcabcabcdededededede";
		//String s = "xababcdcdababcdcd";
		//String s = "abababaaaaaaaa";
		String s = "a";
				
		int answer = 0;
		int min = s.length();
		
		for (int i=1; i<=s.length()/2; i++) { // 몇 글자 단위로 자를건지 
			ArrayList<String> al = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			int cnt = 1; // 3ab 의 3을 의미. cnt 올리는 용도 
			for (int j=0; j<s.length(); j+=i) { // 두 글자 단위로 자른다면 자른 단위의 시작 인덱스 (0, 2, 4, 6,..)
				String cur = "";
				cur = s.substring(j, Math.min(j+i, s.length())); // 맨 마지막 (j+i가 s.length 넘는 경우)는 s.length() 넘지 않게 Math.min 사용 
				al.add(cur);
				
				if (al.size() == 1)
					continue ;
				String before = al.get(al.size()-2); // 바로 전에 넣은 것 
				if (before.equals(cur)) { // 지금 substring 한거랑 바로 전에 substring 한거랑 같으면
					cnt++;
				}
				else { // 다르면
					if (cnt > 1)
						sb.append(cnt);
					sb.append(before);
					cnt = 1;
				}
				if (j+i >= s.length()) { // 마지막이면 남은거 그냥 넣어주기.
					if (cnt > 1)
						sb.append(cnt);
					sb.append(cur);
				}
			}
			min = Math.min(min, sb.length());
		}
		
		System.out.println(min);
	}

}
