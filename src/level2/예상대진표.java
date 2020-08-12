package level2;
/*
 * 소요 시간: 1시간
 * ★★☆☆☆, Cheating : O
 * 배열로 풀었다가 테케 4개정도가 틀려서 고뇌하다가 답 보고
 * 또!! 연산이라는걸 알았다. 인풋이 크다? 연산이다!
 * 거의 다 왔는데 아쉽게 못 풀었다.
 */
public class 예상대진표 {

	public static void main(String[] args) {
		
		int n = 8; // 게임 참가자 수
		int a = 4; // 참가자 번호
		int b = 7; // 경쟁자 번호
		
		/*
		int n = 16; // 게임 참가자 수
		int a = 8; // 참가자 번호
		int b = 6; // 경쟁자 번호 
		*/
		int answer = 0;
		/*
		int arr[] = new int[n+1];
		for (int i=1; i<=n; i++) {
			arr[i] = i;
		}
		if (Math.abs(b-a) == 1 && Math.max(a, b) % 2 == 0) {
			answer = 1;
			System.out.println(answer);
			return ;
		}
		
		while (n > 0) {
			n /= 2;
			int newArr[] = new int[n+1];
			boolean breakFlag = false;
			for (int i=1; i<=n; i++) {
				if (arr[i*2] == a || arr[i*2] == b)
					newArr[i] = arr[i*2];
				else if (arr[i*2-1] == a || arr[i*2-1] == b)
					newArr[i] = arr[i*2-1];
				else
					newArr[i] = arr[i]*2;
				if ((newArr[i] == a && newArr[i-1] == b) || (newArr[i] == b && newArr[i-1] == a)) {
					breakFlag = true;
					break ;
				}
			}
			for (int i=1; i<=n; i++) {
				System.out.print(newArr[i]+" ");
			}
			System.out.println();
			arr = newArr;
			answer++;
			if (breakFlag)
				break ;
		}
		*/
		while (a != b) {
			a = (a + 1) / 2;
			b = (b + 1) / 2;
			answer++;
		}
		System.out.println(answer);
	}

}
