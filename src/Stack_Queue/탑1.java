package Stack_Queue;

import java.util.ArrayList;
// al 쓰는 이유 = 없음. 그냥 배열 써도 됨.
public class 탑1 {
	static ArrayList al = new ArrayList<Tower>();
	static class Tower {
		int seq;
		int height;
		
		Tower(int seq, int height) {
			this.seq = seq;
			this.height = height;
		}
	}

	public static void main(String[] args) {
		//int heights[] = {6, 9, 5, 7, 4};
		//int heights[] = {3, 9, 9, 3, 5, 7, 2};
		int heights[] = {1, 5, 3, 6, 7, 6, 5};
		int[] answer = {};
		
		answer = new int[heights.length];
		for (int i=0; i<heights.length; i++) {
			al.add(new Tower(i+1, heights[i]));
		}
		int idx = 0;
		for (int i=0; i<heights.length; i++) {
			for (int j=0; j<heights.length; j++) {
				Tower tI = (Tower) al.get(i);
				Tower tJ = (Tower) al.get(j);
				if (tI.seq > tJ.seq && tI.height < tJ.height) {
					answer[idx] = tJ.seq;
				}
			}
			idx++;
		}
		
		// 스택 안 쓰고 그냥 배열로 처리한 내 코드. 심지어 이게 스택 쓴 것 보다 빠름
		/*
		answer = new int[heights.length];
		for (int i=heights.length-1; i>0; i--) {
			for (int j=i-1; j>=0; j--) {
				if (heights[i] < heights[j]) {
					answer[i] = j+1;
					break ;
				}
				answer[i] = 0;
			}
		}
		 */
		//for (int i=0; i<heights.length; i++)
			//System.out.print(answer[i]);
	}

}
