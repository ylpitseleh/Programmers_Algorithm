package level2;
/*
 * 소요 시간: 1시간 30분
 * ★★★★☆, Cheating : O
 * alpha[]에 있는 ▲, ▼로 움직이는 값들은 for문 안에서 왔다갔다 하면서 구해줄 필요가 없었다 !! => 이건 정해진 값이라 그냥 for문 한 번으로 쫙 더해주기만 하면 되고
 * ◀ , ▶로 움직이는 값들이 문제인데 ▶로만 움직이는 경우, ◀까지 사용하는 경우 생각해서 두 가지 중에 최소값만 구해주면 끝.
 * 괜히 어렵게 생각한 것 같다.
 */
public class 조이스틱 {

	public static void main(String[] args) {
		String name = "JAZ";
		// String name = "JEROEN";
		// String name = "JAN";
		// String name = "JAZAAAAAZ";

		int answer = 0;

		int alpha[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		int exp = name.length() - 1; // 첫글자부터 끝글자까지 순서대로 이동하는 경우.
		for (int i = 0; i < name.length(); i++) {
			answer += alpha[name.charAt(i)-'A'];

			// A 아닌 모든 문자를 들릴 수 있는 최소 좌우 이동
			// 모든 위치에서 역으로 돌아가는 경우 최소를 찾는다.
			if (name.charAt(i) == 'A') {
				int nextIdx = i + 1;
				int countA = 0;
				// 다음 인덱스부터 A가 몇 개 연속으로 나오는지 탐색
				while (nextIdx < name.length() && name.charAt(nextIdx) == 'A') {
					countA++;
					nextIdx++;
				}
				int tmp = (i - 1) * 2 + (name.length() - 1 - i - countA);
				/*
				 * tmp = (i-1)*2 + (name.length()-1-i-countA); BBBB[A]AAAABBB 일 때 0에서 []위치로 갔다가
				 * 다시 0으로 가기 = (i-1)*2 맨 끝에서 []로 가기 = (name.length()-1-i-countA)
				 */
				exp = Math.min(exp, tmp);
			}
		}
		
		answer += exp;
		System.out.println(answer);
	}

}
