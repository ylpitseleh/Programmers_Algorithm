package level3Second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {

	public static void main(String[] args) {
		String[] operations = {"I 16", "D 1"};
		// String[] operations = {"I 7", "I 5", "I -5", "D -1"};
		// String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		//String[] operations = { "I 3" };
		int answer[] = {};
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순
 		PriorityQueue<Integer> pqRev = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
		
 		ArrayList<Integer> ans = new ArrayList<>();
 		for (int i=0; i<operations.length; i++) {
 			String[] s = operations[i].split(" ");
 			if (s[0].equals("I")) { // 숫자 삽입
 				ans.add(Integer.parseInt(s[1]));
 				pq.add(Integer.parseInt(s[1]));
 				pqRev.add(Integer.parseInt(s[1]));
 			}
 			else if (s[0].equals("D")) {
 				if (ans.size() < 1)
						continue ;
 				int n = 0;
 				if (s[1].equals("1")) { // 큐에서 최댓값 삭제
 					n = pqRev.poll();
 					System.out.println("최대값 "+n+"을 뺀다.");
 				}
 				else if (s[1].equals("-1")) { // 큐에서 최솟값 삭제
 					n = pq.poll();
 					System.out.println("최소값 "+n+"을 뺀다.");
 				}
 				ans.remove(ans.indexOf(n));
 			}
 		}
 		
 		answer = new int[2];
 		if (ans.size() == 0) {
 			answer[0] = answer[1] = 0;
 			System.out.println(answer[0]+" "+answer[1]);
 			return ;
 		}
 		Collections.sort(ans);
 		System.out.println(ans);
 		answer[0] = ans.get(ans.size()-1);
 		answer[1] = ans.get(0);
 		System.out.println(answer[0]+" "+answer[1]);
	}

}
