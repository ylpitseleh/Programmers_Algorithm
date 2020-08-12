package level2;

import java.util.HashSet;
/*
 * 소요 시간: 30분
 * ★☆☆☆☆, Cheating : X
 * 바보같이 else 에서 HashSet에 add하는걸 깜빡했었다.
 */
public class 영어끝말잇기 {

	public static void main(String[] args) {
		/*
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", 
				"robot", "tank"};
		int n = 3;
		*/
		/*
		String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", 
		"hang", "gather", "refer", "reference", "estimate", "executive"};
		int n = 5;
		*/
		/*
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		int n = 2;
		*/
		String[] words = {"qwe", "eqwe", "eqwe"};
		int n = 2;
		
		int[] answer = {};
		
		int num = -1;
		HashSet<String> hs = new HashSet<>();
		hs.add(words[0]);
		for (int i=1; i<words.length; i++) {
			if (hs.contains(words[i]) || !(words[i].startsWith(Character.toString(words[i-1].charAt(words[i-1].length()-1))))) {
				num = i + 1;
				break ;
			}
			else {
				hs.add(words[i]);
			}
		}
		//System.out.println(num);
		answer = new int[2];
		if (num == -1) {
			answer[0] = answer[1] = 0;
		}
		else {
			answer[0] = num % n == 0? n : num % n;
			answer[1] = num % n == 0? num / n : num / n + 1; 
		}
		
		System.out.println(answer[0]+" "+answer[1]);
	}

}
