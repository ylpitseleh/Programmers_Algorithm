package level2;
/*
 * 소요 시간: 45분
 * ★★☆☆☆, Cheating : X
 * 복잡쓰 더럽쓰 하지만 나한텐 쨉도 안 되는 문제.
 * convert 메소드 최적화 시켜야하는데 어차피 이런 진수변환 코테에 안 나올지 않나 싶어서 냅둘래.
 * 다른사람 코드 보니까 이런식으로 해도 될 듯
 * char 배열 ['0', '1', '2', ..., 'A', 'B', 'C', ...]
 */
public class n진수게임 {

	public static void main(String[] args) {
		/*
		int n = 2; // 진법
		int t = 4; // 미리 구할 숫자의 개수
		int m = 2; // 게임에 참가하는 인원
		int p = 1; // 튜브의 순서 
		*/
		
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 1;
		
		
		String answer = "";

		//0 1 10 11 100 101 110 111 (2진법)
		int num = 0;
		String all = "";
		while (all.length() <= t*m) {
			String s = convert(num, n);
			all += s;
			num++;
		}
		//System.out.println(all);
		
		int i = 0;
		while (answer.length() < t) {
			if (i % m + 1 == p) 
				answer += Character.toString(all.charAt(i));
			i++;
		}
		System.out.println(answer);
		
	}

	// N = 구할 숫자, n = 진법
	private static String convert (int N, int n) { 
		String s = "";
		while (N / n > 0) {
			if (10 <= N % n && N % n <= 15) {
				char tmpChar = 0;
				tmpChar = (char) ((N % n - 10) + 'A');
				s = Character.toString(tmpChar) + s;
			}
			else {
				int tmpInt = N % n;
				s = Integer.toString(tmpInt) + s;
			}
			N /= n;
		}
		if (10 <= N % n && N % n <= 15) {
			char tmpChar = 0;
			tmpChar = (char) ((N % n - 10) + 'A');
			s = Character.toString(tmpChar) + s;
		}
		else {
			int tmpInt = N % n;
			s = Integer.toString(tmpInt) + s;
		}
		//System.out.println(s);
		return s;
	}
}
