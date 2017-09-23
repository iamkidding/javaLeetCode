package javaLeetCode;

public class DuplicateArray {
//	��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��
//	֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡� ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
	// Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
	public static boolean duplicate(int numbers[], int length, int [] duplication) {
		if(numbers == null || numbers.length <= 0) return false;
	        quickSort(numbers);
	        for(int i = 0; i < length - 1; i++)
	    	    if(numbers[i] == numbers[i+1]) {
	    		    duplication[0] = numbers[i];
	    		    return true;
	    	    }
	    return false;
    }
	
	private static void quickSort(int[] nums){
		quickSort(nums, 0, nums.length-1);
	}
	private static void quickSort(int[] a, int lo, int hi){
		if (hi <= lo) return;
		int lt=lo, i=lo+1, gt=hi;
		int v = a[lo];
		while(i <= gt){
			if(v > a[i]) exch(a, lt++, i++);
			else if(v < a[i]) exch(a, i, gt--);
			else i++;
		}
		quickSort(a, lo, lt-1);
		quickSort(a, gt+1, hi);
	}
	private static void exch(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
    public static void main(String[] args){
    	int[] nums = {2, 1, 3, 1, 4};
    	int[] dup = new int[1];
//    	quickSort(nums, 0, nums.length-1);
//    	for(int i=0; i<nums.length; i++)
//    		System.out.print(nums[i]);
//    	int[] num = {};
//    	System.out.println(num==null);
    	System.out.println(duplicateB(nums, 5, dup));
    	
    }
    
    public static boolean duplicateB(int numbers[], int length, int [] duplication) {
    	for(int i=0; i<length; i++){
    		while (numbers[i] != i){
    			if (numbers[numbers[i]] == numbers[i]){
        			duplication[0] = numbers[i]; 
    				return true;
        		}
    			int j = numbers[i];
			    numbers[i] = numbers[j];
			    numbers[j] = j;
			    }	
    	}
    	return false;
    }
}
