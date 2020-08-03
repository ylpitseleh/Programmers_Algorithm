package level2;

import java.util.ArrayList;
/*
 * 소요 시간: 20분
 * ★☆☆☆☆, Cheating : X
 * Stack이나 Queue를 사용해서 풀 필요가 없다.
 */
public class 기능개발 {
	public static void main(String[] args) {
		int progresses[] = {93,30,55};
		int speeds[] = {1,30,5};
		
		//int progresses[] = {95};
		//int speeds[] = {4};
				
		
		int answer[] = {};
		
		int daysNeeded[] = new int[progresses.length];
		for (int i=0; i<progresses.length; i++) {
			daysNeeded[i] = (100 - progresses[i]) / speeds[i];
			if ((100 - progresses[i]) % speeds[i] != 0)
				daysNeeded[i]++;
			//System.out.print(daysNeeded[i]+" ");
		}
		
		int max = 0;
		int cnt = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i=0; i<daysNeeded.length; i++) {
			if (max < daysNeeded[i]) {
				max = daysNeeded[i];
				if (cnt != 0) {
					System.out.println(max+" "+daysNeeded[i]+" "+cnt);
					al.add(cnt);
				}
				cnt = 0;
			}
			cnt++;
		}
		al.add(cnt);
		//System.out.println(al);

		
		// arraylist -> answer array로 변환
		answer = new int[al.size()];
		for (int i=0; i<al.size(); i++) {
			answer[i] = al.get(i);
		}
	}

}
