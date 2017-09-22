package javaLeetCode;

public class TwoDArrayFind {
//	在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照
//	从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	public static boolean Find(int target, int [][] array) {
        if(array == null || array.length <= 0) return false;
        int i = 0, j = array[0].length-1;
        while (j >= 0 && i < array[0].length){
            int cmp = array[i][j];
            if (target == cmp) return true;
            else if (target < cmp) j--;
            else i++;
        }
        return false;        
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(7, array));
	}
}
