package level3;

import java.util.ArrayList;

public class notepad {
	static class Pos {
		int y;
		int x;
		Pos (int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		public boolean equals(Pos p) {
	        boolean same = false;
			if (p != null && p instanceof Pos) {
	            same = (y == p.y && x == p.x);
	        }
	        return same;
		}
	}
	public static void main(String[] args) {
		int lock[][] = {{1,1,1}, 
						{1,1,0}, 
						{1,0,1}};

		int N = lock.length;
		for (int x=0; x<N; x++) {
			System.out.println("x = "+x);
			for (int i=0; i<N-x; i++) {
				for (int j=0; j<N-x; j++) {
					System.out.println(" i, j = "+i+" "+j);
					if (x==0)
						continue ;
					for (int k=0; k<x+1; k++) {
						for (int l=0; l<x+1; l++) {
							System.out.println("  k, l = "+(i+k)+" "+(j+l));
						}
					}
				}
			}
			System.out.println();
		}
		
		ArrayList<Pos> al = new ArrayList<>();
		al.add(new Pos(1, 2));
		al.add(new Pos(3, 4));
		
		if (al.contains(new Pos(3, 4)))
			System.out.println("true");
		else
			System.out.println("false");
	
	}
}
