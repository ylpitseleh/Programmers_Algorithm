package Greedy;

public class 큰수만들기 {

	public static void main(String[] args) {
		//String number = "1924";
		//int k = 2;
		String number = "1231234";
		int k = 3;
		//String number = "775841";
		//int k = 4;
		
		//String answer = "";
		
		StringBuilder answer = new StringBuilder();
		int maxIdx = -1;
		for (int i=0; i<number.length()-k; i++) {
			int max = 0;
			for (int j=maxIdx+1; j<=k+i; j++) { //k+i를 못 생각해냈다. 
				if (max < number.charAt(j)-'0') {
					max = number.charAt(j)-'0';
					maxIdx = j;
				}
				System.out.println(i+" "+number.charAt(j)+" "+maxIdx);
			}
			answer.append(max);
		}
		System.out.println(answer);
	}

}
