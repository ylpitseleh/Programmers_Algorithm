package level2;

import java.text.ParseException;
import java.util.Arrays;
/*
 * 소요 시간: 2시간
 * ★★★☆☆, Cheating : X
 * 푸는건 1시간 30분만에 풀었는데 테케 5개가 틀려서 디버깅하는데 30분 썼다. 주석처리한 for문 안에 if문 지우니까 맞았다. 왠진 모르겠다 ㅠㅠ
 */
public class 방금그곡 {
	
	public static void main(String[] args) throws ParseException {
		/*
		String m = "ABCDEFG"; 
		String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		*/
		/*
		String m = "CC#BCC#BCC#BCC#B"; 
		String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		*/
		/*
		String m = "ABC"; 
		String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		*/
		String m = "ABC#"; 
		String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:09,WORLD,ABC"};
		
		String answer = "";
		// 굳이 이렇게 안 하고 # 붙은건 replaceAll 하면 됐을 듯.
		String notesAll[] = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
							//A    B     C    D     E    F     G    H    I     J    K     L
		
		// m을  A~L로 변환 (# 없애야 함)
		String mNew = ""; 
		for (int i=0; i<m.length(); i++) {
			if (m.charAt(i) == '#')
				continue ;
			int loc = Arrays.asList(notesAll).indexOf(Character.toString(m.charAt(i)));
			if (i != m.length()-1 && m.charAt(i+1) == '#') {
				loc = Arrays.asList(notesAll).indexOf(m.substring(i, i+2));
			}
			mNew += Character.toString((char)(loc+'A'));
		}
		System.out.println("mNew = "+mNew);
		
		// 답이 복수일 때 음악 길이 저장
		int longestSong = 0;
		
		for (int x=0; x<musicinfos.length; x++) {
			String[] s = musicinfos[x].split(",");
			// musicInfo들 parsing (노래 길이, 이름, 악보 정보)
			String startTime = s[0];
			String endTime = s[1];
			int hourDiff = Integer.parseInt(endTime.substring(0, 2)) - Integer.parseInt(startTime.substring(0, 2));
			int minDiff = Integer.parseInt(endTime.substring(3, 5)) - Integer.parseInt(startTime.substring(3, 5));
			int songLen = hourDiff * 60 + minDiff;
			//System.out.println(songLen);
			String songName = s[2];
			String notes = s[3];
			
			// 이 조건 없애야 답 맞음 ㅠㅠ 왠진 잘 모르겠음. 네오가 기억한 멜로디가 실제 방송된 곡의 길이보다 길 수 없지 않나?..
			//if (m.length() > songLen) // 네오가 기억한 멜로디가 방송된 곡의 길이보다 길면 continue 
				//continue ;  
			
			// notes를  A~L로 변환 (# 없애야 함)
			String notesNew = "";
			for (int i=0; i<notes.length(); i++) {
				if (notes.charAt(i) == '#')
					continue ;
				// String array에서 indexOf하려면 이렇게 해야함.
				int loc = Arrays.asList(notesAll).indexOf(Character.toString(notes.charAt(i)));
				if (i != notes.length()-1 && notes.charAt(i+1) == '#') {
					loc = Arrays.asList(notesAll).indexOf(notes.substring(i, i+2));
				}
				notesNew += Character.toString((char)(loc+'A'));
			}
			
			System.out.println("notesNew = "+notesNew);
			System.out.println();			
			
			// 전체 연주된 악보 (노래 길이만큼)
			String notesPlayed = "";
			int repeat = songLen / notesNew.length();
			for (int i=0; i<repeat; i++)
				notesPlayed += notesNew;
			notesPlayed += notesNew.substring(0, songLen % notesNew.length());
			System.out.println("모두 플레이 된 악보 = "+notesPlayed);
			System.out.println();
			
			if (notesPlayed.contains(mNew)) {
				if (longestSong < songLen) {
					answer = songName;
					longestSong = songLen;
				}
			}
			
		}
		
		if (answer.equals(""))
			answer = "(None)";
		System.out.println(answer);
	}

}
