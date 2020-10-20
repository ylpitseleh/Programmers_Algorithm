package level3Second;

import java.util.ArrayList;
import java.util.Collections;
/*
 * 소요 시간: 30분
 * ★☆☆☆☆, Cheating : X
 * 1번테케 틀려서 보니 백트래킹을 써야 정답이 나온다. 
 * 백트래킹 안 쓰면 모든 노드를 방문하지 못할 수도 있다 !!!
 */
public class 여행경로 {

	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		//String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		//String[][] tickets = {{"ICN","A"},{"ICN","A"},{"A","ICN"}};
		//String[][] tickets =  {{"ICN","A"},{"A","B"},{"B","A"},{"A","ICN"},{"ICN","A"}};
		//String[][] tickets =  {{"ICN","BOO"},{"ICN", "COO"},{"COO","DOO"},{"DOO","COO"},{"BOO","DOO"},{"DOO","BOO"},{"BOO","ICN"},{"COO","BOO"}};
		//String[][] tickets = {{"ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"}, {"B", "A"}}; // 백트래킹해야만 이 테케가 맞음
		
		int N = tickets.length;
		for (int i=0; i<N; i++) {
			if (tickets[i][0].equals("ICN")) {
				boolean[] visited = new boolean[N];
				dfs (0, i, tickets[i][1], "ICN", visited, tickets);
			}
		}
		Collections.sort(ansAl);
		String tmpAns = ansAl.get(0);
		String[] answer = tmpAns.split(" ");
		for (int i=0; i<answer.length; i++)
			System.out.print(answer[i]+" ");
	}

	static ArrayList<String> ansAl = new ArrayList<String>();
	private static void dfs (int depth, int idx, String airport, String answer, boolean[] visited, String[][] tickets) {
		visited[idx] = true;
		boolean returnFlag = true;
		for (int i=0; i<visited.length; i++) {
			if (!visited[i]) {
				returnFlag = false;
				break ;
			}
		}
		if (returnFlag) {
			answer += " "+tickets[idx][1];
			ansAl.add(answer);
			return ;
		}
			
		
		for (int i=0; i<tickets.length; i++) {
			if (tickets[i][0].equals(airport) && !visited[i]) {
				visited[i] = true;
				dfs (depth+1, i, tickets[i][1], answer+" "+airport,visited, tickets);
				visited[i] = false; 
			}
		}
		
	}
}
