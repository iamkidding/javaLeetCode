package javaLeetCode;

public class TwoDArrayFind {
//	在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照
//	从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	public static boolean Find(int target, int [][] array) {
        if(array == null || array.length <= 0) return false;
        int i = rank(target, array) - 1;
        if (array[i][0] == target) return true;
        else if (binarySearch(target, array[i]))
        	return true;
        return false;
    }
	private static boolean binarySearch(int target, int[] array){
		int lo=0, hi=array.length-1;
		while(lo <= hi){
			int mid = (hi - lo) / 2 + lo;
			if (array[mid] > target) hi = mid - 1;
			else if (array[mid] < target) lo = mid + 1;
			else return true;
		}
		return false;
	}
	private static int rank(int target, int [][] array){
		int lo=0, hi=array.length-1;
		while (lo <= hi){
			int mid = (hi - lo) / 2 + lo;
			if (array[mid][0] > target) hi = mid - 1;
			else if (array[mid][0] < target) lo = mid + 1;
			else return mid;
		}
		return lo;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(7, array));
	}

}
