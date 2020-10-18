package NaverCodingTest2020Fall;

public class _1 {

	public static void main(String[] args) {
		/*
		int[] p = {5, 4, 7, 2, 0, 6}; // 생산량
		int[] c = {4, 6, 4, 9, 2, 3}; // 주문량
		int n = 6;
		*/
		
		int[] p = {6, 2, 1, 0, 2, 4, 3};
		int[] c = {3, 6, 6, 2, 3, 7, 6};
		int n = 7;
		
		
		// 탁구공 단가 100원 / 50원, 25원, (사흘 연속 주문대응못하면 거래 종료), 만족시키면 다시 100원
		int ans = 0;
		int rest = 0;
		int days = 0;
		int totalDay = 0;
		for (int i=0; i<n; i++) {
			int price = 100;
			if (days > 0) {
				if (days == 1)
					price = 50;
				if (days == 2)
					price = 25;
				if (days >= 3)
					break ;
			}
			totalDay++;
			if (p[i] + rest >= c[i]) { // 주문 대응 가능
				if (c[i] >= p[i]) // 재고까지 써야할 때
					rest -= c[i] - p[i];
				else { // 생산량만으로 대응 가능할 때(재고 안 써도 됨)
					rest += p[i] - c[i]; // 주문량 만족하고 남은 것 rest에 추가해줌
				}
			}
			else { // 주문 대응 불가능
				days++;
				rest += p[i];
				System.out.println("주문불가"+ans+" "+"rest = "+rest+" days = "+days);
				continue ;
			}
			
			ans += c[i] * price;
			days = 0;
			System.out.println(ans+" "+"rest = "+rest+" days = "+days);
		}
		
		String answer = String.format("%.2f", (double)ans / (double)totalDay);
		System.out.println(answer);
	}

}
