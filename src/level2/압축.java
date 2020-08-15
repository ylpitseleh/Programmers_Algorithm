package level2;

import java.util.ArrayList;
/*
 * 소요 시간: 1시간
 * ★★★☆☆, Cheating : X
 * 딱 My code works.. I have no idea why다. 테케 돌려보고 제발 틀리면 디버깅 못한다 맞아라 했는데 다 맞았다.
 * 뭔가 그냥 껴맞춰서 풀었다. 다른 사람 보니까 맵 썼네. 문제에도 맵 어쩌구 했는데 그냥 무시했다. 그래도 다시 풀라하면 한 시간만에 가능할듯.
 */
public class 압축 {

	public static void main(String[] args) {
		//String msg = "KAKAO";
		//String msg = "TOBEORNOTTOBEORTOBEORNOT";
		String msg = "ABABABABABABABAB";
		
		int answer[] = {};
		
		ArrayList<String> al = new ArrayList<>();
		
		al.add(""); // for문을 1부터 넣어도 al.get(0)하면 A가 나옴. 첫 번째에 빈 것 넣어주기.
		for (int i=1; i<=26; i++) {
			char c = (char)('A' + i-1);
			al.add(Character.toString(c));
		}
		
		ArrayList<Integer> answerList = new ArrayList<>();
		
		int i = 0;
		while (i < msg.length()) {
			int j = i + 1;
			while (j < msg.length()) {
				String addS = msg.substring(i, j+1);
				if (!al.contains(addS)) {
					al.add(addS);
					System.out.println(addS+"가 추가되었다.");
					
					break ;
				}
				j++;
			}
			System.out.println("this : "+i+" "+j);
			System.out.println("answer에 들어갈 것 = "+msg.substring(i, j));
			System.out.println();
			
			answerList.add(al.indexOf(msg.substring(i, j)));
			
			if (j != i+1) {
				i = j;
				continue ;
			}
			i++;
		}
		
		System.out.println(answerList);
	}

}
