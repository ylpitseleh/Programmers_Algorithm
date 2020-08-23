package level3;
/*
 * 소요 시간: 1시간
 * ★★☆☆☆, Cheating : O
 * 원래 substring으로 i, j 끊어서 따로 함수 빼서 했는데 효율성 한 문제만 틀렸다고 해서 보니 substring이 시간을 많이 잡아먹는 것 같았다. 
 * 그래서 함수 뺀거 없애고 다시 넣었는데 뭐 때문인지 substring에서 끝 인덱스가 개같이 나와서 그냥 베꼈다.
 */
public class 가장긴팰린드롬 {

	public static void main(String[] args) {
		String s = "abcdcba";
		//String s = "abaacde";
		//String s = "abba";
		int answer = 1;
		/*
		 * i=1이면
		 * 0, 2
		 * 
		 * i=2면
		 * 0, 4 / 1, 3
		 * 
		 * 3 이면
		 * 2, 4 / 1, 5 / 0, 6
		 * 
		 * i=4면
		 * 3, 5 / 2, 6
		 */
		for (int i=s.length(); i>2; i--) { // 문자열 길이 (긴 것부터 검사)
			for (int j=0; j+i <= s.length(); j++) { // 시작 인덱스
				boolean isPalindrome = true;
				
				for (int k=0; k<i/2; k++) {
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
