package KakaoIntern2019;

import java.util.ArrayList;
import java.util.HashMap;
// 쉬운데 어렵다. 어려운데 쉽다. HashMap과 친해지자. HashMap은 O(1)으로 빠르다.
public class 호텔방배정4_모범답안 {

	public static void main(String[] args) {
		long k = 10; 
		long room_number[] = {1, 3, 4, 1, 3, 1};
		long[] answer = {};
		
		int N = room_number.length;
		answer = new long[N];
		HashMap<Long, Long> hm = new HashMap();
		// HashMap 의 key : 현재 숫자, value : key보다 큰 수 중 차이가 가장 작은 수 중에 available 한 곳(비어있는 곳)
		// hm.get(10)=15의 의미는 "10번방을 가고싶은데 실제론 15번을 배정받는다"의 의미
		for (int i=0; i<N; i++) {
			long x = room_number[i];
			
			if (!hm.containsKey(x)) { // HashMap에 x가 없으면 그냥 간단히 넣어주고 value에 x+1
				answer[i] = x;
				hm.put(x, x+1);
			}
			
			else { // HashMap에 x가 있다면
				ArrayList al = new ArrayList<Long>();
				// 2,4 -> 4,5 -> 5,.. 이런식으로 연결된 끝 값이 나올때까지 찾아서 x에 넣음
				while (hm.containsKey(x)) {
					al.add(x);
					x = hm.get(x);
				}
				
				al.add(x); //while문에서 찾은 끝 값 까지 ArrayList에 넣어줌
				answer[i] = x; //while문에서 찾은 끝 값이 답이니까 answer에 넣어줌
				// list에 들어간 모든 수의 value를 x+1로 변경.
				for (long j=0; j<al.size(); j++) {
					hm.put((Long) al.get((int) j), x+1);
				}
				/*
				 for (long l:list)
				 	hm.put(l, x+1); 람다식으로 이렇게도 쓸 수 있지요.
				*/
 			}
		}
		
		for (int i=0; i<N; i++)
			System.out.print(answer[i]);
	}

}
