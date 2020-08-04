package level2;

import java.util.ArrayList;
/*
 * 소요 시간: 1시간 15분
 * ★★★☆☆, Cheating : O
 * 주석처리 한 것 처럼 일일이 구현했다가 정확도 100 효율성 0 맞아서 답 보니 식으로 푸는 거였다.
 * 이 문제처럼 인풋이 5억같이 터무늬없이 크면 바로 눈치까고 식으로 풀어야 할 듯. 
 * 심지어 리턴값도 String이니 절대 일일이 계산하지 말란 소리임.
 */
public class _124나라의숫자 {
	//124 
			/*
			 * 1 2 4 
			 * 11 12 14
			 * 21 22 24
			 * 41 42 44
			 * 111 112 114
			 * 121 122 124
			 */
	public static void main(String[] args) {
		int n = 7;
		String answer = "";
		
		String[] num = {"4", "1", "2"};
		
		while (n > 0) {
			int remainder = n % 3;
			n /= 3;
			if (remainder == 0)
				n--;
			answer = num[remainder] + answer;
		}
		
		System.out.println(answer);
	}
	
	/*
	public static void main(String[] args) {
		int n = 50000000;
		String answer = "";
		
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("1");
		al.add("2");
		al.add("4");
		if (n == 1 || n == 2) {
			System.out.println(n);
			return ;
		}
		if (n == 3) {
			System.out.println(4);
			return ;
		}
		
		while (true) {
			al = add124(al, n);
			if (endFlag == true)
				break ;
		}
		System.out.println(al+" "+n);
		System.out.println(ans);
	}
	
	static int cnt = 3;
	static boolean endFlag = false;
	static String ans = "";
	
	private static ArrayList<String> add124(ArrayList<String> a, int n) {
		ArrayList<String> newAl = new ArrayList<String>();
		String nums[] = {"1", "2", "4"};
		
		for (int j=0; j<3; j++) {
			for (int i=0; i<a.size(); i++) {
				if (cnt == n-1) {
					endFlag = true;
					ans = nums[j]+a.get(i);
					return newAl;
				}
				newAl.add(nums[j]+a.get(i));
				cnt++;
			}
		}

		return newAl;
	}
	*/

}
