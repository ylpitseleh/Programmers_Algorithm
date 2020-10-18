package level3Second;

import java.util.ArrayList;
import java.util.Collections;
/*
 * 소요 시간: 3시간
 * ★★☆☆☆, Cheating : O(풀이 설명 듣고 직접 구현)
 * 크루스칼 알고리즘.
 * 모든 노드를 최소 비용으로 연결할 때. 거리가 짧은 순서대로 먼저 정렬하고 visited로 체크하면서 답에 넣기. 
 * 원리만 알면 어렵지 않다. 
 * 
 * 테케 2-7번 틀렸던 이유 (중요!!!)
 * 섬이 2그룹으로 분리되어 연결될 경우를 고려하지 않으셨습니다.
 * n은 5이고, [[0,1,1],[0,2,2],[1,2,5],[1,3,3],[2,3,8],[3,4,1]] 인 경우를 생각해봅시다.
 * 위의 알고리즘대로 라면 0-1-2 섬과 3-4 섬이 서로 연결되는 것을 확인하고, 거기서 끝납니다.
 * 아직 하나의 연결이 부족한데, 모든 섬 방문이 끝났으니 거기서 멈춰버리고, 4를 리턴하게 되죠.
 * 실제로는 0-1-2 섬과 3-4 섬을 이어주는 최소 비용인 [1,3,3] 연결을 수행하고 끝나야 합니다.
 */
public class 섬연결하기_크루스칼 {
	static class Info implements Comparable<Info>{
		int start;
		int end;
		int cost;
		Info (int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Info i) {
			if (this.cost > i.cost)
				return 1;
			else if (this.cost == i.cost)
				return 0;
			else
				return -1;
		}
	}
	
	public static void main(String[] args) {
		/*
		int costs[][] = {{0,1,1}, 
						 {0,2,2}, 
						 {1,2,5}, 
						 {1,3,1}, 
						 {2,3,8}};
		int n = 4;
		*/
		int costs[][] = {{0,1,1}, 
						 {0,2,2}, 
						 {1,2,5}, 
						 {1,3,3}, 
						 {2,3,8},
						 {3,4,1}};
		int n = 5;
		
		
		// 모든 섬이 서로 통행 가능하도록 만드는데 필요한 최소 비용
		ArrayList<Info> al = new ArrayList<>();
		ArrayList<Info> ansAl = new ArrayList<>();
		
		for (int i=0; i<costs.length; i++) {
			Info info1 = new Info(costs[i][0], costs[i][1], costs[i][2]);
			al.add(info1);
			Info info2 = new Info(costs[i][1], costs[i][0], costs[i][2]);
			al.add(info2);
		}
		
		Collections.sort(al);
		/*
		for (int i=0; i<al.size(); i++) {
			System.out.println(al.get(i).start+" "+al.get(i).end+" "+al.get(i).cost);
		}
		*/
		boolean[] visited = new boolean[n];
		// 제일 비용이 적은 첫 번쨰 노드는 무조건 답에 포함.
		visited[al.get(0).start] = true;
		visited[al.get(0).end] = true;
		ansAl.add(al.get(0));
		int answer = al.get(0).cost;
		System.out.println("start = "+al.get(0).start+" "+al.get(0).end);
		
		while (true) {
			/*
			for (int i=0; i<n; i++)
				System.out.print(visited[i]+" ");
			System.out.println();
			*/
			boolean breakFlag = true;
			for (int i=0; i<n; i++) {
				if (!visited[i]) {
					breakFlag = false;
					break ;
				}
			}
			if (breakFlag)
				break ;
			
			// 0 1 -> 1 3 / 0 -> 2
			for (int i=0; i<al.size(); i++) {
				if (!visited[al.get(i).end]) {
					boolean continueFlag = true;
					// 여기가 중요. 정답 노드들과 연결 되어있어야 함. 
					for (int j=0; j<ansAl.size(); j++) {
						if (ansAl.get(j).end == al.get(i).start || ansAl.get(j).start == al.get(i).start)
							continueFlag = false;
					}
					if (continueFlag)
						continue ;
					
					System.out.println(al.get(i).end);
					visited[al.get(i).end] = true;
					answer += al.get(i).cost;
					ansAl.add(al.get(i));
					break ;
				}
			}
		}
		
		System.out.println(answer);
		
	}
	

}
