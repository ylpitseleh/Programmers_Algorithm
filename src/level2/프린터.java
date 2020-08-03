package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 소요 시간: 40분
 * ★★★☆☆, Cheating : X
 * 10일?전에 답 봤던거 그대로 기억해내서 풀었다. PQ쓰면 되는데 array를 일일이 내림차순 정렬했다. PQ란걸 쓸 생각을 못 했다.
 * PQ 용도 => 큐 내림차순, 오름차순 정렬 할 때.
 * Num 클래스 만들어서 seq를 따로 뺼 필요도 없었다. Stack_Queue패키지에서 프린터4 모범답안 확인하기
 */
public class 프린터 {
	static class Num {
		int n;
		int seq;
		
		Num(int n, int seq) {
			this.n = n;
			this.seq = seq;
		}
	}
	
	public static void main(String[] args) {
		//int priorities[] = {2, 1, 3, 2};
		//int location = 2;
		int priorities[] = {1, 1, 9, 1, 1, 1};
		int location = 0;
		
		int answer = 1;
		
		// 오름차순 정렬해놓고 큐랑 비교
		Queue<Num> q = new LinkedList<Num>();
		for (int i=0; i<priorities.length; i++) {
			Num nn = new Num(priorities[i], i);
			q.add(nn);
		}
		
		// priorities를 내림차순 정렬 => 그냥 PQ 쓰면 됨.
		Arrays.sort(priorities);
		for(int i = 0; i < priorities.length / 2; i++)
		{
		    int temp = priorities[i];
		    priorities[i] = priorities[priorities.length - i - 1];
		    priorities[priorities.length - i - 1] = temp;
		}
		
		int i = 0;
		while (!q.isEmpty()) {
			Num nn = q.poll();
			if (nn.n == priorities[i]) {
				//System.out.println(nn.n+" "+priorities[i]);
				if (nn.seq == location) {
					System.out.println(i+1);
					break ;
				}
				i++;
			}
			else {
				q.add(nn);
			}
		}
	}

}
