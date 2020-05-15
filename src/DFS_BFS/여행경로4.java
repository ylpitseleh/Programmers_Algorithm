package DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*
백트래킹으로 풀기
visited 초기화하고 똑같은 곳 다시 방문하면서 다른 길로 방문한거랑 최소값 비교해줘야하는거 백트래킹 쓰는게 제일 간단함. 
bfs로 풀다가 처음에 compare로 알파벳순정렬하고 처음 나오는 값 답으로 뽑았더니 
당연히 안 돼서(최소값 아니라 무조건 알파벳 우선순위로 답 나옴) 검색해보니 dfs썼길래 바꿈.
*/
public class 여행경로4 {
	static ArrayList al = new ArrayList<String>();
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		//String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		String[] answer = {};
		
		boolean visited[] = new boolean[tickets.length];
		for (int i=0; i<tickets.length; i++) {
			if (tickets[i][0].equals("ICN")) {
				visited[i] = true;
				dfs(i, tickets, visited, "", 0);
				Arrays.fill(visited, false);
			}
		}
		// 알파벳 순으로 빠른거 우선순위로 넣는거 그냥 String 하나에 경로 전체 넣고 나중에 al로 정렬해주면 끝.
		Collections.sort(al);
		answer = ((String) al.get(0)).split(" ");
		for (int i=0; i<answer.length; i++)
			System.out.print(answer[i]+" ");
	}
	
	public static void dfs(int idx, String[][] tickets, boolean[] visited, String s, int depth) {
		s += tickets[idx][0]+" ";
		
		if (depth == tickets.length-1) {
			s += tickets[idx][1];
			al.add(s);
			return ;
		}
		
		for (int i=0; i<tickets.length; i++) {
			if (tickets[idx][1].equals(tickets[i][0])) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(i, tickets, visited, s, depth+1);
					visited[i] = false;
				}
			}
		}
	}

}
