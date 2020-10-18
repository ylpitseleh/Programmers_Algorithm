package NaverCodingTest2020Fall;

public class _3 {

	public static void main(String[] args) {
		int k = 5; // 2, 3, 5, 17, 71
		//int k = 6; // 0, 6, 9, 14, 41, 77, 111
		//int k = 11; // 총 99개 
		//int k = 1; // 없음
		
		int arr[] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
		//dp : 0, 0, 1, 1, 2, 5,  
		//     0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
		//0 : 0
		//1 : 0
		//2 : 1
		//3 : 1
		//4 : 2 (2+2, 4)
		//5 : 5 (5, 5, 5, 2+3, 3+2
		//6 : 6 (6, 6, 6, 4+2, 2+4, 3+3)
		
		
	}
	
	private static void dfs (int depth, String answer, int sum) {
		//if (sum)
	}

}
