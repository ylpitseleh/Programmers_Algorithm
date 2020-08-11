package level2;

public class N개의최소공배수 {

	public static void main(String[] args) {
		//int arr[] = {2, 6, 8, 14};
		int arr[] = {1, 2, 3};
		
		int answer = 0;
		
		int n = 1;
		for (int i=0; i<arr.length; i++) {
			int big = Math.max(n, arr[i]);
			int small = Math.min(n, arr[i]);
			
			int gcdN = big * small / gcd(big, small);
			n = gcdN;
		}
		System.out.println(n);

	}
	
	private static int gcd(int a, int b){
	      if(a % b == 0)
	          return b;
	      return gcd(b, a%b);
	}

}
