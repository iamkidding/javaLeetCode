package javaLeetCode;

public class GetNumberOfK {
    public int getNumberOfK(int[] array, int k){
        // 时间复杂度O(n)
        int count = 0;
        if (array.length == 0) return count;

        for (int i=0; i<array.length; i++){
            if (array[i] == k) count++;
            if (array[i] != k && count != 0) break;
        }

        return count;
    }

    public int getNumberOfKB(int[] array, int k){
        // 时间复杂度O(logn)
        int count = 0;

        if (array != null && array.length > 0){
            int first = getFirstK(array, k, 0, array.length - 1);
            int last = getLastK(array, k, 0, array.length - 1);

            if (first > -1 && last > -1) count = last -first + 1;
        }

        return  count;
    }

    private int getFirstK(int [] array, int k, int start, int end){
        // 二分法，查找第一个k的位置
        if (start > end) return -1;

        int middleIndex = (start + end) / 2;
        int middleArray = array[middleIndex];
        if (middleArray == k){
            if ((middleIndex > 0 && array[middleIndex-1] != k)
                    || middleIndex == 0){
                return middleIndex;
            }
            else
                end = middleIndex - 1;
        }
        else if (middleArray > k)
            end = middleIndex - 1;
        else
            start = middleIndex + 1;

        return getFirstK(array, k, start, end);
    }

    private int getLastK(int[] array, int k, int start, int end){
        // 二分查找，找到最后一个k的位置
        if (start > end) return -1;

        int middleIndex = (start + end) / 2;
        int middleArray = array[middleIndex];

        if (middleArray == k){
            if ((middleIndex < array.length - 1 && array[middleIndex+1] != k)
                || middleIndex == array.length - 1){
                return middleIndex;
            }
            else
                start = middleIndex;
        }
        else if (middleArray < k)
            start = middleIndex + 1;
        else
            end = middleIndex - 1;

        return getLastK(array, k, start, end);
    }
}
