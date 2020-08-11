package level2;
/*
 * 소요 시간: 15분
 * ☆☆☆☆☆, Cheating : X
 */
public class JadenCase문자열만들기 {

	public static void main(String[] args) {
		String s = "3people unFollowed me";
		//String s = "for the last week";
		
		String answer = "";
		
		StringBuilder sb = new StringBuilder();
		sb.append(Character.toString(s.charAt(0)).toUpperCase());
		for (int i=1; i<s.length(); i++) {
			String tmp = Character.toString(s.charAt(i));
			if (s.charAt(i-1)==' ') {
				tmp = tmp.toUpperCase();
			}
			else {
				tmp = tmp.toLowerCase();
			}
			//System.out.print(tmp);
			//System.out.println();
			sb.append(tmp);
			
		}
		
		System.out.println(sb);
		
	}
}
