package KakaoRecruitment2020하반기;
// 2시간 30분 소요.. 어렵다 이거! 하지만 풀었다. -를 처리해주는게 아이디어가 잘 안 나왔었다. 하지만 효율적으로 해결한듯.
/*
1. 24개의 그룹으로 나누고
2. 각 그룹을 점수순으로 sort하고
3. 조건에 맞는 그룹으로 가서 점수기준으로 이분탐색 
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class _3 {

	public static void main(String[] args) {
		String info[] = { "java backend junior pizza 150", 
						"python frontend senior chicken 210",
						"python frontend senior chicken 150", 
						"cpp backend senior pizza 260", 
						"java backend junior chicken 80",
						"python backend senior chicken 50" };

		String query[] = { "java and backend and junior and pizza 100",
							"python and frontend and senior and chicken 200", 
							"cpp and - and senior and pizza 250",
							"- and backend and senior and - 150", 
							"- and - and - and chicken 100", 
							"- and - and - and - 150" };

		HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
		for (int i=0; i<info.length; i++) {
			String[] s = info[i].split(" ");
			String group = info[i].replaceAll("0|1|2|3|4|5|6|7|8|9", ""); // 문자만 추출 (숫자 뺀 나머지)
			int score = Integer.parseInt(s[s.length-1]); // 숫자만 추출
			
			if (hm.containsKey(group)) {
				hm.get(group).add(score);
				hm.put(group, hm.get(group));
			}
			else {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(score);
				hm.put(group, al);
			}
		}
		
		System.out.println(hm);
		int[] answer = new int[query.length];
		
		for (int i=0; i<query.length; i++) {
			String[] s = query[i].split(" ");
			String group = query[i].replaceAll(" and", "");
			group = group.replaceAll("0|1|2|3|4|5|6|7|8|9", "");
			int score = Integer.parseInt(s[s.length-1]);
			
			if (hm.containsKey(group)) {
				Collections.sort(hm.get(group));
				// 여기서 이분탐색으로 찾기
				int[] arr = new int[hm.get(group).size()];
				for (int j=0; j<hm.get(group).size(); j++) {
					arr[j] = hm.get(group).get(j);
				}
				int scoreIdx = binarySearch(score, arr);
				if (scoreIdx != -1)
					answer[i] = hm.get(group).size() - scoreIdx;
			}
			else { // -가 포함된 경우
				String[] groupSplit = group.split(" ");
				
				ArrayList<String> al = new ArrayList<>(); // 가능한 모든 query
				int range0 = groupSplit[0].equals("-")? 3 : 1;
				int range1 = groupSplit[1].equals("-")? 2 : 1;
				int range2 = groupSplit[2].equals("-")? 2 : 1;
				int range3 = groupSplit[3].equals("-")? 2 : 1;
				String[] s0 = {"cpp ", "java ", "python "};
				String[] s1 = {"backend ", "frontend "};
				String[] s2 = {"junior ", "senior "};
				String[] s3 = {"chicken ", "pizza "};
				
				//System.out.println(groupSplit[0]+" "+groupSplit[1]+" "+groupSplit[2]+" "+groupSplit[3]);
				//System.out.println(range0+" "+range1+" "+range2+" "+range3);
				for (int j=0; j<range0; j++) {
					for (int k=0; k<range1; k++) {
						for (int l=0; l<range2; l++) {
							for (int m=0; m<range3; m++) {
								String queryComplete = "";
								if (groupSplit[0].equals("-"))
									queryComplete += s0[j];
								else
									queryComplete += groupSplit[0]+" ";
								
								if (groupSplit[1].equals("-"))
									queryComplete += s1[k];
								else
									queryComplete += groupSplit[1]+" ";
								
								if (groupSplit[2].equals("-"))
									queryComplete += s2[l];
								else
									queryComplete += groupSplit[2]+" ";
								
								if (groupSplit[3].equals("-"))
									queryComplete += s3[m];
								else
									queryComplete += groupSplit[3]+" ";
								
								al.add(queryComplete);
							}
						}
					}
				}
				//System.out.println(al);
				for (int j=0; j<al.size(); j++) {
					String query1 = al.get(j); // query문 
					
					if (hm.containsKey(query1)) {
						Collections.sort(hm.get(query1));
						// 여기서 이분탐색으로 찾기
						
						int[] arr = new int[hm.get(query1).size()];
						for (int k=0; k<hm.get(query1).size(); k++) {
							arr[k] = hm.get(query1).get(k);
						}
						int scoreIdx = binarySearch(score, arr);
						if (scoreIdx != -1)
							answer[i] += hm.get(query1).size() - scoreIdx;
						
					}
					else {
						continue ;
					}
				}
			}
		}
		
		System.out.println("ANSWER");
		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
	}
	
	private static int binarySearch (int iKey, int arr[]) {
		int mid;
		int left = 0;
		int right = arr.length - 1;
		
		while (right >= left) {
			mid = (left + right) / 2;
			
			if (iKey <= arr[mid]) // 원래 == 인데 score이랑 같은 iKey값이 없을 수도 있으니까 arr[mid]가 iKey값 넘어가는 순간 종료해줌
				return mid ;
			if (iKey < arr[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		
		return -1; // 찾으려 하는 값 이상이 없으면 -1 리턴
	}

}
