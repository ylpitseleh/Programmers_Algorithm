package level2;

import java.util.LinkedList;
import java.util.Queue;
/*
 * 소요 시간: 40분
 * ★★☆☆☆, Cheating : X
 * 큐 두 개 쓰거나 아니면 클래스에 enterTime이랑 weight 넣어서 객체로 만들어서 큐 하나에 넣어도 됨.
 */
public class 다리를지나는트럭 {

	public static void main(String[] args) {
		
		int bridge_length = 2; 
		int weight = 10;
		int truck_weights[] = {7, 4, 5, 6};
		
		/*
		int bridge_length = 100; 
		int weight = 100;
		int truck_weights[] = {10};
		*/
		/*
		int bridge_length = 100; 
		int weight = 100;
		int truck_weights[] = {10,10,10,10,10,10,10,10,10,10};
		*/
		int answer = 0;
		
		Queue<Integer> qWeights = new LinkedList<Integer>();
		Queue<Integer> qEnterTime = new LinkedList<Integer>(); // 큐에 들어온 시간
		
		// 첫 번째 원소 넣기
		qWeights.add(truck_weights[0]);
		qEnterTime.add(1);
		int sum = truck_weights[0];
		
		int sec = 1;
		int i = 1;
		while (!qWeights.isEmpty()) {
			sec++;
			int peek = qEnterTime.peek();
			if (sec == peek + bridge_length) {
				int poll = qWeights.poll();
				qEnterTime.poll();
				sum -= poll;
			}
			if (i < truck_weights.length && sum + truck_weights[i] <= weight) {
				qWeights.add(truck_weights[i]);
				qEnterTime.add(sec);
				sum += truck_weights[i];
				i++;
			}
			//System.out.println(qWeights);
			//System.out.println(qEnterTime);
			//System.out.println(sec+" "+peek+" "+bridge_length);
			//System.out.println();
		}
	
		System.out.println(sec);
	}

}
