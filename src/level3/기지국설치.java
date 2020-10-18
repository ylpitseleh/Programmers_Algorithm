package level3;
/*
첫 번째 위치부터 while문을 돌면서 설치된 기지국 범위 안에 있는지를 검사
설치된 기지국 범위 밖에 있다면, 현재 위치에서 기지국을 설치했을 때 전파가 가장 멀리 퍼질 수 있는 값인 2*w로 설정하고, 현재 위치를 2*w+1로 설정한 후 결과값+1
설치된 기지국 범위 안에 있다면, 현재 위치를 설치된 기지국 범위+1로 설정
현재 위치가 N에 도달할 때까지 반복
*/
// 왜이렇게 개어렵냐 빡친다 진짜
public class 기지국설치 {

	public static void main(String[] args) {
		int[] stations = {4, 11};
		int n = 11;
		int w = 1;
		/*
		int[] stations = {9};
		int n = 16;
		int w = 2;
		*/
		
		int loc = 1; // 기지국을 설치할 현재 위치
		int idx = 0; // 설치된 기지국 인덱스
		int answer = 0;
		
		while (loc < n+1) {
			// 설치된 기지국 범위 안에 있으면서, 현재 위치가 설치된 기지국의 범위보다 클 때
			if (idx < stations.length && loc >= stations[idx]-w) {
				loc = stations[idx] + w + 1; // 설치된 기지국의 범위보다 +1 큰 위치로 이동
				idx++; // 다음 인덱스로 이동
			}
			else { // 설치된 기지국 범위 밖일 때
				loc += 2 * w + 1; // 양쪽으로 범위를 가질 최대값+1 해준다.
				answer++; // 기지국을 설치했으므로 결과값 추가
			}
		}
		
		System.out.println(answer);
	}

}
