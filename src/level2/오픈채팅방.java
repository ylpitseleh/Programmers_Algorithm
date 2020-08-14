package level2;

import java.util.ArrayList;
import java.util.HashMap;
/*
 * 소요 시간: 1시간
 * ★★☆☆☆, Cheating : X
 * 괜히 어렵게 생각했다가 시간 다 잡아먹었다. 단순한 문제임. id만 기억해놨다가 마지막에 id에 해당하는 최종 닉네임으로 넣어주기만 하면 됨.
 */
public class 오픈채팅방 {
	static class Info {
		String id;
		String status; //Enter, Leave
		Info(String id, String status) {
			this.id = id;
			this.status = status;
		}
	}
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", 
							"Enter uid4567 Prodo",
							"Leave uid1234",
							"Enter uid1234 Prodo",
							"Change uid4567 Ryan"};
		String[] answer = {};
		/*
		 * Prodo님이 들어왔습니다.
		 * Ryan님이 들어왔습니다.
		 * Prodo님이 나갔습니다.
		 * Prodo님이 들어왔습니다.
		 */
		
		
		HashMap<String, String> hm = new HashMap<>(); // ID, 닉네임
		ArrayList<Info> al = new ArrayList<>(); // ID, status(Enter, Leave)
		for (int i=0; i<record.length; i++) {
			String[] s = record[i].split(" ");
			String curStatus = s[0];
			String curId = s[1];
			if (s[0].equals("Enter")) {
				String curNickname = s[2];
				hm.put(curId, curNickname);
				Info info = new Info(curId, curStatus);
				al.add(info);
			}
			else if (s[0].equals("Leave")) {
				Info info = new Info(curId, curStatus);
				al.add(info);
			}
			else if (s[0].equals("Change")) {
				String curNickname = s[2];
				hm.put(curId, curNickname);
			}
			
		}
		
		for (int j=0; j<al.size(); j++) {
			Info info = al.get(j);
			System.out.println(info.id+" "+info.status);
		}
		System.out.println();
		
		answer = new String[al.size()];
		for (int i=0; i<al.size(); i++) {
			answer[i] = "";
			Info info = al.get(i);
			String nickname = hm.get(info.id);
			answer[i] += nickname;
			if (info.status.equals("Enter")) {
				answer[i] += "님이 들어왔습니다.";
			}
			else if (info.status.equals("Leave")) {
				answer[i] += "님이 나갔습니다.";
			}
		}
		
		for (int i=0; i<al.size(); i++) {
			System.out.println(answer[i]);
		}

	}

}
