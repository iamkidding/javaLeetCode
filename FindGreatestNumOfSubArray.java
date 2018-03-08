package javaLeetCode;

public class FindGreatestNumOfSubArray {
    public int findGreatestNumOfSubArray(int[] array){
        if (array.length == 0) return 0;
        int sum=0, cmp=0;

        for(int i=0; i<array.length; i++){
            cmp += array[i];
            if (cmp > sum) sum = cmp;
        }

        return sum;
    }
}
