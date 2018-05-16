package javaLeetCode;

import java.util.HashMap;

/**
* @author j
*
*/
public class TwoSum {

	/**
	 * @param args
	 */
	private static void exch(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void quickSort(int[] a){
		quickSort(a, 0, a.length-1);
	}
	private static void quickSort(int[] a, int lo, int hi){
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		quickSort(a, lo, j-1);
		quickSort(a, j+1, hi);
	}
	private static int partition(int[] a, int lo, int hi){
		int v =  a[lo];
		int i = lo, j = hi;
		while (true){
			while (a[++i] < v) if( i == hi) break;
			while (a[j--] > v) if( j == lo) break;
			if(i >= j) break;
			exch(a, i, j);
			}
		exch(a, lo, j);
		return j;
	}
	public static void findTwoSum(int[] a, int target){
		int j = -1;
		quickSort(a);
		int[] result = new int[2];
		for (int i=0; i < a.length; i++){
			int t = target - a[i];
			if (t < a[i])
				j = binarySearch(a, 0, i-1, t);
			else if(t > a[i])
			    j = binarySearch(a, i+1, a.length-1, t);
			if (j != -1){
				result[0] = i;
			    result[1] = j;
			    break;
			}
		}
		for (int i=0; i < result.length; i++)
	        System.out.print(result[i]);
	}
	private static int binarySearch(int[] a, int lo, int hi, int key){
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			if (a[mid] < key)
				hi = mid - 1;
			else if (a[mid] > key)
				lo = mid + 1;
			else if (a[mid] == key)
				return mid;
		}
		return -1;
	}
	public static int[] findTwoSumB(int[] nums, int target){
        HashMap<Integer, Integer> search = new HashMap<>();
        int[] result = {-1, -1};
        int temp;

        for (int i=0; i<nums.length; i++){
            search.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++){
            temp = target - nums[i];
            System.out.println(nums[i]);
            if (search.containsKey(temp)){
                result[1] = i;
                result[0] = search.get(temp);
                if (result[0] != result[1])
                    break;
            }
        }

        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] nums = {14, 21, 2, 7, 11, 15};
       int[] ns = {2,7,11,15};
       nums = findTwoSumB(ns, 9);
       System.out.print(nums[0]+","+nums[1]);
	}

}
