package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * 소요 시간: 1시간
 * ★★★☆☆, Cheating : X
 * 뭔가 문제도 시험을 위한 문제 느낌이라 이해도 잘 안되고 딱보니 Comparator아님 Comparable 써야 해서 못 풀줄 알았는데
 * Comparator sort 어떻게 하는지 구글링해서 한 번에 바로 맞췄다. 
 * Comparator랑 Comparable은 코테에 종종 나오는데도 날 잡고 공부하기가 너무 귀찮다. 이해 안 하고 필요할 때만 찾아써야 제맛.
 */
public class 파일명정렬 {
	static class File {
		String Head;
		int Number;
		String Tail;
		int Seq; //배열에서 몇 번째 idx인지 (answer 배열 만들기 위함)
		
		File (String Head, int Number, String Tail, int Seq) {
			this.Head = Head;
			this.Number = Number;
			this.Tail = Tail;
			this.Seq = Seq;
		}
	}

	public static void main(String[] args) {
		/*
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", 
				"img2.JPG"};
		*/
		
		String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", 
						"F-14 Tomcat"};
		
		/*
		String[] files = {"foo9.txt", "foo010bar020.zip", "F-15"};
		*/
		String[] answer = {};
		
		ArrayList<File> al = new ArrayList<>();
		
		for (int i=0; i<files.length; i++) {
			int nStart = 0; // HEAD NUMBER TAIL 중 NUMBER 시작 idx
			int nEnd = 0; // NUMBER 끝 idx
			for (int j=0; j<files[i].length(); j++) {
				if ('0' <= files[i].charAt(j) && files[i].charAt(j) <= '9') {
					if (nStart == 0) {
						nStart = j;
					}
				}
				else {
					if (nStart != 0) { 
						nEnd = j-1;
						break ;
					}
				}
			}
			if (nEnd == 0)  // TAIL이 없을 때 
				nEnd = files[i].length()-1;
			
			// Head, Number, Tail 파싱해서 ArrayList(al)에 넣기
			String head = files[i].substring(0, nStart);
			String numberTmp = files[i].substring(nStart, nEnd+1);
			int number = Integer.parseInt(numberTmp);
			String tail = files[i].substring(nEnd+1, files[i].length());
			//System.out.println(head+"/"+number+"/"+tail);
			File f = new File(head, number, tail, i);
			al.add(f);
			
		}
		
		// HEAD 기준 사전 순 정렬. 대소문자 구분 X (둘 다 같으면 원래 입력 순서 유지하는건 어차피 al 순서 있어서 신경 안 써도 됨.)
		Collections.sort(al, new Comparator<File>() {
	        public int compare(File f1, File f2) {
	        	// HEAD가 같으면 NUMBER 숫자 순 정렬
	        	if (f1.Head.compareToIgnoreCase(f2.Head) == 0) {
	        		return Integer.compare(f1.Number, f2.Number);
	        	}
	            return f1.Head.compareToIgnoreCase(f2.Head);
	        } 
	    });
		/*
		System.out.println();
		for (int i=0; i<al.size(); i++) {
			File f = al.get(i);
			System.out.println(f.Head+" "+f.Number+" "+f.Tail+" "+f.Seq);
		}
		*/
		answer = new String[files.length];
		for (int i=0; i<al.size(); i++) {
			File f = al.get(i);
			answer[i] = files[f.Seq];
		}
		
		for (int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
		
	
	}

}
