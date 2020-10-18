package KakaoRecruitment2020하반기;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class _5 {
	static class Play implements Comparable<Play>{
		Date start;
		Date end;
		Play (Date start, Date end) {
			this.start = start;
			this.end = end;
		}
		
		@Override // 오름차순 정렬
		public int compareTo(Play p) {
			if (start == p.start)
				return end.compareTo(end);
			return start.compareTo(p.start);
		}
	}
	
	public static void main(String[] args) throws ParseException {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		
		String[] logs = {"01:20:15-01:45:14", 
						"00:40:31-01:00:00", 
						"00:25:50-00:48:29", 
						"01:30:59-01:53:29", 
						"01:37:44-02:02:30"};
		
		/*
		String[] logs = {"01:20:15-05:45:14", 
						"00:40:31-05:00:00", 
						"00:25:50-04:48:29", 
						"01:30:59-05:53:29", 
						"01:37:44-06:02:30"};
		*/
		
		SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
		//f.setTimeZone(TimeZone.getTimeZone("KST"));
		//Date[] dates = new Date[logs.length];
		Play[] plays = new Play[logs.length];
		for (int i=0; i<logs.length; i++) {
			String[] s = logs[i].split("-");
			Date d1 = f.parse(s[0]);
			Date d2 = f.parse(s[1]);
			plays[i] = new Play(d1, d2);
		}
		
		Arrays.sort(plays);
		
		for (int i=0; i<logs.length; i++) {
			Play p = plays[i];
			System.out.println(plays[i].start+" / "+plays[i].end);
		}
		System.out.println();
		
		// 제일 많이 
		
		Play maxOverlap = new Play(f.parse("00:00:00"), f.parse(play_time));
		int maxOverlapCnt = 1;
		// 제일 많이 겹치는 구간 구해서 (maxOverlap타임이랑 겹치면) 
		// adv_time만큼 구간 시작할 떄 시작하던지 끝을 맞추던지하고 누적 재생시간 구한다.
		for (int i=1; i<logs.length; i++) {
			Play p = plays[i];
			Play pBef = plays[i-1];
			
			//if (p.start <= pBef.end && pBef.start <= p.end) {
				
			//}
			// day1.compareTo(day2) = day1이 더 크면 1 
			Date interval = new Date();
			if (pBef.end.compareTo(p.start) == 1 && p.end.compareTo(pBef.end) == 1) {
				//interval = new Date(pBef.end.getTime() - p.start.getTime() + f.parse("00:00:00").getTime());
				interval = pBef.end;
			}
			else if (pBef.end.compareTo(p.start) == 1 && pBef.end.compareTo(p.end) == 1) {
				//interval = new Date(p.end.getTime() - p.start.getTime() + f.parse("00:00:00").getTime());
				interval = p.end;
			}
			else if (pBef.end.compareTo(p.start) == 1 && p.end.compareTo(pBef.end) == 0) {
				interval = p.end;
			}
			else
				continue ;
			Play intervalTime = new Play(p.start, interval); //p랑 pBef랑 겹치는 구간
			
			//if (maxOverlap.start.compareTo(intervalTime.start) == 1 && 
			//System.out.println("인터벌타임 = "+intervalTime.start+" / "+intervalTime.end);
			
		}
		
		// (StartDate1 <= EndDate2) and (StartDate2 <= EndDate1)
		
		/*
		Date start1 = new Date("22:22:22");
		Date start2 = new Date("22:22:23");
		Interval interval = new Interval( start1, start2);
		
		for (int i=0; i<logs.length; i++) {
			
			//dates[i] = logs[i];
		}
		*/
		//Date startTime = new Date(d1.getTime()-d2.getTime()); // 끝난 시간에서 00.0x.xxx로 만든 duration 빼주기 = 시작 시간
		//Date endTime = new Date(d1.getTime());
	}

}
