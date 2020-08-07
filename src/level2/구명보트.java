package level2;

import java.util.Arrays;
/*
 * 소요 시간: 50분
 * ★★☆☆☆, Cheating : X
 * 별 생각 없이 2중 포문으로 풀다가 시간초과 나는 것 보고 Array Sort 한데다가 그리디 알고리즘이니 
 * 1중 포문 안에서 해결할 수 있을거다 싶어서 생각해보니까 start idx 랑 end idx만 늘려주고 줄여주면 되는거였다.
 */
public class 구명보트 {

	public static void main(String[] args) {
		int people[] = {70, 50, 80, 50}; // 50 50 70 80 
		//int people[] = { 70, 80, 50 }; // 50 70 80
		//int people[] = { 10, 20, 30, 40, 50 }; // 50 70 80
		int limit = 100;
		//int limit = 60;
		
		int answer = 0;
		
		Arrays.sort(people);
		// 50 50 70 80
		int i = 0;
		int j = people.length-1;
		while (true) {
			if (i > j)
				break ;
			//System.out.println(people[i]+" "+people[j]+" "+i+" "+j+" answer: "+answer);
			int sum = people[i] + people[j];
			if (i == j)
				sum = people[i];
			if (sum <= limit) {
				i++;
				j--;
				answer++;
				continue; 
			}
			j--;
			answer++;
		}
		System.out.println(answer);
	}

}
