package level2;

public class 멀쩡한사각형 {
	/*
	 * 소요 시간: 20분
	 * ★★★★☆, Cheating : O
	 * 노잼 수학 문제. 이런 쓸데없는 문제 극혐.
	 */
	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		long wl = Long.parseLong(String.valueOf(w));
		long hl = Long.parseLong(String.valueOf(h));
		
		long answer = 1;
		
		System.out.println(wl*hl - (wl + hl - findGcd(wl, hl)));

	}
	
	private static long findGcd(long a, long b) {
		
		long small = Math.min(a, b);
		long big = Math.max(a, b);
		
		while (small != 0) {
			long nmg = big % small;
			big = small;
			small = nmg;
		}
		
		return big;
	}

}
