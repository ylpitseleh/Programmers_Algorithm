package Greedy;

import java.util.Arrays;

public class 저울 {

	public static void main(String[] args) {
		int weight[] = {3,1,6,2,7,30,1};
		// 1,1,2,3,6,7,30
		int answer = 1;
        Arrays.sort(weight);
        for(int w : weight) {
        	if(answer < w)
        		break;
        	answer += w;
        	System.out.println(w+" "+answer);
        }
		
        System.out.println(answer);
	}

}
