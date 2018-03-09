package javaLeetCode;

public class GetUglyNumber {
    public static int getUglyNumber(int index){
        if (index <= 0) return 0;
        if (index == 1) return 1;

        int number = 1;
        int count = 1; // 标记已经计算到第几个丑数

        while (count <= index){
            number++;
            if (isUglyNumber(number)){
                count++;
            }
        }

        return number;
    }

    private static boolean isUglyNumber(int number){
        // 分解因子，分解不了的时候用下个因子分解，最后结果不为1的话，说明有其他因子
        while (number % 2 == 0){
            number /= 2;
        }
        while(number % 3 == 0){
            number /= 3;
        }
        while(number % 5 == 0){
            number /= 5;
        }

        return number == 1;
    }

    public static int getUglyNumberB(int index){
        if (index <= 0) return 0;
        // 用一个数组保存计算出的丑数
        int [] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        // 使用3个指针来确保当前指针指向的数乘以所代表的基础丑数（2,3,5）不在数组里面
        int multiply2=0, multiply3=0, multiply5=0;

        while (nextUglyIndex < index){
            int min = Min(uglyNumbers[multiply2]*2, uglyNumbers[multiply3]*3, uglyNumbers[multiply5]*5);
            uglyNumbers[nextUglyIndex] = min;
            // 目前最大的丑数是数组最后一个
            // 如果当前指针指向的数乘以所代表的基础丑数小于数组中的最大丑数，则乘后丑数已在数组里面
            while(uglyNumbers[multiply2]*2 <= uglyNumbers[nextUglyIndex])
                multiply2++;
            while(uglyNumbers[multiply3]*3 <= uglyNumbers[nextUglyIndex])
                multiply3++;
            while(uglyNumbers[multiply5]*5 <= uglyNumbers[nextUglyIndex])
                multiply5++;

            nextUglyIndex++;
        }

        return uglyNumbers[index-1];
    }

    private static int Min(int num1, int num2, int num3){
        int min = (num1 < num2)? num1:num2;
        min = (min < num3)? min:num3;

        return min;
    }

    public static void main(String[] args){
        System.out.print(getUglyNumberB(1));
    }
}
