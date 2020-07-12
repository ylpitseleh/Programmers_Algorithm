package Stack_Queue;

import java.util.ArrayList;

public class 기능개발3 {

	public static void main(String[] args) {
		// 배포되어야 하는 순서대로 작업의 진도(%)가 적힌 배열
		int  progresses[] = {93, 30, 55}; //7%, 70%, 45% 남음
		// 각 작업의 개발 속도(% per day)
		int speeds[] = {1, 30, 5};
		// 각 배포마다 몇 개의 기능이 배포되는지
		int[] answer = {};
		/*
		원래는 {7일 후, 3일 후, 9일 후} 배포 가능이지만 
		앞에 있는 기능이 배포될 때 함께 배포되므로 7일째에 2개, 9일째에 1개 배포됨.
		*/
		int N = progresses.length;
		int daysNeeded[] = new int[N];
		for (int i=0; i<N; i++) {
			int percent = 100 - progresses[i];
			int ans = 0;
			while (percent > 0) {
				percent -= speeds[i];
				ans++;
			}
			daysNeeded[i] = ans;
		}
		
		ArrayList al = new ArrayList<Integer>();
		int cnt = 1;
		int t = daysNeeded[0];
		for (int i=0; i<N; i++) {
			if (i>0) {
				if (t < daysNeeded[i]) {
					al.add(cnt);
					t = daysNeeded[i];
					cnt = 1;
				}
				else
					cnt++;
			}
			if (i == N-1)
				al.add(cnt);
		}
		System.out.println(al);
		
		answer = new int[al.size()];
		for (int i=0; i<al.size(); i++) {
			answer[i] = (int) al.get(i);
		}
		
	}

}
