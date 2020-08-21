package level3;

import java.util.PriorityQueue;
/*
 * 소요 시간: 40분
 * ★☆☆☆☆, Cheating : X
 * PQ, reverse PQ 두 개 써서 하면 되는데 좀 바보같이 푼 것 같다. 귀찮으니 리팩토링 생략.
 */
public class 이중우선순위큐 {

	public static void main(String[] args) {
		//String[] operations = {"I 16", "D 1"};
		//String[] operations = {"I 7", "I 5", "I -5", "D -1"};
		//String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		String[] operations = {"I 3"};
		int answer[] = {};
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순
		PriorityQueue<Integer> pqCopy = new PriorityQueue<>();
	
		for (int i=0; i<operations.length; i++) {
			String[] s = operations[i].split(" ");
			//System.out.println(s[0]+" / "+s[1]);
			if (s[0].equals("I")) {
				pq.add(Integer.parseInt(s[1]));
				//pqTmp.add(Integer.parseInt(s[1]));
				//System.out.println(pq);
				//System.out.println(pqCopy);
			}
			else if (s[0].equals("D")) {
				if (pq.isEmpty())
					continue ;
				if (s[1].startsWith("-")) { // 최솟값 삭제
					pq.remove();
					pqCopy.remove();
				}
				else { // 최댓값 삭제
					int j = 0;
					pq.clear(); // pq 초기화하고 pqCopy에서 제일 마지막에 있는 원소 빼고 다 넣기
					while (j < pqCopy.size() - 1) {
						pq.add(pqCopy.remove());
						j++;
					}
					pqCopy.clear();
				}
			}
			pqCopy.clear();
			pqCopy.addAll(pq);
			System.out.println(pq);
			System.out.println(pqCopy);
		}
		
		System.out.println(pq);
		answer = new int[2];
		if (pq.size() == 0) {
			answer[0] = 0;
			answer[1] = 0;
			System.out.println(answer[0]+" "+answer[1]);
			return ;
		}
		answer[1] = pq.poll();
		while (pq.size() > 1) {
			pq.poll();
		}
		answer[0] = pq.poll();
		System.out.println(answer[0]+" "+answer[1]);
	}

}
