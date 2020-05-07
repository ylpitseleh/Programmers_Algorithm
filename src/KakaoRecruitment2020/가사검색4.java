package KakaoRecruitment2020;

public class 가사검색4 {

	public static void main(String[] args) {
		String words[] = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String queries[] = {"fro??", "????o", "fr???", "fro???", "pro?", "?????"};
		int answer[] = {}; 
		
		answer = new int[queries.length];
		int cnt = 0;
		int diffFlag = 0;
		for (int i=0; i<queries.length; i++) {
			cnt = 0;
			for (int j=0; j<words.length; j++) {
				diffFlag = 0;
				for (int k=0; k<queries[i].length(); k++) {
					if (queries[i].length() != words[j].length()) {
						diffFlag = 1;
						break ;
					}
					//접미사일때
					if (k>0 && queries[i].charAt(k-1) != '?' && queries[i].charAt(k) == '?') { 
						diffFlag = 0;
						System.out.println("queries : "+queries[i]);
						break ;
					}
					//접두사일때
					if (queries[i].charAt(k) == '?') {
						continue ;
					}
					if (queries[i].charAt(k) != words[j].charAt(k)) {
						diffFlag = 1;
						break ;
					}
				}
				if (diffFlag == 0) {
				//	System.out.print(words[j]+" ");
					cnt++;
				}
			}
			System.out.println();
			answer[i] = cnt;
		}
		
		for (int i=0; i<queries.length; i++)
			System.out.print(answer[i]+" ");

	}

}
