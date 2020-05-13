package KakaoIntern2020;

import java.util.LinkedList;

public class _2 {

	public static void main(String[] args) {
		String expression = new String("50*6-3*2");
		long[] resultArr = new long[6];

		LinkedList operatorQueue = new LinkedList<Character>();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '*') {
				operatorQueue.add('*');
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+') {
				operatorQueue.add('+');
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '-') {
				operatorQueue.add('-');
			}
		}
		resultArr[0] = dfs(expression, operatorQueue);

		LinkedList operatorQueue2 = new LinkedList<Character>();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '*') {
				operatorQueue2.add('*');
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '-') {
				operatorQueue2.add('-');
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+') {
				operatorQueue2.add('+');
			}
		}
		resultArr[1] = dfs(expression, operatorQueue2);

		LinkedList operatorQueue3 = new LinkedList<Character>();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+') {
				operatorQueue3.add('+');
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '*') {
				operatorQueue3.add('*');
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '-') {
				operatorQueue3.add('-');
			}
		}
		resultArr[2] = dfs(expression, operatorQueue3);

		LinkedList operatorQueue4 = new LinkedList<Character>();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+') {
				operatorQueue4.add('+');
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '-') {
				operatorQueue4.add('-');
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '*') {
				operatorQueue4.add('*');
			}
		}
		resultArr[3] = dfs(expression, operatorQueue4);

		LinkedList operatorQueue5 = new LinkedList<Character>();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '-') {
				operatorQueue5.add('-');
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '*') {
				operatorQueue5.add('*');
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+') {
				operatorQueue5.add('+');
			}
		}
		resultArr[4] = dfs(expression, operatorQueue5);

		LinkedList operatorQueue6 = new LinkedList<Character>();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '-') {
				operatorQueue6.add('-');
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+') {
				operatorQueue6.add('+');
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '*') {
				operatorQueue6.add('*');
			}
		}
		resultArr[5] = dfs(expression, operatorQueue6);

		long result = 0;
		for (int i = 0; i < resultArr.length; i++) {
			if (resultArr[i] < 0) {
				resultArr[i] = resultArr[i] * -1;
			}
			if (resultArr[i] > result) {
				result = resultArr[i];
			}
		}

		System.out.println(result);
	}

	public static long dfs(String expression, LinkedList<Character> operatorQueue) {
		long result = 0;
		if (operatorQueue.isEmpty() == true) {
			if (expression.charAt(0) == '%') {
				String c = "-";
				result = Long.parseLong(c.concat(expression.substring(1)));
			} else {
				result = Long.parseLong(expression);
			}
			return result;
		}

		char op = operatorQueue.removeFirst();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == op) {
				String newExpression = reExpression(expression, i);
				result = result + dfs(newExpression, operatorQueue); // parameter 주소값인지 확인할 것.
				break;
			}
		}
		return result;
	}

	public static String reExpression(String expression, int index) {
		long firstNum = 0;
		String firstExpression = "";
		String sfirstNum = "";
		for (int i = 2; i < expression.length(); i++) {
			if (index - i == -1) {
				sfirstNum = expression.substring(0, index);
				if (sfirstNum.charAt(0) == '%') {
					String c = "-";
					sfirstNum = c.concat(sfirstNum.substring(1));
					firstNum = Long.parseLong(sfirstNum);
				} else {
					firstNum = Long.parseLong(sfirstNum);
				}
				break;
			}
			char a = expression.charAt(index - i);
			if (a == '*' || a == '+' || a == '-') {
				sfirstNum = expression.substring(index - i + 1, index);
				if (sfirstNum.charAt(0) == '%') {
					String c = "-";
					sfirstNum = c.concat(sfirstNum.substring(1));
					firstNum = Long.parseLong(sfirstNum);
				} else {
					firstNum = Long.parseLong(sfirstNum);
				}
				firstExpression = expression.substring(0, index - i + 1);
				firstNum = Long.parseLong(sfirstNum);
				break;
			}
		}

		String secondExpression = "";
		long secondNum = 0;
		String ssecondNum = "";
		for (int i = 2; i < expression.length(); i++) {
			if (index + i == expression.length()) {
				ssecondNum = expression.substring(index + 1);
				if (ssecondNum.charAt(0) == '%') {
					String c = "-";
					ssecondNum = c.concat(ssecondNum.substring(1));
					secondNum = Long.parseLong(ssecondNum);
				} else {
					secondNum = Long.parseLong(ssecondNum);
				}
				break;
			}
			char a = expression.charAt(index + i);
			if (a == '*' || a == '+' || a == '-') {
				ssecondNum = expression.substring(index + 1, index + i);
				if (ssecondNum.charAt(0) == '%') {
					String c = "-";
					ssecondNum = c.concat(ssecondNum.substring(1));
					secondNum = Long.parseLong(ssecondNum);
				} else {
					secondNum = Long.parseLong(ssecondNum);
				}
				secondExpression = expression.substring(index + i);
				secondNum = Long.parseLong(ssecondNum);
				break;
			}
		}

		long newNum = 0;
		switch (expression.charAt(index)) {
		case '+':
			newNum = firstNum + secondNum;
			break;
		case '-':
			newNum = firstNum - secondNum;
			break;
		case '*':
			newNum = firstNum * secondNum;
			break;
		}

		String snewNum = "";
		if (newNum < 0) {
			newNum = newNum * -1;
			String b = "%";
			snewNum = b.concat(Long.toString(newNum));
		} else {
			snewNum = Long.toString(newNum);
		}

		String tempExpression = firstExpression.concat(snewNum);
		String newExpression = tempExpression.concat(secondExpression);

		return newExpression;
	}
}