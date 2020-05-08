package Hash;

import java.util.ArrayList;
import java.util.HashMap;

public class 베스트앨범4 {
	// 못 풀었음. 다시 풀어야 함
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		int[] answer = {};
		
		/*
		 * 1. 속한 노래가 많이 재생된 장르 먼저 수록
		 * 2. 장르 내에서 많이 재생된 노래 먼저 수록
		 * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록
		 */

		int N = genres.length;
		
		// 1. 장르 별 재생 된 횟수 구하기
		HashMap<String , Integer> PlaysPerGenre = new HashMap<String , Integer>();
		for (int i=0; i<N; i++) {
			if (PlaysPerGenre.containsKey(genres[i]))
				PlaysPerGenre.put(genres[i], PlaysPerGenre.get(genres[i]) + plays[i]);
			else
				PlaysPerGenre.put(genres[i], plays[i]);
		}
		
		System.out.println(PlaysPerGenre);
		
		// 2. 장르 별 몇 개의 attribute 있는지 구하기(ex. 클래식 3개 pop 2개)
		HashMap<String , Integer> ValuesPerGenre = new HashMap<String , Integer>();
		// 장르 별로 몇 개가 있는지 모르니까 ArrayList의 배열 만들기
		ArrayList<Integer> []a;
		a = new ArrayList[PlaysPerGenre.size()];
		for (int i=0; i<PlaysPerGenre.size(); i++)
			a[i] = new ArrayList<Integer>();
		
		for (int i=0; i<N; i++)
			if (ValuesPerGenre.containsKey(genres[i]))
				ValuesPerGenre.put(genres[i], ValuesPerGenre.get(genres[i]) + 1);
			else
				ValuesPerGenre.put(genres[i], 1);
		
		System.out.println(ValuesPerGenre);
		
	}

}
