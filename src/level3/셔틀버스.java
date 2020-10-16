package level3;

import java.sql.Time;
import java.util.PriorityQueue;

public class 셔틀버스 {

	public static void main(String[] args) {
		/*
		int n = 1; // 09:00 부터 총 n회 
		int t = 1; // t분 간격으로 역에 도착
		int m = 5; // 하나의 셔틀에는 최대 m명의 승객 탑승
		String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
		*/
		
		int n = 2;
		int t = 10;
		int m = 2;
		String[] timetable = {"09:10", "09:09", "08:00"};
		
		/*
		int n = 2;
		int t = 1;
		int m = 2;
		String[] timetable = {"09:00", "09:00", "09:00", "09:00"};
		*/
		/*
		int n = 1;
		int t = 1;
		int m = 5;
		String[] timetable = {"00:01", "00:01", "00:01", "00:01"};
		*/
		/*
		int n = 1;
		int t = 1;
		int m = 1;
		String[] timetable = {"23:59"};
		*/
		/*
		int n = 10;
		int t = 60;
		int m = 45;
		String[] timetable = {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
							"23:59", "23:59", "23:59", "23:59", "23:59", "23:59"
							"23:59", "23:59", "23:59", "23:59"};
		*/
		
		String answer = "";
		/*
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		
		Date today = new Date();
		System.out.println(format.format(today));
		*/
		String[] busTime = new String[n];
		busTime[0] = "09:00";
		for (int i=1; i<n; i++) {
			String splitBusTime[] = busTime[i-1].split(":");
			//System.out.println(splitBusTime[0]+" "+splitBusTime[1]);
			int hour = Integer.parseInt(splitBusTime[0]);
			int min = Integer.parseInt(splitBusTime[1]);
			
			busTime[i] += Integer.toString(hour);
			System.out.println(hour+" "+min);
		}
		
		PriorityQueue<Time> pq = new PriorityQueue<Time>();
		
		
		
		
	}

}
