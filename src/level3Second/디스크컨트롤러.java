package level3Second;

import java.util.Arrays;
// 나중에 다시 풀기
public class 디스크컨트롤러 {
	static class Task implements Comparable<Task>{
		int start;
		int dur;
		int end;
		Task (int start, int dur, int end) {
			this.start = start;
			this.dur = dur;
			this.end = end;
		}
		// dur이 짧은 순서대로 오름차순 정렬
		@Override
		public int compareTo(Task t) {
			return dur - t.dur;
		}
	}
	
	public static void main(String[] args) {
		int jobs[][] = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		// int jobs[][] = { { 0, 3 }, { 0, 9 }, { 0, 6 } };
		// int jobs[][] = { { 0, 3 }, { 1, 9 }, { 500, 6 } }; // 이게 대체 왜 답이 6?
		// int jobs[][] = {{0,9}, {0,4}, {0,5}, {0,7}, {0,3}}; // 13
		//int jobs[][] = { { 1, 9 }, { 1, 4 }, { 1, 5 }, { 1, 7 }, { 1, 3 } };

		int answer = 0;
		Task[] arr = new Task[jobs.length];
		for (int i=0; i<jobs.length; i++) {
			arr[i] = new Task(jobs[i][0], jobs[i][1], jobs[i][0]+jobs[i][1]);
		}
		Arrays.sort(arr);
		for (int i=0; i<arr.length; i++)
			System.out.println(arr[i].start+" "+arr[i].dur+" "+arr[i].end);
		
		int[] startTime = new int[jobs.length];
		for (int i=1; i<jobs.length; i++)
			startTime[i] = arr[i-1].dur + startTime[i-1];
		for (int i=0; i<jobs.length; i++)
			System.out.print(startTime[i]+" ");
		System.out.println();

		int[] ans = new int[jobs.length];
		for (int i=0; i<jobs.length; i++)
			ans[i] = arr[i].dur + (startTime[i] - arr[i].start);
		for (int i=0; i<jobs.length; i++) {
			System.out.print(ans[i]+" ");
			answer += ans[i];
		}
		answer /= jobs.length; 
		System.out.println(answer);
	
	}

}
