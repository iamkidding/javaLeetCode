package javaLeetCode;

public class TwoDArrayFind {
//	��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж�����
//	���ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
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
