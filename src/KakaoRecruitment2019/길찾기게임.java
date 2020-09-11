package KakaoRecruitment2019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/*
 * 소요 시간: 1시간 30분
 * ★★★★★, Cheating : O
 * 이진 트리 어떻게 구현하는지 아이디어만 있으면 (class로 처리) 
 * 전위 순회, 후위 순회 구글링해서 구현은 어렵지 않은 문제.
 * 다만 트리 나오면 풀 의욕이 떨어지는것만 방지하면 되겠다. 
 * 낯설어서 그렇지 어려운 문제는 아니었다. 
 * https://www.youtube.com/watch?v=J8YxDIauh1g
 */
public class 길찾기게임 {
	static class Node{
		int idx;
		int y;
		int x;
		Node left;
		Node right;
		Node (int idx, int y, int x) {
			this.idx = idx;
			this.y = y;
			this.x = x;
		}

	}
	static List<Node> Nodes = new ArrayList<>();
	static Comparator<Node> Comp = new Comparator<Node>() {
		public int compare(Node a, Node b) {
			if (a.y == b.y)
				return a.x - b.x;
			return b.y - a.y;
		}
	};
	static int idx = 0;
	
	public static void main(String[] args) {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		
		int N = nodeinfo.length;
		for (int i=0; i<N; i++) {
			Nodes.add(new Node(i+1, nodeinfo[i][1], nodeinfo[i][0]));
		}
		Nodes.sort(Comp);
		
		// 이진트리 완성하기 (left Node, right Node값 넣어주기)
		Node root = Nodes.get(0);
		for (int i=1; i<N; i++) {
			addNode(root, Nodes.get(i));
		}
		
		int[][] answer = new int[2][N];
		preorder(answer, root);
		idx = 0;
		postorder(answer, root);
		
		for (int i=0; i<N; i++) {
			System.out.print(answer[0][i]+" ");
		}
		System.out.println();
		for (int i=0; i<N; i++) {
			System.out.print(answer[1][i]+" ");
		}
	}
	
	// 개천재... 무친.. 
	private static void addNode(Node parent, Node child) {
		if (child.x < parent.x) {
			if (parent.left == null)
				parent.left = child;
			else
				addNode(parent.left, child);
		}
		else {
			if (parent.right == null)
				parent.right = child;
			else
				addNode(parent.right, child);
		}
	}
	
	// 전위 순회
	private static void preorder(int[][] answer, Node node) {
		if (node == null)
			return ;
		
		answer[0][idx++] = node.idx;
		preorder(answer, node.left);
		preorder(answer, node.right);
	}
	
	// 후위 순회
	private static void postorder(int[][] answer, Node node) {
		if (node == null)
			return ;
		
		postorder(answer, node.left);
		postorder(answer, node.right);
		answer[1][idx++] = node.idx;
	}
}
