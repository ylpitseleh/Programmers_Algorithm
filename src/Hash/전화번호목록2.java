package Hash;

import java.util.HashMap;

public class 전화번호목록2 {

	public static void main(String[] args) {
		//String phone_book[] = {"119", "97674223", "1195524421"};
		//String phone_book[] = {"123", "456", "789"};
		String phone_book[] = {"112", "01123", "1235", "567", "88", "1"};
		boolean answer = true;
		
		//HashMap<String , Integer> hm = new HashMap<String , Integer>();
		for (int i=0; i<phone_book.length; i++) {
			for (int j=0; j<phone_book.length; j++) {
				int cnt = 0;
				if (phone_book[i].length() < phone_book[j].length()) {
					for (int k=0; k<phone_book[i].length(); k++) {
						if (phone_book[i].charAt(k) == phone_book[j].charAt(k)) {
							cnt++;
						}
					}
					if (cnt == phone_book[i].length()) {
						answer = false;
						System.out.println(phone_book[i]);
						//return answer;
					}
				}
					
			}
		}
		
		
	}

}
