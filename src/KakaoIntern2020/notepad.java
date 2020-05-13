package KakaoIntern2020;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class notepad {

	public static void main(String[] args) {
		// 큐
		Queue q = new LinkedList<Integer>();
		
		// 스택
		Stack st = new Stack<Integer>();
		
		// 우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue();
		// 리버스
		Queue<Integer> pqR = new PriorityQueue<>(Comparator.reverseOrder());
		
		// 해시맵
		HashMap<String , Integer> hm = new HashMap<String , Integer>();
		
		// ArrayList
		ArrayList al = new ArrayList<Integer>();
		/*
		import java.util.HashSet;
		class Solution {
		    public int[] solution(String[] gems) {
		        int[] answer = {};
		        
		        answer = new int[2];
		        HashSet hs = new HashSet<String>();
				int N = gems.length;
				for (int i=0; i<N; i++) {
					hs.add(gems[i]);
				}
		        
				int start = 0;
				int end = 0;
				int min = 100001;
				for (int i=0; i<N; i++) {
					for (int j=i; j<N; j++) {
		                if (min < j - i || hs.size() > j-i+1)
							continue; 
						HashSet ans = new HashSet<String>();
		                for (int k=i; k<=j; k++) {
							ans.add(gems[k]);
						}
						if (ans.equals(hs)) {
							if (min > j - i)
								min = j - i;
							else
								continue ;
							start = i + 1;
							end = j + 1;
						}
					}
				}
				answer[0] = start;
				answer[1] = end;
		        
		        return answer;
		    }
		}
		*/
		
		
	}

}
