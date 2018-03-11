package javaLeetCode;

import java.util.ArrayList;

public class GetLeastNumbers {
    public ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        ArrayList<Integer> results = new ArrayList<>();

        if (input.length == 0 || k <= 0 || k > input.length) return results;

        int lessNumber = 2147483647; // Integer的最大值
        int index = 0, count = 0;// 用index记录input数组最小值位置
        int[] finalIndex = new int[input.length]; // 使用和input数组等长的数组记录较小值的index，避免重复

        while (count < k) {
            for (int i = 0; i < input.length; i++) {
                // 和finalIndex中比较，如果该位置数已经添加过，则跳过
                if (input[i] <= lessNumber && finalIndex[i] == 0) {
                    index = i;
                    lessNumber = input[i];
                }
            }
            finalIndex[index]++; // 记录该位置已经被添加进去
            results.add(lessNumber);
            lessNumber = 2147483647;
            count++;
        }

        return results;
    }

    public static void main(String[] args){
        int[] input = {1, 5, 1, 6, 2, 7, 3, 8};
        System.out.print((new GetLeastNumbers()).getLeastNumbers(input, 4));
    }
}
