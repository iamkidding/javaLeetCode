package javaLeetCode;
//排名60%，运行时间18ms
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int i = 0;
        int xl = 0, yl = 0;
        while(x > 0 && y > 0){
        	xl = x % 2;
        	x = x / 2;
        	yl = y % 2;
        	y = y / 2;
        	if (xl != yl) i++;
        }
        while(x != 0){
       	    xl = x % 2;
       	    x = x / 2;
       	    if (xl == 1) i++;
        }
       	while(y != 0){
       	    yl = y % 2;
       	    if (yl == 1) i++;       	  
       	    y = y / 2;
        }
        return i;
    }
	public static void main(String[] args) {
        int m = hammingDistance(4, 11);
        System.out.println(m);
	}
}
