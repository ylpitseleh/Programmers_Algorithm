package level2;
/*
 * 소요 시간: 1시간
 * ★★☆☆☆, Cheating : X
 * permu하고 조건만 주면 되는 간단한 문제.
 */
public class 단체사진찍기 {
	static int answer;

	public static void main(String[] args) {
		//String[] data = {"N~F=0", "R~T>2"};
		String[] data = {"M~C<2", "C~M>1"};
		int n = 2;
		
		answer = 0;
		
		// {A, C, F, J, M, N, R, T}
		char[] member = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
		boolean[] visited = new boolean[member.length];
		permutation(0, "", visited, member, data);
		System.out.println("ANSWER = "+answer);
	}

	private static void permutation(int depth, String s, boolean[] visited, char[] member, String[] data) {
		if (depth == member.length) {
			System.out.println(s);
			
			boolean trueFlag = true;
			for (int i=0; i<data.length; i++) {
				char c1 = data[i].charAt(0);
				char c2 = data[i].charAt(2);
				int dist = data[i].charAt(4)-'0'; // c1, c2 사이의 거리
				System.out.println(c1+" "+c2);
				//System.out.println("위치 : "+s.indexOf(c1)+" "+s.indexOf(c2));
				System.out.println(Math.abs(s.indexOf(c1)-s.indexOf(c2))-1+" "+dist);
				
				char sign = data[i].charAt(3);
				if (sign == '=') {
					if (Math.abs(s.indexOf(c1) - s.indexOf(c2))-1 != dist) {
						trueFlag = false;
					}
				}
				else if (sign == '>') {
					if (Math.abs(s.indexOf(c1) - s.indexOf(c2))-1 <= dist) {
						trueFlag = false;
					}
				}
				else if (sign == '<'){
					if (Math.abs(s.indexOf(c1) - s.indexOf(c2))-1 >= dist) {
						trueFlag = false;
					}
				}
				if (!trueFlag) break ;
			}
			if (trueFlag)
				answer++;
			
			return ;
		}
		for (int i=0; i<member.length; i++) {
			if (visited[i])
				continue ;
			visited[i] = true;
			permutation(depth+1, s+member[i], visited, member, data);
			visited[i] = false;
		}
	}
}
