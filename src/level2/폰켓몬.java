package level2;

import java.util.HashSet;
/*
 * 소요 시간: 5분
 * ☆☆☆☆☆, Cheating : X
 */
public class 폰켓몬 {

	public static void main(String[] args) {
		//int[] nums = {3,1,2,3};
		//int[] nums = {3,3,3,2,2,4};
		int[] nums = {3,3,3,2,2,2};

		int answer = 0;
		
		HashSet<Integer> hs = new HashSet<>();
		for (int i=0; i<nums.length; i++) {
			hs.add(nums[i]);
		}
		
		answer = Math.min(hs.size(), nums.length/2);
		System.out.println(answer);
	}

}
