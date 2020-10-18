package KakaoRecruitment2020하반기;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;


public class _7 {
	/*
	static class Play {
		Date start;
		Date end;
		Play (Date start, Date end) {
			this.start = start;
			this.end = end;
		}
		/*
		@Override // 오름차순 정렬
		public int compareTo(Play p) {
			if (start == p.start)
				return end.compareTo(end);
			return start.compareTo(p.start);
		}
		
	}*/
	static class Pair implements Comparable<Pair>{
		int start;
		int end;
		Pair (int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Pair p) {
			if (start == p.start)
				return end - p.end;
			return start - p.start;
		}
	}
	
	
	public static void main(String[] args) {
		/*
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = {"01:20:15-01:45:14", 
						"00:40:31-01:00:00", 
						"00:25:50-00:48:29", 
						"01:30:59-01:53:29", 
						"01:37:44-02:02:30"};
		*/
		
		String play_time = "99:59:59";
		String adv_time = "50:00:00";
		String[] logs = {"69:59:59-89:59:59", 
						"01:00:00-21:00:00", 
						"79:59:59-99:59:59", 
						"11:00:00-31:00:00"};
		
		/*
		String play_time = "50:00:00";
		String adv_time = "50:00:00";
		String[] logs = {"15:36:51-38:21:49", 
						"10:14:18-15:36:51", 
						"38:21:49-42:51:45"};
		*/
		//SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
		
		/*
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    	Date reference = dateFormat.parse("00:00:00");
    	Date date = dateFormat.parse(string);
    	long seconds = (date.getTime() - reference.getTime()) / 1000L;
		*/
		
		
		int[] playTotalSec = new int[makeSec(play_time)+1];
		System.out.println(makeSec(play_time)+1);
		
		Pair[] arr = new Pair[logs.length];
		for (int i=0; i<logs.length; i++) {
			String[]s = logs[i].split("-");
			int start = makeSec(s[0]);
			int end = makeSec(s[1]);
			arr[i] = new Pair(start, end);
		}
		for (int i=0; i<logs.length; i++) {
			for (int j=arr[i].start; j<arr[i].end; j++) { // 등호 넣어야하나?
				playTotalSec[j]++;
			}
		}
		
		Arrays.sort(arr);
		/*for (int i=0; i<arr.length; i++) {
			Pair p = arr[i];
			System.out.println(arr[i].start+" "+arr[i].end);
		}*/
		int advTime = makeSec(adv_time);
		
		
		ArrayList<Pair> maxOverlap = new ArrayList<>();
		int maxOverlapCnt = 0;
		for (int i=0; i<playTotalSec.length; i++) {
			if (playTotalSec[i] > maxOverlapCnt)
				maxOverlapCnt = playTotalSec[i];
		}
		
		int start = 0;
		int end = 0;
		boolean check = false;
		for (int i=0; i<playTotalSec.length; i++) {
			if (!check && playTotalSec[i] == maxOverlapCnt) {
				//System.out.println("i = "+start);
				check = true;
				start = i;
			}
			if (check && playTotalSec[i] != maxOverlapCnt) {
				end = i;
				check = false;
			}
			if (start != 0 && end != 0) {
				maxOverlap.add(new Pair(start, end));
				start = 0;
				end = 0;
			}
		}
		
		ArrayList<Pair> canAnswer = new ArrayList<>();
		for (int i=0; i<maxOverlap.size(); i++) {
			int overlapStart = maxOverlap.get(i).start;
			int overlapEnd = maxOverlap.get(i).end;
			System.out.println("오버랩 = "+overlapStart+" "+overlapEnd);
			for (int j=0; j<arr.length; j++) { // 겹친다면
				//int s = Math.max(overlapStart, arr[j].start);
				//int e = Math.min(overlapEnd, arr[j].end);
				
				if (arr[j].start > overlapEnd || overlapStart > arr[j].end)
					continue ;
				// 겹치면 정답이 될 가능성 있음
				System.out.println(j+"번째");
				//System.out.println(arr[j].start+" "+arr[j].end);
				canAnswer.add(new Pair(arr[j].start, arr[j].end));
			}
			System.out.println();
		}
		
		int ansStart = 0;
		int maxCnt = 0;
		for (int i=0; i<canAnswer.size(); i++) {
			System.out.println(i+"번째 답이 될 수 있는 값입니다.");
			Pair p = canAnswer.get(i);
			// 광고를 시작에 붙이기
			int start1 = p.start;
			int end1 = p.start + advTime;
			System.out.println("1 = "+start1+" "+end1);
			int cnt1 = 0;
			if (end1 < playTotalSec.length) {
				for (int j=start1; j<end1; j++) {
					cnt1 += playTotalSec[j];
				}
			}
			// 광고를 끝에 붙이기
			int start2 = p.end - advTime;
			int end2 = p.end;
			int cnt2 = 0;
			if (start2 > 0) {
				System.out.println("2 = "+start2+" "+end2);
				for (int j=start2; j<end2; j++) {
					cnt2 += playTotalSec[j];
				}
			}
			System.out.println("둘중에 비교 = "+cnt1+" "+cnt2+" max = "+maxCnt+" ansStart = "+ansStart);
			System.out.println();
			
			if (Math.max(cnt1, cnt2) <= maxCnt)
				continue ;
			if (cnt1 <= cnt2) {
				ansStart = start2;
				maxCnt = cnt2;
			}
			else {
				ansStart = start1;
				maxCnt = cnt1;
			}
		}
		
		System.out.println("답은 "+ansStart);
		String answer = makeFormat(ansStart);
		System.out.println(answer);
 	
	}
	
	private static int makeSec (String str) {
		int sec = 0;
		String[] s = str.split(":");
		sec = Integer.parseInt(s[0])*60*60 + Integer.parseInt(s[1])*60 + Integer.parseInt(s[2]);
		
		return sec;
	}
	
	private static String makeFormat (int sec) {
		// secs / 3600, (secs % 3600) / 60, secs % 60
		//LocalTime timeOfDay = LocalTime.ofSecondOfDay(sec);
		//String time = timeOfDay.toString();
		//String str = "";
		//int h = sec / 3600;
		//int m = sec % 3600;
		//int s = sec % 60;
		//str += h+":"+m+":"+s;
		//if (time.length() == 5)
			//time += ":00";
		return String.format("%02d:%02d:%02d", sec / 3600, (sec % 3600) / 60, sec % 60);
		//return time;
	}
		
}
