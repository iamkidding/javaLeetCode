package javaLeetCode;

public class MoreThanHalfNum {
    public int moreThanHalfNum(int [] array){
        if (array.length <= 0) return 0;

        int middle = array.length >> 1;
        int start = 0;
        int end = array.length-1;
        int index = partition(array, start, end);

        while (index != middle){
            if (index > middle){
                end = index - 1;
                index = partition(array, start, end);
            }
            else {
                start = index + 1;
                index = partition(array, start, end);
            }
        }

        int result = array[index];
        if (!checkMoreThanHalf(array, result)) return 0;
        return result;
    }

    public int partition(int[] array, int lo, int hi){
        int i = lo, j = hi+1;
        int cmp = array[lo];

        while (true){
            while (array[i++] < cmp) if (i == hi) break;
            while (array[--j] > cmp) if (j == lo) break;
            if (i >= j) break;
            exch(array[i], array[j]);
        }
        exch(array[lo], array[j]);
        return j;
    }

    private void exch(int x, int y){
        int i = x;
        x = y;
        y = i;
    }

    private boolean checkMoreThanHalf(int[] array, int number){
        int count = 0;
        for (int i=0; i<array.length; i++){
            if (array[i] == number) count++;
        }

        boolean isMoreThanHalf = true;
        if (count*2 <= array.length){
            isMoreThanHalf = false;
        }

        return isMoreThanHalf;
    }

//    public static void main(String[] args){
//        int[] a = {5, 6, 3, 4, 5, 5, 5};
//        System.out.print(moreThanHalfNum(a));
////        System.out.print(partition(a, 0, a.length-1));
////        System.out.print(a.length >> 1);
//    }
}
