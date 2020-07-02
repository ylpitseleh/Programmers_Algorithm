package SummerCoding2020;

public class _2 {

	public static void main(String[] args) {
		//long n = 4;
		 long n = 11;
		long answer = 0;

		long[] b = new long[32];

		String s = Long.toBinaryString(n);
		String s1 = "";
		for (int i=0; i<s.length(); i++) {
			s1 += s.charAt(s.length()-i-1);
		}
		
		for (int i=0; i<s1.length(); i++) {
			if (s1.charAt(i) == '1') {
				answer += Math.pow(3, i);
			}
		}
		
		System.out.println(answer);

	}

}
