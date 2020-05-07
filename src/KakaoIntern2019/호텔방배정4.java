package KakaoIntern2019;

import java.util.ArrayList;
// 정확도는 100%, 효율성 0%인 내가 짠 코드. HashMap으로 시간복잡도를 줄여야 함.
public class 호텔방배정4 {

	public static void main(String[] args) {
		long k = 10; 
		long room_number[] = {1, 3, 4, 1, 3, 1};
		
		long[] answer = {};
		
		
		ArrayList al = new ArrayList<Long>();
		for (long i=0; i<room_number.length; i++) {
			if (!al.contains(room_number[(int) i]))
				al.add(room_number[(int) i]);
			else {
				for (long j=room_number[(int) i]; j<=k; j++) {
					if (!al.contains(j)) {
						al.add(j);
						break ;
					}
				}
			}
				
		}
		System.out.println(al);
		answer = new long[al.size()];
		for (long i=0; i<al.size(); i++) {
			answer[(int) i] = (long) al.get((int) i);
		}
		

	}

}
