package level2;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * 소요 시간: 1시간 45분
 * ★★★☆☆, Cheating : O(테케)
 * 와우...카카오.. 정말 더럽게도 내는구나. 진짜 좀 너무하는거 같음. 물론 풀 수는 있는데 너무 오래걸림.
 * String 012가 02 포함해야하는걸 놓쳐서 테케 5개 틀려서 다른사람이 만든 테케 돌려보고 답 겨우 맞췄다. 
 * 로직은 간단함. 퍼뮤로 돌려서 Arrays.equals로 row별로 비교만 해 주면 됨.
 */
public class 후보키 {
	static ArrayList<Integer> notUniqueColumn = new ArrayList<>(); // 컬럼 1개짜리 후보키를 제외한 나머지 (permu 돌릴것)
	static ArrayList<String> answerList = new ArrayList<>(); //column개수는 어차피 한 자리여서 답 1, 12(1이랑 2) 이런식으로 넣을 것임.
	
	public static void main(String[] args) {
		/*
		String[][] relation = 
				{{"100","ryan","music","2"},
				 {"200","apeach","math","2"},
				 {"300","tube","computer","3"},
				 {"400","con","computer","4"},
				 {"500","muzi","music","3"},
				 {"600","apeach","music","2"}};
		*/
		String[][] relation = 
		{{"b","2","a","a","b"},
		{"b","2","7","1","b"},
		{"1","0","a","a","8"},
		{"7","5","a","a","9"},
		{"3","0","a","f","9"}};
		int answer = 0; //answer = 5;
		
		int h = relation.length;
		int w = relation[0].length;				
		for (int i=0; i<w; i++) {
			boolean sameFlag = false;
			for (int j=0; j<h; j++) {
				for (int k=j+1; k<h; k++) {
					if (relation[j][i].equals(relation[k][i])) {
						sameFlag = true;
						break;
					}
				}
				if (sameFlag)
					break ;
			}
			if (sameFlag)
				notUniqueColumn.add(i);
			else
				answerList.add(Integer.toString(i));
		}
		//System.out.println(uniqueColumn);
		boolean[] visited = new boolean[notUniqueColumn.size()];
		for (int i=2; i<=notUniqueColumn.size(); i++) {
			permutation(i, 0, "", notUniqueColumn, visited, relation);
		}
		answer = answerList.size();
		System.out.println("answer = "+answer);
	}
	
	private static void permutation(int len, int depth, String s, ArrayList<Integer> uniqueColumn, boolean[] visited, String[][] relation) {
		if (depth == len) {
			// 012 가 02를 포함한다고 봐야함!!! => 처리 안 하면 테케 5개 틀림
			for (int i=0; i<answerList.size(); i++) {
				boolean containsFlag = false; // 포함되는게 있으면 return 
				
				String sTmp = answerList.get(i);
				for (int j=0; j<sTmp.length(); j++) {
					if (s.contains(Character.toString(sTmp.charAt(j))))
						continue;
					else
						containsFlag = true;
				}
				if (!containsFlag)
					return ;
			}
			
			String str[][] = new String[relation.length][s.length()]; //permu로 선택된 column만
			for (int i=0; i<relation.length; i++) {
				for (int j=0; j<s.length(); j++) {
					int tmp = s.charAt(j)-'0';
					str[i][j] = relation[i][tmp];
				}
			}
			
			boolean sameFlag = false;
			for (int i=0; i<relation.length; i++) {
				String ss[] = str[i];
				for (int j=i+1; j<relation.length; j++) {
					String ssCompare[] = str[j];
					if (Arrays.equals(ss, ssCompare)) { // array를 비교할 땐 Arrays.equals를 쓴다.
						sameFlag = true;
						break ;
					}
				}
				if (sameFlag)
					break ;
			}
			if (!sameFlag) {
				/*
				System.out.println(s);
				for (int i=0; i<relation.length; i++) {
					for (int j=0; j<s.length(); j++) {
						System.out.print(str[i][j]+" ");
					}
					System.out.println();
				}
				System.out.println();
				*/
				answerList.add(s);
			}
			
			return ;
		}
		
		for (int i=depth; i<visited.length; i++) {
			if (visited[i])
				continue ;
			if (s.length() >= 1 && uniqueColumn.get(i) <= s.charAt(s.length()-1)-'0') //12, 123, 124 오름차순으로
				continue ;
			visited[i] = true;
			permutation(len, depth+1, s+uniqueColumn.get(i), uniqueColumn, visited, relation);
			visited[i] = false;
		}
	}

}
