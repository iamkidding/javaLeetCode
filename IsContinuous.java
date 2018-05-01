package javaLeetCode;

import java.util.Arrays;
public class IsContinuous {
    public boolean isContinuous(int [] numbers){
        if (numbers.length == 0) return false;
//      对数组排序
        Arrays.sort(numbers);
//      计算数组中0的个数和数字之间的差值
//      如果差值可以使用0弥补，返回true，否则false
//      当有4个0的时候，0可以当做任何数字，所以肯定是顺子
        int numOf0 = 0;
        int gap = 0;
        for (int i=1; i<numbers.length; i++){
            if (numbers[i] != 0 && numbers[i] == numbers[i-1]) return false;
            else if (numbers[i-1] != 0 && numbers[i] - numbers[i-1] > 1)
                gap += numbers[i] - numbers[i-1] - 1;
            if (numbers[i] == 0) numOf0++;
        }
        if (numbers[0] == 0) numOf0++;

        return numOf0 == 4 || gap == numOf0;
    }

    public static void main(String[] args){
        int[] i = {3, 0, 0, 0, 0};

        System.out.println(new IsContinuous().isContinuous(i));
    }
}
