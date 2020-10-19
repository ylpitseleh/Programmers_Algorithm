package level3Second;

import java.util.ArrayList;
import java.util.Arrays;

public class 가장먼노드 {

	public static void main(String[] args) {
		int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		int n = 6;
		/*
		int[][] edge = {{1,2},{2,3},{3,4}};
		int n = 4;
		*/
		int answer = 0;
		
		ArrayList<Integer>[] a;
		a = new ArrayList[n];
		for (int i=0; i<n; i++)
			a[i] = new ArrayList<Integer>();
		
		for (int i=0; i<edge.length; i++) {
			a[edge[i][0]-1].add(edge[i][1]-1);
			a[edge[i][1]-1].add(edge[i][0]-1);
		}
		
		
		for (int i=0; i<n; i++)
			System.out.println(a[i]);
		int[] dist = new int[n];
		
		
	}

	
}
