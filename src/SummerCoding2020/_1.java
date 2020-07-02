package SummerCoding2020;

import java.util.Arrays;

public class _1 {

	public static void main(String[] args) {
		int p = 2015;
		int answer = 0;
		
		answer = p+1;
		int num[] = new int[10];
		while (p != 0) {
			num[p % 10]++;
			p /= 10;
		}
		
		int tmp = 0;
		while (true) {
			Arrays.fill(num, 0);
			tmp = answer;
			p = tmp;
			while (p != 0) {
				num[p % 10]++;
				p /= 10;
			}
			int flag = 0;
			for (int i=0; i<10; i++) {
				if (num[i] > 1)
					flag = 1;
			}
			System.out.println(answer);
			for (int i=0; i<10; i++)
				System.out.print(num[i]+" ");
			System.out.println();
			if (flag == 0) {
				System.out.println("end : "+answer);
				break ;
			}
			answer++;
		}
	}

}
