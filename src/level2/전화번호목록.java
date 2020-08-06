package level2;
/*
 * 소요 시간: 30분
 * ☆☆☆☆☆, Cheating : X
 * 너무 쉬워서 코멘트 쓸 가치 X. StartsWith 쓰면 끝.
 */
public class 전화번호목록 {

	public static void main(String[] args) {
		// String phone_book[] = {"119", "97674223", "1195524421"};
		 //String phone_book[] = {"123", "456", "789"};
		//String phone_book[] = {"12", "123", "1235", "567", "88"};
		String phone_book[] = { "112", "01123", "1235", "567", "88", "1" };
		
		boolean answer = true;
		
		for (int i=0; i<phone_book.length; i++) {
			
			for (int j=0; j<phone_book.length; j++) {
				if(phone_book[j].startsWith(phone_book[i]) || phone_book[i].startsWith(phone_book[j])) {
					answer = false;
					//break ;
				}
			}
			
			if (answer == false)
				break ;
		}
		
		System.out.println(answer);
	}

}
