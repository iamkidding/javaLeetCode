package javaLeetCode;

public class Fibonacci {
    public static int fibonacciSong(int n) {
    	int fn = 0;
    	if (n == 1) fn = 1;
    	else if (n > 1) {
     	    fn = fibonacciSong(n-2) + fibonacciSong(n-1);
    	}
    	return fn;
    }
    public static int fibonacci(int n) {
    	int[] result = {0,1};
    	if (n <= 1) return result[n];
    	
    	int fnSub2 = 0, fnSub1 = 1, fn = 0;
    	for (int i=2; i<=n; i++) {
    		fn = fnSub2 + fnSub1;
    		fnSub2 = fnSub1;
    		fnSub1 = fn;
    	}
    	return fn;
    }
    public static void main(String[] args) {
    	System.out.println(fibonacci(8));
    }
}
