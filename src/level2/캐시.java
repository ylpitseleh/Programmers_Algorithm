package level2;
/*
 * 소요 시간: 30분
 * ★★☆☆☆, Cheating : X
 * lru를 어떻게 구현하지 싶었는데 그냥 간단히 생각나는대로 풀었더니 바로 됐당.
 */
public class 캐시 {

	public static void main(String[] args) {
		/*
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", 
				"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		int cacheSize = 3;
		*/
		/*
		String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", 
				"Seoul", "Jeju", "Pangyo", "Seoul"};
		int cacheSize = 3;
		int answer = 0;
		*/
		/*
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", 
				"SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		int cacheSize = 5;
		*/
		/*
		String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
		int cacheSize = 2;
		*/
		
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		int cacheSize = 0;
		
		int answer = 0;
		
		if (cacheSize == 0) {
			answer = cities.length * 5;
			System.out.println(answer);
			//return answer;
		}
		String[] cache= new String[cacheSize];
		int lru[] = new int[cacheSize];
		
		for (int i=0; i<cacheSize; i++) {
			cache[i] = ""; // String 초기화
			lru[i] = -1; //index가 0일 수도 있으니까
		}
		
		for (int i=0; i<cities.length; i++) {
			boolean cacheHit = false;
			for (int j=0; j<cacheSize; j++) {
				if (cache[j].toUpperCase().equals(cities[i].toUpperCase())) { // 캐시 hit
					lru[j] = i;
					cacheHit = true;
					answer++;
				}
			}
			if (!cacheHit) { // 캐시 miss
				int min = cities.length; // 최대값
				int minIdx = -1;
				for (int j=0; j<cacheSize; j++) {
					if (min > lru[j]) {
						min = lru[j];
						minIdx = j;
					}
				}
				cache[minIdx] = cities[i];
				lru[minIdx] = i;
				answer += 5;
			}
			
			for (int j=0; j<cacheSize; j++) {
				System.out.print(cache[j]+" ");
			}
			System.out.println();
			for (int j=0; j<cacheSize; j++) {
				System.out.print(lru[j]+" ");
			}
			System.out.println("answer = "+answer);
			System.out.println();
		}
		
		System.out.println(answer);
	}

}
