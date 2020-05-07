package KakaoIntern2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 튜플2 {

	public static void main(String[] args) {
		//String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		//String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		//String s = "{{20,111},{111}}";
		//String s = "{{123}}";
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		
		//1. ArrayList의 배열 만들어서 한 줄씩 넣는다
		
		int col = -1; //ArrayList 배열의 세로 값
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) == '}')
				col++;
		}
		
		ArrayList<Integer> []a;
		a = new ArrayList[col];
		for (int i=0; i<col; i++)
			a[i] = new ArrayList<Integer>();
		
		int idx = 0;
		String[] strs = s.split(",");
		for (int i=0; i<strs.length; i++) {
			//System.out.println(strs[i]);
			//System.out.println();
			int nextFlag = 0; //다음 줄로 넘어감
			if (strs[i].contains("}"))
				nextFlag = 1;
			strs[i] = strs[i].replaceAll("[^0-9]","");
			a[idx].add(Integer.parseInt(strs[i]));
			if (nextFlag == 1)
				idx++;
			
		}
		/*
		for (int i=0; i<col; i++) {
			System.out.println(a[i]);
		}
		System.out.println();
		*/
		//2. ArrayList의 배열을 크기 순서대로 정렬
		Arrays.sort(a, new Comparator<ArrayList>(){
		    public int compare(ArrayList a1, ArrayList a2) {
		        return  a1.size() - a2.size();
		    }
		});
		
		
		//3. 중복 제외하고 ans배열에 넣기
		idx = 0;
		ArrayList ans = new ArrayList<Integer>();
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[i].size(); j++) {
				if(!ans.contains(a[i].get(j)))
					ans.add(a[i].get(j));
			}
		}
		
		System.out.println(ans);
		
		int[] answer = new int[ans.size()];
		for(int i=0; i<ans.size(); i++)
			answer[i] = (int) ans.get(i);
		
		//for (int i=0; i<answer.length; i++)
			//System.out.println(answer[i]);
		
	}

}
