package level2;

import java.util.Arrays;

public class 최댓값과최솟값 {

	public static void main(String[] args) {
		//String s = "1 2 3 4";
		String s = "-1 -2 -3 -4";
		//String s = "-1 -1";
		
		// (최소값) (최대값)
		String str[] = s.split(" ");
		int[] arr = new int[str.length];
		for (int i=0; i<str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(arr);
		String answer = "";
		answer += arr[0]+" ";
		answer += arr[str.length-1];
		System.out.println(answer);
	}

}
