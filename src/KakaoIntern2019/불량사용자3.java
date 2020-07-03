package KakaoIntern2019;

import java.util.ArrayList;
import java.util.HashSet;
// 백트래킹으로 풀어야한다!!
// 복잡쿠.... 백트래킹 공부좀 더 하자.
public class 불량사용자3 {
	static int bannedN = 0;
	static int[] visited;
	static String[] banned;
	// banned_id에 해당하는거 HashSet에 넣어서 중복 제거하고 permu 돌려본다.
	static HashSet hs = new HashSet<String>();
	
	public static void main(String[] args) {
		//String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		//String[] banned_id = {"fr*d*", "abc1**"};
		
		//String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		//String[] banned_id = {"*rodo", "*rodo", "******"};
		
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		// banned_id에 들어갈 수 있는 id들만 HashSet에 넣어줌. 밑에서 이걸로 permu 돌릴거임.
		for (int i=0; i<user_id.length; i++) {
			for (int j=0; j<banned_id.length; j++) {
				int sameCnt = 0;
				for (int k=0; k<banned_id[j].length(); k++) {
					if (banned_id[j].length() != user_id[i].length())
						break ;
					if (banned_id[j].charAt(k) == '*' || banned_id[j].charAt(k) == user_id[i].charAt(k))
						sameCnt++;
				}
				if (sameCnt == banned_id[j].length()) {
					hs.add(user_id[i]);
				}
			}
		}
		
		bannedN = banned_id.length;
		visited = new int[hs.size()];//hs.size 중 bannedN개 뽑아야 함.
		banned = new String[hs.size()];
		hs.toArray(banned);
		//System.out.println(hs);
		num = new String[hs.size()];
		dfs(0, banned_id);
		System.out.println(hshs.size());
	}
	
	static String num[];
	//HashSet의 HashSet.
	static HashSet<HashSet<String>> hshs = new HashSet<HashSet<String>>();
	public static void dfs(int depth, String[] banned_id) {
		// 답이 될 수 있는 것들의 순열  num[] 중에서 답 거르기
		if (depth == bannedN) {
			int cnt = 0;
			for (int i=0; i<bannedN; i++) {
				int sameCnt = 0;
				for (int j=0; j<banned_id[i].length(); j++) {
					if (banned_id[i].length() != num[i].length())
						break ;
					if (banned_id[i].charAt(j) == '*')
						sameCnt++;
					if (num[i].charAt(j) == banned_id[i].charAt(j))
						sameCnt++;
				}
				if (sameCnt == num[i].length())
					cnt++;
			}
			
			HashSet<String> set = new HashSet<String>();
			if (cnt == bannedN) {
				/*
				for (int i=0; i<bannedN; i++)
					System.out.print(num[i]+" ");
				System.out.println();
				*/
				for (int i=0; i<bannedN; i++) {
					set.add(num[i]);
				}
				// 답이 될 수 있는 것들 중에 겹치는 HashSet이 없으면 답 추가
				if (!hshs.contains(set))
					hshs.add(set);
			}
		}
		
		for (int i=0; i<hs.size(); i++) {
			if (visited[i] == 1)
				continue ;
			visited[i] = 1;
			num[depth] = banned[i];
			dfs(depth + 1, banned_id);
			visited[i] = 0;
		}
		
		
	}
}
