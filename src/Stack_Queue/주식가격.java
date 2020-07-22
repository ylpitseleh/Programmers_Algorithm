package Stack_Queue;

public class 주식가격 {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		int[] answer = {};
		
		answer = new int[prices.length];
		
		for (int i=0; i<prices.length; i++) {
			int cnt = 0;
			for (int j=i+1; j<prices.length; j++) {
				if (prices[i] <= prices[j]) {
					cnt++;
				}
				else {
					if (cnt == 0)
						cnt = 1;
					break ;
				}
			}
			answer[i] = cnt;
		}
		
		for (int i=0; i<prices.length; i++)
			System.out.print(answer[i]+" ");

	}

}
