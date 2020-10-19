package level3Second;

import java.util.Arrays;
/*
 * 소요 시간: 3시간
 * ★★★★☆, Cheating : O
 * DFS로 풀어보려고 온갖 용을쓰다가 계속 시초나서 플로이드와샬 코드 베꼈당.
 * 이 문제를 보고 어떻게 플로이드와샬로 풀어야지 하는 생각이 떠오르는걸까? 
 */
public class 순위 {
	
	public static void main(String[] args) {
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		int n = 5;
		/*
		int[][] results = {{1, 2}, {2, 3}, {3, 4}, {5, 6}, {6, 7}, {7, 8}};
		int n = 8;
		*/
		//int[][] results = {{1, 2}, {3, 4}};
		//int n = 4;
		/*
		int[][] results = {{1, 2}, {2, 3}, {3, 4}, {5, 6}, {6, 7}, {7, 8}, {4, 5}};
		int n = 8;
		*/
		
		int answer = 0;
		int INF = 987654321;
		int[][] map = new int[n+1][n+1];
		for (int i=1; i<n+1; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0; // 대각선은 0 (자기 자신)
		}
		
		// input은 1 넣어주기
		for (int i=0; i<results.length; i++)
			map[results[i][0]][results[i][1]] = 1;
		
		// 최단 경로 저장
		for (int i=1; i<n+1; i++) {
			for (int j=1; j<n+1; j++) {
				for (int k=1; k<n+1; k++) {
					if (map[j][k] > map[j][i] + map[i][k]) // k 지점을 들렸다 가는거랑 비교
						map[j][k] = map[j][i] + map[i][k];
				}
			}
		}
		
		for (int i=1; i<n+1; i++) {
			for (int j=1; j<n+1; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		// 답 찾기
		for (int i=1; i<n+1; i++) {
			boolean answerFlag = true;
			for (int j=1; j<n+1; j++) {
				if (i!=j && map[i][j]==INF && map[j][i]==INF) {
					answerFlag = false;
					break ;
				}
			}
			if (answerFlag)
				answer++;
		}
		
		System.out.println(answer);
	}
}

/*
static class Node {
		int wIdx;
		int res; // 승리 1, 패배 -1
		Node (int wIdx, int res) {
			this.wIdx = wIdx;
			this.res = res;
		}
	}

	public static void main(String[] args) {

		
		int answer = 0;

		ArrayList<Node>[] a;
		a = new ArrayList[n];
		for (int i=0; i<n; i++)
			a[i] = new ArrayList<>();
		
		for (int i=0; i<results.length; i++) {
			a[results[i][0]-1].add(new Node(results[i][1]-1, 1)); // 승리
			a[results[i][1]-1].add(new Node(results[i][0]-1, -1)); // 패배
		}
		
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[i].size(); j++) {
				System.out.print("("+a[i].get(j).wIdx+" "+a[i].get(j).res+")");
			}
			System.out.println();
		}
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[i].size(); j++) {
				if (a[i].get(j).res != 0) {
					dfs(i, a[i].get(j).wIdx, a[i].get(j).res, a);
					
				}
			}
		}
		
		for (int i=0; i<a.length; i++) {
			if (a[i].size() == n-1)
				answer++;
		}
		System.out.println(answer);
	}
	// flag = 1 승리, flag = -1, 패배
	private static void dfs (int val1, int val2, int flag, ArrayList<Node>[] a) {
		System.out.println("FLAG = "+ flag +" VAL1, VAL2 = "+val1+" "+val2);
		for (int i=0; i<a[val2].size(); i++) {
			if (a[val2].get(i).res != flag)
				continue ;
			
			boolean containsFlag = false;
			
			for (int j=0; j<a[val1].size(); j++) {
				if (a[val1].get(j).wIdx == a[val2].get(i).wIdx) {
					System.out.println("같은게 있다. "+i);
					containsFlag = true;
					System.out.println("VAL = "+val1+" "+j +" FLAG = "+flag);
					a[val1].get(j).res = flag;
					break ;
				}
			}
			if (!containsFlag) {
				a[val1].add(new Node(a[val2].get(i).wIdx, flag));
				System.out.println("추가되었다. "+a[val2].get(i).wIdx+" "+flag);
			}
			System.out.println("val1 = "+val1+" val2 = "+val2+" i = "+i);
			
			for (int l=0; l<a.length; l++) {
				for (int j=0; j<a[l].size(); j++) {
					System.out.print("("+a[l].get(j).wIdx+", "+a[l].get(j).res+")");
				}
				System.out.println();
			}
			System.out.println();
			dfs(val2, a[val2].get(i).wIdx, a[val2].get(i).res, a);
		}
	}
*/
