package level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
/*
 * 소요 시간: 1시간
 * ★★☆☆☆, Cheating : X
 * 설계를 다 하고 풀었더니 생각보다 빨리 풀었다. 첨엔 hm이 정렬 하려면 복잡하니까 써야하나 말아야하나 고민하다가
 * 그냥 hm쓰고 gAl에 그대로 넣어서 gAL을 정렬시켰다. 
 */
public class 베스트앨범 {
	static class Song {
		int index;
		int play;
		String genre;

		Song(int index, int play, String genre) {
			this.index = index;
			this.play = play;
			this.genre = genre;
		}
	}

	static class Genre {
		String name;
		int play;

		Genre(String name, int play) {
			this.name = name;
			this.play = play;
		}
	}

	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		int[] answer = {};
		HashMap<String, Integer> hm = new HashMap<>();
		ArrayList<Genre> gAl = new ArrayList<>(); // hm 내림차순 정렬 

		ArrayList<Song> al = new ArrayList<>();
		// input을 al, hm에 넣기
		for (int i = 0; i < genres.length; i++) {
			al.add(new Song(i, plays[i], genres[i]));
			if (!hm.containsKey(genres[i]))
				hm.put(genres[i], plays[i]);
			else
				hm.put(genres[i], hm.get(genres[i]) + plays[i]);
		}
		
		// hm을 gAl에 넣어서 내림차순 정렬하기 (장르, 재생수)
		for (HashMap.Entry<String, Integer> entry : hm.entrySet()) {
			gAl.add(new Genre(entry.getKey(), entry.getValue()));
		}
		
		Collections.sort(gAl, new Comparator<Genre>() {
			@Override
			public int compare(Genre g1, Genre g2) {
				Integer G1 = g1.play;
				Integer G2 = g2.play;
				return G2.compareTo(G1);
			}
		});
		
		// 재생 기준 내림차순 정렬
		Collections.sort(al, new Comparator<Song>() {
			@Override
			public int compare(Song s1, Song s2) {
				Integer S1 = s1.play;
				Integer S2 = s2.play;
				return S2.compareTo(S1);
			}
		});
		
		for (int i = 0; i < al.size(); i++) {
			Song s = al.get(i);
			System.out.println(s.genre + " " + s.play);
		}
		
		HashMap<String, Integer> hmCnt = new HashMap<>(); // 장르별 몇 개씩 들어갔는지 카운트 (최대 2개)
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i=0; i<gAl.size(); i++) {
			Genre g = gAl.get(i);
			for (int j=0; j<al.size(); j++) {
				Song s = al.get(j);
				if (s.genre.equals(g.name)) {
					if (!hmCnt.containsKey(s.genre)) {
						hmCnt.put(s.genre, 1);
						ans.add(s.index);
					}
					else if (hmCnt.get(s.genre) <= 1) {
						hmCnt.put(s.genre, hmCnt.get(s.genre)+1);
						ans.add(s.index);
					}
					else
						break ;
				}
			}
		}
		
		answer = new int[ans.size()];
		for (int i=0; i<ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		System.out.println(ans);
	}

}
