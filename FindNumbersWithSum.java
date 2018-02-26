package javaLeetCode;

import java.util.ArrayList;
public class FindNumbersWithSum {
    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum){
        ArrayList<Integer> numbers = new ArrayList<>();
        if (array.length <= 0) return numbers;

        int count = 0;
        for (int i=0; i<array.length-1; i++){
            int anotherIndex = binarySearch(array, i, array.length-1, sum - array[i]);
            if (anotherIndex != -1){
                numbers.add(array[i]);
                numbers.add(array[anotherIndex]);
                count++;
            }
            if (count == 1) break;
        }

        return numbers;
    }

    private static int binarySearch(int[] array, int lo, int hi, int target){
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (array[mid] > target) hi = mid - 1;
            else if (array[mid] < target)lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public ArrayList<Integer> findNumberWithSumB(int[] array, int sum){
        if (array.length <= 0) return null;

        ArrayList<Integer> numbers = new ArrayList<>();
        int ahead = 0, behind = array.length-1;
        while (ahead < behind){
            int arraySum = array[behind] + array[ahead];
            if (arraySum == sum){
                numbers.add(array[ahead]);
                numbers.add(array[behind]);
                break;
            }
            else if (arraySum > sum) behind--;
            else ahead++;
        }
        return numbers;
    }

    public static void main(String[] args){
        int[] array = {1, 3, 4, 6, 8, 10, 12};
        int[] array3 = {1, 2, 4, 7, 11, 15};
        int[] array2 = {};
        ArrayList<Integer> numbers = findNumbersWithSum(array, 13);
        ArrayList<Integer> numbers2 = findNumbersWithSum(array2, 13);
        ArrayList<Integer> numbers3 = findNumbersWithSum(array3, 15);
        System.out.print(numbers3);
//        for (int num:numbers){
//            System.out.print(num); // 结果是33443542，why？
//        }

    }
}
