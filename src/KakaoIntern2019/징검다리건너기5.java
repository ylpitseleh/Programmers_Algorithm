package KakaoIntern2019;

public class 징검다리건너기5 {

	public static void main(String[] args) {
		//int stones[] = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int stones[] = {1, 0, 0, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		int answer = 0;
		
		while (true) {
			int i = 0;
			int seq = 0; // 밟을 수 없는 연속된 징검다리의 개수
			
			for (int j=0; j<stones.length; j++)
				System.out.print(stones[j]+" ");
			System.out.println();
			
			
			if(stones[0] == 0)
				seq = 1;
			while (i < stones.length) {
				if (stones[i] > 0) {
					stones[i]--;
					seq = 0;
				}
				else { // 0이면
					if (i >= 1) {
						if (stones[i] == 0 && stones[i-1] != 0)
							seq = 1;
						
						if (stones[i] == 0 && stones[i-1] == 0)
							seq++;
					}
					if (seq >= k) {
						System.out.println(answer);
						return ;
					}
						
				}
				
				System.out.println("seq : "+seq);
				i++;
			}
			//if (seq >= k) {
				//continue ; 
			//}
			answer++;
		}
		
		//System.out.println(answer);

	}

}
