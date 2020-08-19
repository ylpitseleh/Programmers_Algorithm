package level3;

import java.util.Comparator;
import java.util.PriorityQueue;

/* 못 품. 너무 어렵다. 나중에 다시 풀기 
 * 소요 시간: 3시간 
 * ☆☆☆☆☆, Cheating : X
 */
public class re디스크컨트롤러 {
	static class Task {
		int start;
		int end;
		int dur;

		Task(int start, int end, int dur) {
			this.start = start;
			this.end = end;
			this.dur = dur;
		}
	}

	public static void main(String[] args) {
		//int jobs[][] = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		//int jobs[][] = { { 0, 3 }, { 0, 9 }, { 0, 6 } };
		//int jobs[][] = { { 0, 3 }, { 1, 9 }, { 500, 6 } }; // 이게 대체 왜 답이 6?
		//int jobs[][] = {{0,9}, {0,4}, {0,5}, {0,7}, {0,3}}; // 13
		int jobs[][] = {{1,9}, {1,4}, {1,5}, {1,7}, {1,3}};
		
		int answer = 0;

		// int[][] jobs를 시작 시간 기준 오름차순 정렬
		java.util.Arrays.sort(jobs, new java.util.Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[1], a[0]);
			}
		});
		for (int i = 0; i < jobs.length; i++)
			System.out.println(jobs[i][0] + " " + jobs[i][1]);

		// al을 처리 시간 기준 오름차순 정렬 (Shortest job first)
		// 하나의 작업이 끝나는 시점까지 들어온 요청에 대해서 가장 짧은 수행시간을 가진 작업을 선택해야 한다!!!
		//ArrayList<Task> al = new ArrayList<>();
		PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
			public int compare(Task t1, Task t2) {
				return (t1.dur - t2.dur);
			}
		});
		/*
		Collections.sort(al, new Comparator<Task>() {
			@Override
			public int compare(Task t1, Task t2) {
				return (t1.dur - t2.dur);
			}
		});
		*/
		int i = 0;
		int end = 0; // 바로 앞에 있는 task가 끝난 시간
		int idx = 0;
		while (i < jobs.length) {
			Task t = new Task(jobs[i][0], jobs[i][1]+jobs[i][0], jobs[i][1]);
			
			// 현재 요청이 완료되기 전까지 들어온 요청들을 모두 큐에 넣음
			while (idx < jobs.length && jobs[idx][0] <= t.end) {
				//System.out.println(t.end+" / "+jobs[idx][0]+" "+jobs[idx][1]);
				pq.add(new Task(jobs[idx][0], jobs[idx][1]+jobs[idx][0], jobs[idx][1]));
				idx++;
			}
			for (int j=0; j<pq.size(); j++) {
				Task tt = pq.poll();
				System.out.println(tt.start+" / "+tt.dur);
			}
			// 큐가 비어있다면 작업 완료(end) 이후에 다시 요청이 들어온다는 의미
			// (end를 요청의 가장 처음으로 맞춰줌)
			/*
			if (pq.isEmpty())
				end = jobs[idx][0];
			else {
				Task poll = pq.poll();
				answer += poll.dur + end - poll.start;
				end += poll.dur;
				i++;
			}
			*/
		}
		
		answer = (int)(Math.floor(answer / jobs.length));
		System.out.println(answer);

	}

}
