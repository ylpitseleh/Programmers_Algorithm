package level3Second;

public class 가장긴팰린드롬 {

	public static void main(String[] args) {
		String s = "abcdcba";
		//String s = "abaacde";
		//String s = "abba";
		int answer = 1;
		
		for (int i=s.length(); i>2; i--) { // 문자열 길이 (긴 것부터 검사. Palindrome이면 리턴으로 끝내기.)
			for (int j=0; j+i <= s.length(); j++) { // 시작 인덱스
				boolean isPalindrome = true;
				
				for (int k=0; k<i/2; k++) { // aba 일 수도, abba 일 수도 있으니까 이 부분이 팰린드롬 체크할 때 이 부분 꼭 필요.
					if (s.charAt(j+k) != s.charAt((j+i)-k-1)) {
						isPalindrome = false;
						break ;
					}
				}
				if (isPalindrome) {
					answer = i;
					System.out.println(answer);
					return ;
				}
			}
		}
		System.out.println(answer);
	}

}
