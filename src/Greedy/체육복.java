package Greedy;

import java.util.Arrays;

public class 체육복 {

	public static void main(String[] args) {
		
		int n = 5; // 전체 학생의 수
		int lost[] = {2, 4}; // 체육복 도난당한 학생들의 번호
		int reserve[] = {1, 3, 5}; // 여벌의 체육복을 가져온 학생들의 번호
		
		/*
		int n = 5;
		int lost[] = {2, 4};
		int reserve[] = {3};
		*/
		/*
		int n = 3;
		int lost[] = {3};
		int reserve[] = {1};
		*/
		
		int answer = 0;
		
		int arr[] = new int[n+1];
		
		Arrays.fill(arr, 1);
		for (int i : reserve) {
			arr[i]++;
		}
		for (int i : lost) {
			arr[i]--;
		}
		
		for (int i=1; i<=n; i++) {
			if (arr[i] == 2) {
				if (i-1 >= 1 && arr[i-1] == 0) {
					arr[i] = arr[i-1] = 1;
                    continue ;
				}
				if (i+1 <= n && arr[i+1] == 0) {
					arr[i] = arr[i+1] = 1;
				}
			}
		}
		
		/*
		for (int i=1; i<=n; i++) {
			System.out.print(arr[i]+" ");
		}
		*/
		for (int i=1; i<=n; i++) {
			if (arr[i] != 0)
				answer++;
		}
		
		System.out.println(answer);
	}

}
