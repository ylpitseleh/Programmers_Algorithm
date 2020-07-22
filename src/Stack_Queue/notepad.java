package Stack_Queue;

import java.util.ArrayList;

public class notepad {

	public static void main(String[] args) {
		int progresses[] = {93,30,55};
		int speeds[] = {1,30,5};
		
		//int progresses[] = {95};
		//int speeds[] = {4};
				
		
		int answer[] = {};
		
		int n = progresses.length;
		
		int deployAvail[] = new int[n]; 
		for (int i=0; i<n; i++) {
			deployAvail[i] = (100 - progresses[i]) / speeds[i];
			if ((100 - progresses[i]) % speeds[i] != 0)
				deployAvail[i]++;
		}
		// 7 3 9
		ArrayList<Integer> al = new ArrayList<Integer>();
		int ansTmp = 1;
		int num = deployAvail[0];
		for (int i=1; i<n; i++) {
			if (num >= deployAvail[i]) {
				ansTmp++;
			}
			else {
				al.add(ansTmp);
				ansTmp = 1;
				num = deployAvail[i];
			}
		}
		al.add(ansTmp);
		System.out.println(al);
		
		answer = new int[al.size()];
		for (int i=0; i<al.size(); i++) {
			answer[i] = al.get(i);
		}
		
		for (int i=0; i<n; i++) {
			System.out.print(deployAvail[i]+" ");
		}
		
	}

}
