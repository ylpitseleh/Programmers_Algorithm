package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
/*
 * 소요 시간: 40분
 * ★★☆☆☆, Cheating : X
 * 그냥 쉬운문제. split이랑 문자열 길이순 오름차순 정렬만 해주면 됨.
 */
public class 튜플 {

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		// String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		// String s = "{{20,111},{111}}";
		// String s = "{{123}}";
		//String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		
		int[] answer = {};
		int tupleCnt = 0;
		for (int i=1; i<s.length()-1; i++) { // 맨 앞({), 맨 마지막(}) 빼고
			if (s.charAt(i) == '{')
				tupleCnt++;
		}

		String s1 = s.replace("{", "");
		String[] sArr = s1.split("},|}}");// }, or }}
		
		Arrays.sort(sArr, Comparator.comparing(String::length)); // 문자열 길이순 오름차순 정렬

		ArrayList<Integer> al = new ArrayList<>();
		for (int i=0; i<sArr.length; i++) {
			String[] tmp = sArr[i].split(",");
			for (int j=0; j<tmp.length; j++) {
				if (!al.contains(Integer.parseInt(tmp[j])))
					al.add(Integer.parseInt(tmp[j]));
			}
		}
		
		//System.out.println(al);
		answer = new int[al.size()];
		for (int i=0; i<al.size(); i++) {
			answer[i] = al.get(i);
		}
	}

}
