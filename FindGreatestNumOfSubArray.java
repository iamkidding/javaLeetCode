package javaLeetCode;

public class FindGreatestNumOfSubArray {
    public int findGreatestNumOfSubArrayB(int[] array){
        if (array.length == 0) return 0;

        int sum=0x80000000, cmp=0;

        for (int i=0; i<array.length; i++){
            if (cmp <= 0) cmp = array[i];
            else cmp += array[i];

            if (cmp > sum) sum = cmp;
        }

        return sum;
    }

    public static void main(String[] args){
        int[] test = {-2,-8,-1,-5,-9};

        System.out.print((new FindGreatestNumOfSubArray()).findGreatestNumOfSubArrayB(test));
    }
}
