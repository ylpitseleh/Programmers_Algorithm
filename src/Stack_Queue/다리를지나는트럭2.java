package Stack_Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// 어언 2년전 자료구조 시간에 C로 직접 Queue 구현해서 풀어야했던 과제 2020년 이제서야 풀다.
public class 다리를지나는트럭2 {
	static Queue q = new LinkedList<Truck>(); // 다리를 지나고있는 트럭들
	static class Truck {
		int enterBridgeSec; //몇 초에 다리에 들어가는지
		int weight;
		
		Truck(int enterBridgeSec, int weight) {
			this.enterBridgeSec = enterBridgeSec;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		/*
		int bridge_length = 2; 
		int weight = 10;
		int truck_weights[] = {7, 4, 5, 6};
		*/
		/*
		int bridge_length = 100; 
		int weight = 100;
		int truck_weights[] = {10};
		*/
		
		int bridge_length = 100; 
		int weight = 100;
		int truck_weights[] = {10,10,10,10,10,10,10,10,10,10};
		
		int answer = 0;
		// 총 트럭 수
		int N = truck_weights.length;
		// 다리에 들어가있는 트럭들의 무게 합 
		int sum = 0; 
		int idx = 0;
		int sec = 0;
		ArrayList outOfBridge = new ArrayList<Truck>();
		//1초 단위로 answer++
		while (true) {
			sec++;
			// 들어온지 bridge_length초 지나면 remove시켜줌. (1초에 1만큼 이동하니까)
			if (q.size() > 0) {
				Truck t = (Truck) q.peek();
				if (sec == t.enterBridgeSec + bridge_length) {
					sum -= t.weight;
					q.remove();
					outOfBridge.add(t);
				}
			}
			
			if (idx < N) {
				// 다리에 있는 모든 트럭의 무게 합이 weight보다 작으면 다리에 들여보내줌.
				if (sum + truck_weights[idx] <= weight) {
					q.add(new Truck(sec, truck_weights[idx]));
					sum += truck_weights[idx];
					idx++;
				}
			}
			
			// 모두 빠져나가면 break
			if (outOfBridge.size() == N)
				break;
			
		}
		
		answer = sec;
		System.out.println(answer);
	}

}
