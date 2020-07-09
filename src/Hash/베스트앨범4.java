package Hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
// Comparator, Comparable 연습 문제. + ArrayList + HashMap
/*
노래의 id, play, genre 를 담고있는 Song 객체를 만들어서 ArrayList에 삽입한다. 
동시에 각 장르별 play를 합산하여 HashMap에 기록한다.
Comparator를 생성하여 정렬한다.
정렬된 리스트를 바탕으로 베스트앨범 수록곡을 선정한다. 이때 장르별 2곡이라는 기준을 만족하기 위해 HashMap으로 장르별 수록곡 수를 저장한다.

1. 속한 노래가 많이 재생된 장르 먼저 수록
2. 장르 내에서 많이 재생된 노래 먼저 수록
3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록
*/

// Comparable은 일반적인 정렬, Comparator는 커스터마이즈(customize) 정렬에 사용
public class 베스트앨범4 {
	static class Song implements Comparable<Song> {
        int id; // 고유 번호
        int play;
        String genre;
        
        Song(int id, int play, String genre){
            this.id = id;
            this.play = play;
            this.genre = genre;
        }
        
        @Override
        public int compareTo(Song o){
            if(this.play == o.play) // play 수가 같으면 id(고유 번호) 기준 오름차순 정렬
                return this.id - o.id;
            else // play 수가 다르면 play 기준 내림차순 정렬
                return -(this.play - o.play);
        }
    }
 
	static ArrayList<Integer> bestAlbum;
    static ArrayList<Song> songList;
    static HashMap<String, Integer> genreMap; // (장르, 총 플레이 수)
    static HashMap<String, Integer> albumMap;

	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		int[] answer = {};

		bestAlbum = new ArrayList<>();
        songList = new ArrayList<>();
        genreMap = new HashMap<>();
        albumMap = new HashMap<>();
        
        // song 객체들 songList에 넣고, genreMap 완성
		for (int i = 0; i < genres.length; i++) {
			int id = i;
			int play = plays[i];
			String genre = genres[i];

			songList.add(new Song(id, play, genre));

			if (genreMap.containsKey(genre)) {
				genreMap.put(genre, genreMap.get(genre) + play);
			} else {
				genreMap.put(genre, play);
			}
		}
		// genreMap의 총 플레이 수를 기준으로 songList 정렬
		Collections.sort(songList, new Comparator<Song>() {
			@Override
			public int compare(Song s1, Song s2) {
				if (s1.genre.equals(s2.genre)) //장르가 같으면 play 기준 내림차순, play수도 같으면 고유 번호 기준 오름차순
					return s1.compareTo(s2);
				else // 장르가 다르면 장르별 총 재생수 기준 내림차순 정렬
					return -(genreMap.get(s1.genre) - genreMap.get(s2.genre));
			}
		});
		/*
		< compare() 메서드 작성법  >
		첫 번째 파라미터로 넘어온 객체 < 두 번째 파라미터로 넘어온 객체: 음수 리턴
		첫 번째 파라미터로 넘어온 객체 == 두 번째 파라미터로 넘어온 객체: 0 리턴
		첫 번째 파라미터로 넘어온 객체 > 두 번째 파라미터로 넘어온 객체: 양수 리턴
		음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 변경된다.
		즉, Integer.compare(x, y)(오름차순 정렬)와 동일한 개념이다.
		return (x < y) ? -1 : ((x == y) ? 0 : 1);
		내림차순 정렬의 경우 두 파라미터의 위치를 바꿔준다.
		Integer.compare(y, x)(내림차순 정렬)
		 */
		
		// 정렬된 리스트를 바탕으로 베스트앨범 수록곡 선정 
		// 이때 장르별 2곡이라는 기준을 만족하기 위해 HashMap으로 장르별 수록곡 수를 저장
		for (Song song : songList) {
			if (!albumMap.containsKey(song.genre)) {
				albumMap.put(song.genre, 1);
				bestAlbum.add(song.id);
			} else {
				int genreCnt = albumMap.get(song.genre);

				if (genreCnt >= 2)
					continue;
				else {
					albumMap.put(song.genre, genreCnt + 1);
					bestAlbum.add(song.id);
				}
			}
		}

		answer = new int[bestAlbum.size()];
		for (int i = 0; i < answer.length; ++i) {
			answer[i] = bestAlbum.get(i);
		}

		for (int i = 0; i < answer.length; ++i) {
			System.out.print(answer[i] + " ");
		}
		// return answer;
	}

}
