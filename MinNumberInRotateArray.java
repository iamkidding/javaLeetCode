package javaLeetCode;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
    	if (array == null || array.length <= 0)
    		System.out.println("invalid input");
    	int hi=array.length-1, lo=0;
    	int mid = 0;
    	
    	while (array[lo] >= array[hi]) {
    		if (hi-lo == 1) {mid = hi; break;}
    		mid = lo+(hi-lo)/2;
    		if (array[hi] == array[lo] && array[hi] == array[mid])
    			return minInorder(array, lo, hi);
    		if (array[mid] <= array[hi]) hi = mid;
    		else if (array[mid] >= array[lo]) lo = mid;
    	}
    	return array[mid];
    }
	
    public int minInorder(int[] array, int lo, int hi) {
    	int result = array[lo];
    	for (int i=lo+1; i<=hi; i++) {
    	    if (result > array[i])
    	    	result = array[i];
    	}
    	return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = {4, 5, 6, 1, 2, 3};
//        System.out.println(minNumberInRotateArray(arr));
	}

}
