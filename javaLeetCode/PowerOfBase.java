public class PowerOfBase {
    public static double power(double base, int exponent) {
        if (base - 0.0 < 0.00000000001) return 0.0;   // Double用equals比较，注意0.0和-0.0的情况
        if (base - 0.0 > 0.00000000001 && exponent == 0) return 1.0; // double用两个数相减绝对值小于某个范围
        double answer;
        if (exponent > 0){
            answer = powerUnsignedE(base, exponent);
        }else
            answer = 1/powerUnsignedE(base, -exponent);

        return answer;
    }

    private static double powerUnsignedE(double base, int exponent){
        double answer = 1.0;
        while (exponent > 0){
            answer *= base;
            exponent--;
        }

        return answer;
    }
    // 书上的方法，使用递归
    // a^n = a^n/2 * a^n/2 n为偶数
    // a^n = a^(n-1)/2 * a^(n-1)/2 * a n为奇数
    private static double powerUnsignedE2(double base, int exponent){
        if (exponent == 1) return base; //递归的底层条件
        if (exponent == 0) return 1;

        double answer = powerUnsignedE2(base, exponent >> 1);
        answer *= answer;
        if ((exponent & 0x1) == 1) //与16进制的1做位运算，判断是否为奇数
            answer *= base;

        return answer;
    }

    public static void main(String[] args){
        System.out.println(power(4.0, 2));
        System.out.println(power(0.0, 2));
        System.out.println(power(4.0, 0));
        System.out.println(power(-4.0, 3));
        System.out.println(power(2.0, -3));
    }
}
