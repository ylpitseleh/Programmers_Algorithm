package level4;

import java.util.HashMap;
import java.util.Map;
// Trie 자료구조라는걸 알아야한다. 나중에 공부하기. 

public class 가사검색 {
	static class Node {
		Map<Character, Node> children;
		int count;

		Node() {
			this.children = new HashMap<>();
			this.count = 0;
		}
	}
	
	static class Trie {
		Node front;
		Node back;

		Trie() {
			this.front = new Node();
			this.back = new Node();
		}

		public void insert(String word) {
			insertFront(word);
			insertBack(word);
		}

		private void insertFront(String word) {
			Node node = front;
			for (int i = 0; i < word.length(); i++) {
				node.count++;
				node = node.children.computeIfAbsent(word.charAt(i), c -> new Node());
			}
		}

		private void insertBack(String word) {
			Node node = back;
			for (int i = word.length() - 1; i >= 0; i--) {
				node.count++;
				node = node.children.computeIfAbsent(word.charAt(i), c -> new Node());
			}
		}

		public int getCount(String query) {
			if (query.charAt(0) == '?')
				return getCountFromBack(query);
			else
				return getCountFromFront(query);
		}

		private int getCountFromFront(String query) {
			Node node = front;
			for (int i = 0; i < query.length(); i++) {
				if (query.charAt(i) == '?')
					break;
				if (!node.children.containsKey(query.charAt(i)))
					return 0;
				node = node.children.get(query.charAt(i));
			}
			return node.count;
		}

		private int getCountFromBack(String query) {
			Node node = back;
			for (int i = query.length() - 1; i >= 0; i--) {
				if (query.charAt(i) == '?')
					break;
				if (!node.children.containsKey(query.charAt(i)))
					return 0;
				node = node.children.get(query.charAt(i));
			}
			return node.count;
		}
	}
	
	public static void main(String[] args) {
		String words[] = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String queries[] = { "fro??", "????o", "fr???", "fro???", "pro?" };

		Trie[] tries = new Trie[100001];
		for (int i=0; i<words.length; i++) {
			int len = words[i].length();
			if (tries[len] == null)
				tries[len] = new Trie();
			tries[len].insert(words[i]);
		}
		
		int answer[] = new int[queries.length];
		for (int i=0; i<queries.length; i++) {
			int len = queries[i].length();
			if (tries[len] == null)
				answer[i] = 0;
			else
				answer[i] = tries[len].getCount(queries[i]);
		}
		
		for (int i=0; i<queries.length; i++)
			System.out.print(answer[i]+" ");
		//return answer;
	}


}
