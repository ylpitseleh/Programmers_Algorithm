package NaverCodingTest2020Fall;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class _2 {

	public static void main(String[] args) {
		int n = 9;
		int edges[][] = {{0, 2}, {2, 4}, {2, 1}, {3, 5}, {5, 4}, {5, 7}, {7, 6}, {6, 8}};
		
		java.util.Arrays.sort(edges, new java.util.Comparator<int[]>() {
		    public int compare(int[] a, int[] b) {
		        int answer = Integer.compare(a[0], b[0]);
		    	//if (Integer.compare(a[0], b[0] == 0))
		    	//	answer = Integer.compare(a[0][0], b[0][1]);
		        	
		    	return answer;
		    }
		});
		for (int i=0; i<edges.length; i++)
			System.out.println(edges[i][0]+" "+edges[i][1]);
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i=0; i<edges.length; i++) {
			if (hm.containsKey(edges[i][0]) || hm.containsKey(edges[i][1]))
				hm.put(edges[i][0], hm.get(edges[i][0]) + 1);
			else
				hm.put(edges[i][0], 1);
			System.out.println(hm);
		}
		
	}

}
