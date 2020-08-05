package KakaoRecruitment2020;

import java.util.ArrayList;
// 진심 개더럽게 풀었다. 두 시간 걸렸나.. 그치만 이게 최선이고 맞은게 기적이다.
public class 문자열압축1 {

	public static void main(String[] args) {
		//String s = "aabbaccc";
		//String s = "aaaaababac";
		//String s = "ababcdcdababcdcd";
		//String s = "abcabcdede";
		//String s = "abcabcabcabcdededededede";
		//String s = "xababcdcdababcdcd";
		String s = "abababaaaaaaaa";
		
		String ans = null;
		int answer = Integer.MAX_VALUE;
		// 1개 단위 : 2a2ba3c
		int sLen = s.length();
		int cnt = 1;
		for (int i=1; i<=sLen/2; i++) { // 1개 단위, 2개 단위, ...
			ArrayList al = new ArrayList<String>();
			cnt = 1;
			ans = "";
			for (int j=0; j<sLen; j+=i) {
				if (j+i >= sLen) { //al 맨 마지막 원소
					String tmpS = s.substring(j, sLen);
					al.add(tmpS);
					//System.out.println(al);
					if (al.get(al.size()-2).equals(tmpS)) { // 같으면
						cnt++;
						if (cnt > 1)
							ans += Integer.toString(cnt);
						ans += al.get(al.size()-2);
					}
					else { // 다르면
						if (cnt > 1)
							ans += Integer.toString(cnt);
						ans += al.get(al.size()-2);
						ans += al.get(al.size()-1);
					}
				}
				else { // 맨 마지막 빼고 나머지 모든 원소들
					String tmpS = s.substring(j, j+i);
					al.add(tmpS);
					if (al.size() > 1) {
						//System.out.println(al.get(al.size()-2)+", "+tmpS);
						System.out.println(al);
						if (al.get(al.size()-2).equals(tmpS)) { // 같으면 
							cnt++; //al.get(al.size()-2)인 이유 = 나 말고 내 바로 앞에 있는거랑 비교하기 위해서
						}
						else { // 다르면
							if (cnt > 1)
								ans += Integer.toString(cnt);
							ans += al.get(al.size()-2);
							cnt = 1;
						}
					}
				}
			}
			//System.out.println(answer);
			answer = Math.min(answer, ans.length());
		}
		if (answer == Integer.MAX_VALUE) {
			System.out.println(s.length());
		}
		else
			System.out.println(answer);
	}

}
