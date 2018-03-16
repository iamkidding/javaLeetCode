package javaLeetCode;

public class InversePairs {
    public static int inversePairs(int[] array){
        // 复杂度n2
        if (array == null || array.length == 0) return 0;

        int P = 0;
        int currenIndex=1, preIndex; // 两个指针
        for (; currenIndex<array.length; currenIndex++){
            preIndex = currenIndex - 1;
            if (array[currenIndex] < array[preIndex]){
                P++; // 如果当前指针指向的数小于前一个数，逆序对++
                preIndex--;
                while (preIndex >= 0){ // 往前查找是否有比当前数更大的数
                    if (array[currenIndex] < array[preIndex]) P++;
                    preIndex--;
                }
            }
        }

        return P % 1000000007;
    }

    public int inversePairsB(int[] array){
        if (array == null || array.length == 0) return 0;

        int[] copy = new int[array.length];
        for (int i=0; i<array.length; i++)
            copy[i] = array[i];

        int count = inversePairsCore(array, copy, 0, array.length-1);
        return count;
    }

    private int inversePairsCore(int[] array, int[] copy, int start, int end){
        if (start == end){
            copy[start] = array[start];
            return 0;
        }

        int len = (end - start) / 2;

        int left = inversePairsCore(copy, array, start, start + len);
        int right = inversePairsCore(copy, array, start + len + 1, end);

        int i = start + len;
        int j = end;
        int indexCopy = end, count = 0;
        while (i >= start && j>= start+len+1){
            if (array[i] > array[j]){
                copy[indexCopy--] = array[i--];
                count += j - start -len;
            }
            else{
                copy[indexCopy--] = array[j--];
            }
        }

        for (; i>=start; --i)
            copy[indexCopy--] = array[i];
        for (; j>=start+len; --j)
            copy[indexCopy--] = array[j];

        return left + right + count;
    }

    public static void main(String[] args){
        int[] array = {1, 2, 3, 5, 4, 6, 7, 0};
        System.out.print(inversePairs(array));
    }
}
