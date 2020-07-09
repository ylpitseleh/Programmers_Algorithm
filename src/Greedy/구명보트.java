package Greedy;

import java.util.Arrays;

public class 구명보트 {
// '최대 + 최소' 가 짝이 되어야 한다.
	public static void main(String[] args) {
		//int people[] = {70, 50, 80, 50};
		int people[] = {70, 80, 50};
		int limit  = 100;
		int answer = 0;
		Arrays.sort(people);
		int i=0, j=0;
        for(j=people.length-1; j>i; j--) {
        	if (people[j] + people[i] < limit)
        		i++;
        	answer++;
        }
        if (i==j)
        	answer++;
        
        System.out.println(answer);
		
	}

}
