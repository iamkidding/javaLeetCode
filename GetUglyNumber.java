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

    public static void main(String[] args){
        System.out.print(getUglyNumber(4));
    }
}
