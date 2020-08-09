package level2;
/*
 * 소요 시간: 40분
 * ☆☆☆☆☆, Cheating : O
 * 이진수 변환하는거 직접 구현했다가 효율성 다 터져서 bitCount라는 메소드가 있다길래 갖다 썼당. 허무한 문제.
 * 메소드 잘 아는 것도 중요한듯. 
 * 프로그래머스 풀면서 String startsWith랑 toBinaryString이랑 bitCount 새로 알게됐당.
 */
public class 다음큰숫자 {

	public static void main(String[] args) {
		int n = 78;
		//int n = 15;

		int answer = 0;
		/*
		int nOneCnt = findBinaryN(n);
		int nPlus = n;
		while (true) {
			nPlus++;
			int nPlusOneCnt = findBinaryN(nPlus);
			if (nOneCnt == nPlusOneCnt)
				break ;
		}
		System.out.println(nPlus);
		*/
		int bitCnt = Integer.bitCount(n);
		while (true) {
			n++;
			if (Integer.bitCount(n) == bitCnt)
				break ;
		}
		System.out.println(n);
	}
	/*
	private static String findBinaryN(int n) {
		String s = "";
		int oneCnt = 0;
		while (n > 0) {
			int remain = n % 2;
			s = Integer.toString(remain)+s;
			n /= 2;
			if (remain == 1)
				oneCnt++;
		}
		
		return s;
	}
	*/
}
