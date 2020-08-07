package level2;

import java.util.Collection;
import java.util.HashMap;
/*
 * 소요 시간: 35분
 * ★★☆☆☆, Cheating : O
 * hm key 개수만큼 곱하면 되는거라고 생각했는데 테케 거의 다 틀려서 보니까 생각할 경우의 수가 더 많았다. (아래 참조)
 * 이런 식 세우는데 시간 쓰는건 시간낭비니까 빨리빨리 답 보고 베꼈당.
 * 식 세우는 것 말고 hm 쓰는건 쉬움.
 */
public class 위장 {

	public static void main(String[] args) {
		String clothes[][] = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },{ "green_turban", "headgear" } };
		//String clothes[][] = { { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" } };
		//String clothes[][] = { { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" }, { "green_turban", "headgear" } };

		int answer = 1;

		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			if (hm.containsKey(clothes[i][1]))
				hm.put(clothes[i][1], hm.get(clothes[i][1]) + 1);
			else
				hm.put(clothes[i][1], 1);
		}
		System.out.println(hm);
		
		// 3, 2, 1 일 때 => 3*2 + 3*1 + 2*1 + 3*2*1 + 3 + 2 + 1
		// 공식 = (3+1) * (2+1) * (1+1) - 1
		Collection<Integer> values = hm.values();
		for (Integer v : values) {
			answer *= v+1;
		}
		answer--;
		System.out.println(answer);
	}

}
