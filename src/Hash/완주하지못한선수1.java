package Hash;

import java.util.HashMap;
/*
 * map.put("ㅇㅇㅇ", new Integer(90));
 * if(map.containsKey("ㅇㅇㅇ"))
 */
public class 완주하지못한선수1 {

	public static void main(String[] args) {
		String participant[] = {"leo", "kiki", "eden", "eden"};
		String completion[] = {"eden", "kiki", "leo"};
		String answer = "";
		
		HashMap<String , Integer> hm = new HashMap<String , Integer>();
		
		for (int i=0; i<participant.length; i++) {
			if (!hm.containsKey(participant[i]))
				hm.put(participant[i], 1);
			else
				hm.put(participant[i], hm.get(participant[i]) + 1);
		}
		
		for (int i=0; i<completion.length; i++) {
			hm.put(completion[i], hm.get(completion[i])-1);
		}
		
		for (int i=0; i<participant.length; i++) {
			if (hm.get(participant[i]) == 1)
				answer = participant[i];
		}
		
		System.out.println(answer);
		

	}

}
