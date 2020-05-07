package Hash;

import java.util.Collection;
import java.util.HashMap;

public class 위장3 {

	public static void main(String[] args) {
		String clothes[][] = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		//String clothes[][] = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		
		int answer = 1;
		
		HashMap<String , Integer> hm = new HashMap<String , Integer>();
		
		for (int i=0; i<clothes.length; i++) {
			if (hm.containsKey(clothes[i][1]))
				hm.put(clothes[i][1], hm.get(clothes[i][1]) + 1);
			else
				hm.put(clothes[i][1], 1);
		}

		/*
		 * value가 3, 2, 1일 때 모든 경우의 수
		 * (3*2*1) + (3*2) + (3*1) + (1*2) + 3 + 2 + 1
		 * 공식 = (3+1) * (2+1) * (1+1) - 1
		 * 각 종류들은 하나를 입거나, 안입거나의 선택지가 있기 때문에 옷의 개수에 안입는 선택지를 하나 추가한다.
		 * 그리고 옷을 고르는 선택은 동시에 일어나는 일이기 때문에, 각 옷들을 곱해 경우의 수를 계산한다.
		 * 이 때, 하나도 안입는 선택지는 없으므로 그 경우의 수 하나를 뺀다.
		 */
		
		Collection<Integer> values = hm.values();
		for (Integer n : values) {
			answer *= n+1;
		}
		answer--;
		
		System.out.println(answer);
	}

}
