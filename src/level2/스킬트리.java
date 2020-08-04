package level2;
/*
 * 소요 시간: 35분
 * ★★☆☆☆, Cheating : X
 * 최적화 시킬 수 있을까 했는데 다른 사람 코드 보니까 나처럼 푼게 최선인듯. 정규표현식은 아직까진 알아야 할 필요성을 모르겠음. 
 */
public class 스킬트리 {
	public static void main(String[] args) {
		String skill = "CBD";
		String skill_trees[] = {"BACDE", "CBADF", "AECB", "BDA"};
		
		int answer = 0;
		
		for (int i=0; i<skill_trees.length; i++) {
			int skill_idx = -1;
			int rightIndex = 0; // CBD면  index 0, 1, 2 (C, B, D) 순서대로 나와야 함.
			boolean flag = true;
			//System.out.println("here : "+skill_trees[i]);
			for (int j=0; j<skill_trees[i].length(); j++) {
				char c = skill_trees[i].charAt(j);
				
				if (skill.contains(Character.toString(c))) {
					//System.out.println(c+" : "+skill.indexOf(c)+" "+skill_idx+" "+rightIndex);
					if (skill.indexOf(c) != rightIndex) {
						flag = false;
						break ;
					}
					skill_idx = skill.indexOf(c);
					rightIndex++;
				}
			}
			if (flag == true)
				answer++;
		}

		System.out.println(answer);
	}

}
