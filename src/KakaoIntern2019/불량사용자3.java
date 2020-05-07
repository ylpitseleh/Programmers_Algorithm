package KakaoIntern2019;

import java.util.ArrayList;
import java.util.HashSet;

public class 불량사용자3 {

	public static void main(String[] args) {
		//String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		//String[] banned_id = {"fr*d*", "abc1**"};
		
		//String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		//String[] banned_id = {"*rodo", "*rodo", "******"};
		
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		
		ArrayList<String> []a;
		a = new ArrayList[banned_id.length]; //경우의 수 최대값
		for (int i=0; i<banned_id.length; i++)
			a[i] = new ArrayList<String>();
		
		int idx = 0;
		for (int i=0; i<banned_id.length; i++) {
			for (int j=0; j<user_id.length; j++) {
				int diffFlag = 0;
				if (banned_id[i].length() != user_id[j].length())
					continue ;
				for (int k=0; k<banned_id[i].length(); k++) {
					if (banned_id[i].charAt(k) == '*')
						continue ;
					if (banned_id[i].charAt(k) != user_id[j].charAt(k))
						diffFlag = 1;
				}
				if (diffFlag == 0) {
					//System.out.println(user_id[j]);
					a[idx].add(user_id[j]);
					
				}
			}
			idx++;
		}
		for (int i=0; i<banned_id.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println();
		/*
		ArrayList<String> []ansTmp;
		ansTmp = new ArrayList[banned_id.length]; //경우의 수 최대값
		for (int i=0; i<banned_id.length; i++)
			ansTmp[i] = new ArrayList<String>();
		*/
		HashSet<String> []ansTmp;
		ansTmp = new HashSet[banned_id.length];
		for (int i=0; i<banned_id.length; i++)
			ansTmp[i] = new HashSet<String>();
		
		//HashSet<String> hs = new HashSet<String>();
		int flag = 0;
		for (int i=0; i<a.length; i++) { // 4
			flag = 0;
			for (int j=0; j<a[i].size(); j++) { // 2
				//System.out.println(a[i].get(j));
				/*
				for (int k=0; k<ansTmp.length; k++) {
					if (!ansTmp[k].contains(a[i].get(j))) {
						ansTmp[k].add(a[i].get(j));
						flag = 1;
						//break ;
					}
				}*/
				for (int k=0; k<ansTmp.length; k++) {
					ansTmp[k].add(a[i].get(j));
				}
				if (flag == 1)
					break ;
			}
		}
		
		for (int i=0; i<banned_id.length; i++) {
			System.out.println(ansTmp[i]);
		}
	}

}
