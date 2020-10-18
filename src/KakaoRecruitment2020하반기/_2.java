package KakaoRecruitment2020하반기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class _2 {
	static HashMap<String, Integer> hm = new HashMap<>();
	
	public static void main(String[] args) {
		String orders[] = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		//String orders[] = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		//String orders[] = {"XYZ", "XWY", "WXA"};
		
		HashSet<Character> hs = new HashSet<>();
		
		for (int i=0; i<orders.length; i++) {
			for (int j=0; j<orders[i].length();j++) {
				hs.add(orders[i].charAt(j));
			}
		}
		
		//System.out.println(hs);
		
		char alpha[] = new char[hs.size()];
		int idx = 0;
		
		Iterator iter = hs.iterator();	// Iterator 사용
		while(iter.hasNext()) {//값이 있으면 true 없으면 false
		    alpha[idx] = (char) (iter.next());
		    idx++;
		}
		for (int i=1; i<=hs.size(); i++) {
			boolean[] visited = new boolean[alpha.length];
			permu(0, alpha, visited, i, "", hm);
		}
		
		for (int i=0; i<orders.length; i++) {
			System.out.println(orders[i]);
			alpha = new char[orders[i].length()];
			for (int j=0; j<orders[i].length(); j++) {
				alpha[j] = orders[i].charAt(j);
			}
			
			for (int j=2; j<=orders[i].length();j++) {
				al.clear();
				boolean[] visited = new boolean[alpha.length];
				permuReturn (0, alpha, visited, j, "");
				
				for (int k=0; k<al.size(); k++) {
					if (hm.containsKey(al.get(k)))
						hm.put(al.get(k), hm.get(al.get(k))+1);
				}
			}
		}
		// 최소 2개 이상 주문한 손님 => 오름차순 정렬
		System.out.println(hm);
		
		ArrayList<String> al = new ArrayList<>();
		for (String key : hm.keySet()) {
		    Integer value = hm.get(key);
		    if (value >= 2) {
		    	al.add(key);
		    }
		}
		System.out.println(al);


		
	}
	static ArrayList<String> al = new ArrayList<>();
	private static void permu (int depth, char alpha[], boolean[] visited, int n, String s, HashMap<String, Integer> hm) {
		if (depth == n) {
			//System.out.println(s);
			hm.put(s, 0);
			return ;
		}
		
		for (int i=depth; i<alpha.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permu(depth+1, alpha, visited, n, s+alpha[i], hm);
				visited[i] = false;
			}
		}
	}

	private static String permuReturn (int depth, char alpha[], boolean[] visited, int n, String s) {
		if (depth == n) {
			al.add(s);
			return s;
		}
		
		for (int i=depth; i<alpha.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permuReturn(depth+1, alpha, visited, n, s+alpha[i]);
				visited[i] = false;
			}
		}
		return s;
	}
}
