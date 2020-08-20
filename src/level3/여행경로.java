package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * 소요 시간: 1시간 30분
 * ★★★☆☆, Cheating : O
 * BFS로 시작했다가 이거 DFS인 것 같아서 다 지우고 DFS로 풀다가 테케 1번 틀려서 (잘못된 테케인것같음. 프로그래머스가 수정 안 함) 베꼈다. 
 * 문제 보고 바로 DFS인지, DFS+백트래킹인지, BFS인지 빨리 판단해야한다. -> 여러 문제 풀어보면서 유형 익히기 , 이해도 높이기
 */
public class 여행경로 {
	static ArrayList al = new ArrayList<String>();
	
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		//String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		//String[][] tickets = {{"ICN","A"},{"ICN","A"},{"A","ICN"}};
		//String[][] tickets =  {{"ICN","A"},{"A","B"},{"B","A"},{"A","ICN"},{"ICN","A"}};
		//String[][] tickets =  {{"ICN","BOO"},{"ICN", "COO"},{"COO","DOO"},{"DOO","COO"},{"BOO","DOO"},{"DOO","BOO"},{"BOO","ICN"},{"COO","BOO"}};
		
		String[] answer = {};
		
		boolean visited[] = new boolean[tickets.length];
		for (int i=0; i<tickets.length; i++) {
			if (tickets[i][0].equals("ICN")) {
				visited[i] = true;
				dfs(i, tickets, visited, "", 0);
				Arrays.fill(visited, false);
			}
		}
		
		Collections.sort(al);
		answer = ((String) al.get(0)).split(" ");
		
		for (int i=0; i<answer.length; i++)
			System.out.println(answer[i]);
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
