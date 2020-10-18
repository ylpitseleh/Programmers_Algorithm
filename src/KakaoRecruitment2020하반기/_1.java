package KakaoRecruitment2020하반기;

import java.util.ArrayList;

public class _1 {

	public static void main(String[] args) {
		String new_id = "";
		int passwordLength = 15;
		new_id = new_id.toLowerCase();
		new_id = new_id.replaceAll("[^a-zA-Z0-9_.\\-]", "");

		ArrayList<Character> stack = new ArrayList<Character>();

		for (int i = 0; i < new_id.length(); i++) {
			if (i != 0) {
				if (stack.get(stack.size() - 1) == '.' && new_id.charAt(i) == '.') {
					continue;
				}
			}
			stack.add(new_id.charAt(i));
		}

		String result = "";
		for (int i = 0; i < stack.size(); i++) {
			if (i == 0 || i == stack.size() - 1) {
				if (stack.get(i) == '.') {
					continue;
				}
			}
			result = result + stack.get(i);
		}

		if (result.length() == 0) {
			result = "a";
		}

		if (result.length() > passwordLength) {
			result = result.substring(0, passwordLength);
		}

		if (result.charAt(result.length() - 1) == '.') {
			result = result.substring(0, passwordLength - 1);
		}

		if (result.length() <= 2) {
			while (result.length() < 3) {
				result = result + result.charAt(result.length() - 1);
			}
		}
		System.out.println(result);

	}

}
