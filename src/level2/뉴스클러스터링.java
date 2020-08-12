package level2;
/*
 * 소요 시간: 1시간 30분
 * ★★★☆☆, Cheating : X
 * 후.... 생각보다 하드코어였다... 30분만에 뚝딱 끝낼 줄 알았는데 
 * 다중집합 합집합 교집합 만드는게 복병이었다. ArrayList써야하나 해시맵으로 되나 계속 지우고 고치고 하다가 
 * HashMap iter 돌려서 해결했다. 
 * 쉬운듯 까다로운 문제. 잡힐듯 안 잡혀서 열받으면서 풀었다.
 */
import java.util.HashMap;

public class 뉴스클러스터링 {

	public static void main(String[] args) {
		/*
		String str1 = "FRANCE";
		String str2 = "french";
		*/
		/*
		String str1 = "handshake";
		String str2 = "shake hands";
		*/
		/*
		String str1 = "aa1+aa2";
		String str2 = "AAAA12";
		*/
		
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		
		
		int answer = 0;

		String s1 = str1.toUpperCase();
		String s2 = str2.toUpperCase();
		
		HashMap<String, Integer> hm1 = new HashMap<>();
		HashMap<String, Integer> hm2 = new HashMap<>();
		
		for (int i=0; i<s1.length()-1; i++) {
			String s = s1.substring(i, i+2);
			if (!('A' <= s.charAt(0) && s.charAt(0) <= 'Z' && 
					'A' <= s.charAt(1) && s.charAt(1) <= 'Z'))
				continue ;
			if (hm1.containsKey(s))
				hm1.put(s, hm1.get(s)+1);
			else
				hm1.put(s, 1);
		}
		for (int i=0; i<s2.length()-1; i++) {
			String s = s2.substring(i, i+2);
			if (!('A' <= s.charAt(0) && s.charAt(0) <= 'Z' && 
					'A' <= s.charAt(1) && s.charAt(1) <= 'Z'))
				continue ;
			if (hm2.containsKey(s))
				hm2.put(s, hm2.get(s)+1);
			else
				hm2.put(s, 1);
		}
		System.out.println(hm1);
		System.out.println(hm2);
		
		int sum = 0; //합집합 원소 개수
		int inter = 0; //교집합 원소 개수

		for (HashMap.Entry<String, Integer> entry : hm1.entrySet()) {
			if (hm2.containsKey(entry.getKey())) {
				sum += Math.max(entry.getValue(), hm2.get(entry.getKey()));
		    	inter += Math.min(entry.getValue(), hm2.get(entry.getKey()));
		    }
			else {
				sum += entry.getValue();
			}
		}
		
		for (HashMap.Entry<String, Integer> entry : hm2.entrySet()) {
			if (!hm1.containsKey(entry.getKey()))
				sum += entry.getValue();
		}

		System.out.println(sum);
		System.out.println(inter);
		
		if (sum == 0 && inter == 0) {
			answer = 1 * 65536;
			System.out.println(answer);
			return ;
		}
		double ans = (double)inter / (double)sum;
		answer = (int)Math.floor(ans * 65536);
		System.out.println(answer);
		
		
	}

}
