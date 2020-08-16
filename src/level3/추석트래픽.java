package level3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
/*
 * 소요 시간: 4시간
 * ★★★★☆, Cheating : O
 * 무친.. 2018 카카오 공채 제일 어려운 문제였다는데 사스가 카카오 씨익 씨익.. 그래도 네 시간동안 삽질하면서 SimpleDateFormat이랑 저 겹치는거 찾는 방법 이해했다.. 
 * 일단 시간 어떻게 계산할건지 정하는데도 엄청 오래 걸렸고 (결국 SimpleDateFormat으로 최적화 성공) 
 * 밑에 1초 안에 겹치는거 찾는 방법은 결국 구상 못 하고 자꾸 테케 두 개 틀리고 그래서 남의 코드 베꼈다. 그래도 나중에 다시 풀면 풀 수 있을 것 같기도....?
 * 문자열 좋아하는 카카오는 또 SimpleDateFormat로 시간 다루는거 낼지도 모르니 잘 알아두자.
 */
public class 추석트래픽 {
	static class startEnd {
		Date start;
		Date end;
		startEnd (Date start, Date end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) throws ParseException {
		/*
		String[] lines = {
				"2016-09-15 01:00:04.001 2.0s",
				"2016-09-15 01:00:07.000 2s"
		};
		*/
		
		String[] lines = {
				"2016-09-15 01:00:04.002 2.0s",
				"2016-09-15 01:00:07.000 2s"
		};
		
		/*
		String[] lines = {
				"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"
		};
		*/
		
		int answer = 0;
		
		ArrayList<startEnd> al = new ArrayList<>();
		for (int i=0; i<lines.length; i++) {
			// 시간 파싱
			String s[] = lines[i].split(" ");
			String endTimeS = s[1];
			String durationS = s[2].substring(0, s[2].length()-1);
			
			int dur = 0;
			dur = (int)(Double.parseDouble(durationS) * 1000 - 1) ; // 시작, 끝 시간 포함하니까 -1 
			
			SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss.SSS");
			f.setTimeZone(TimeZone.getTimeZone("UTC"));
			Date d1 = f.parse(endTimeS);
			Date d2 = f.parse("00:00:0"+dur/1000+"."+dur%1000); // dur를 00:00:0x.xxx로 만들기

		    Date startTime = new Date(d1.getTime()-d2.getTime()); // 끝난 시간에서 00.0x.xxx로 만든 duration 빼주기 = 시작 시간
		    Date endTime = new Date(d1.getTime());
		    
		    //String startTimeS = f.format(d1.getTime()-d2.getTime()); // Date 출력할 때 사용. / getTime()은 밀리세컨드로 변환함.

		    //System.out.println("시작시간 = "+startTimeS);
			//System.out.println("끝 시간 = "+f.format(d1.getTime()));
			//System.out.println();
			
			al.add(new startEnd(startTime, endTime));
		}
		
		// task의 개수가 변하는 시점은 start와 end 타임일 수 밖에 없으므로
		// 모든 start와 end 타임에 대해 task 수가 몇 개인지 세어 주는 연산을 수행하면 됩니다. (시간 복잡도  N^2)
		// ---------- 답 보고 베꼈던 곳 -----------
		int max = 0;
		for (int i=0; i<al.size(); i++) {
			startEnd se1 = al.get(i);
			int cnt = 0;
			long se1Start = se1.start.getTime();
			long se1End = se1.end.getTime();
			
			long sectionStart = se1End; // | |
			long sectionEnd = sectionStart + 1000; // 왜 end + 1초인지 이해가 안 가면 2 번째 테케 답이 왜 2인지 알면 됨. 
			
			for (int j=0; j<al.size(); j++) {
				startEnd se2 = al.get(j);
				long se2Start = se2.start.getTime();
				long se2End = se2.end.getTime();
				
				//  -|---|- start가 왼쪽 |보다 작고, end가 오른쪽 |보다 크다.
				if (sectionStart >= se2Start && se2End >= sectionEnd) {
					cnt++;
					System.out.println("(1) "+i+" "+j);
				}
				
				// |--- |  or  | --|--  start가 | | 범위 안에 있음
				else if (sectionStart <= se2Start && se2Start < sectionEnd) { 
					cnt++;
					System.out.println("(2) "+i+" "+j);
				}
				
				// |--- |  or  --|-- |  end가 | | 범위 안에 있음
				else if (sectionStart <= se2End && se2End < sectionEnd) {
					cnt++;
					System.out.println("(3) "+i+" "+j);
				}
			}
			System.out.println(cnt);
			max = Math.max(max, cnt);
		}
		System.out.println("답 : "+max);
	}

}
