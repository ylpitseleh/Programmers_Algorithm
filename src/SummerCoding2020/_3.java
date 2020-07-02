package SummerCoding2020;

import java.util.ArrayList;
import java.util.Arrays;

public class _3 {

	public static void main(String[] args) {
		int total_sp = 121;
		int[][] skills = {{3, 5}, {1, 2}, {1, 3}, {3, 6}, {3, 4}};
		int[] answer = {};
		
		Arrays.sort(skills, (o1, o2) -> {
			if (o1[0] == o1[0])
				return Integer.compare(o1[1], o2[1]);
			else
				return Integer.compare(o1[0], o2[0]);
		});
		
		for (int i=0; i<skills.length; i++) {
			System.out.println(skills[i][0]+" "+skills[i][1]);
		}
		
		int totalNode = 0;
		for (int i=0; i<skills.length; i++) {
			if (skills[i][1] > totalNode)
				totalNode = skills[i][1];
		}
		
		int num[] = new int[totalNode + 1]; //1~6
		for (int i=0; i<skills.length; i++) {
			num[skills[i][0]]++;
		}
		
		for (int i=1; i<totalNode+1; i++) {
			if (num[i] == 0)
				num[i]++;
		}
		
		for (int i=1; i<totalNode+1; i++) {
			for (int j=0; j<skills.length; j++) {
				if (skills[j][0] == i) {
					num[i] -= 1;
					num[i] += num[skills[j][1]];
				}
			}
		}
		int sum = 0;
		for (int i=1; i<totalNode+1; i++) {
			sum += num[i];
		}
		answer = new int[totalNode];
		int n = total_sp / sum;
		for (int i=1; i<totalNode+1; i++) {
			answer[i-1] = num[i] * n;
		}
		
		for (int i=0; i<totalNode; i++) {
			System.out.print(answer[i]+" ");
		}
		



	}

}
