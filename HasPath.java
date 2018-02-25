package javaLeetCode;
//没编完？
public class HasPath {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
    	if (matrix == null || matrix.length <= 0) return false; 
    	if (str == null || str.length <= 0) return false;
    	int index=0;

    	for (int i=0; i<matrix.length; i++) {
    		while (index < str.length) {
    			if (matrix[i] == str[index]) {
    				index++;
    			}
    		}
    	}
    	return true;
    }
    
    public boolean cmp(char[] matrix, char[] str, int i, int index, int cols) {
    	boolean[] hV = new boolean[matrix.length];
    	if (i+1 < matrix.length && str[index] == matrix[i+1] && hV[i+1] != true) {
    		hV[i+1] = true;
    		cmp(matrix, str, i+1, index++, cols);
    	}
    	if (i-1 >= 0 && str[i] == matrix[i-1] && hV[i-1] != true) {
    		hV[i-1] = true;
    		cmp(matrix, str, i-1, index++, cols);
    	}
    	if (i+cols <= matrix.length &&  str[index] == matrix[i+cols] && hV[i+cols] != true) {
    		hV[i+cols] = true;
    		cmp(matrix, str, i+cols, index++, cols);
    	}
    	if (i-cols >= 0 && str[i] == matrix[i-cols] && hV[i-cols] != true) {
    		hV[i-cols] = true;
    		cmp(matrix, str, i-cols, index++, cols);
		}    	
    	return false;
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        char[] m = { 'a', 'b', 't', 'g', 'c', 'f', 'c', 's', 'j', 'd', 'e', 'h'};
        char[] s1 = {'b', 'f','c','e'};
        char[] s2 = {'a', 'b','f','b'};
        System.out.println(hasPath(m, 3, 4, s1));
        System.out.println(hasPath(m, 3, 4, s2));
	}

}
//if ((i+1 < matrix.length && str[index] == matrix[i+1] && hV[i+1] != true)
//		|| (i-1 >= 0 && str[i] == matrix[i-1] && hV[i-1] != true)
//		|| (i+cols <= matrix.length &&  str[index] == matrix[i+cols] && hV[i+cols] != true)
//		|| (i-cols >= 0 && str[i] == matrix[i-cols] && hV[i-cols] != true)) {
//	return true;
//}