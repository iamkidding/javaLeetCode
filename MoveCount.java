package javaLeetCode;

public class MoveCount {
	public static int moveCount(int threshold, int rows, int cols) {
		if (threshold < 0 || rows <= 0 || cols <= 0) return 0;
		
		int count = 0;
		count = path(threshold, rows, cols, 0, 0);
		return count;
	}
	
	private static int path(int threshold, int rows, int cols, int x, int y) {
		int count = 0;
		
		if(x + y <= threshold && x >= 0 && x < rows && y >= 0 && y < cols) {	
	        count = path(threshold, rows, cols, x+1, y) + 
	      	    	path(threshold, rows, cols, x-1, y) +
	       		    path(threshold, rows, cols, x, y+1) +
	       		    path(threshold, rows, cols, x, y-1) + 1;
		}
		return count;
	}

	public static void main(String[] args) {
		int n = moveCount(5, 5, 6);
		System.out.println(n);
	}
}
