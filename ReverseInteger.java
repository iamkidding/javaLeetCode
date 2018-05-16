package javaLeetCode;

public class ReverseInteger {
    public static int reverse(int x){
        long reInt = 0;
        int mod;
        while (x != 0){
            mod = x % 10;
            x = x / 10;
            reInt = mod + reInt * 10;
            if (reInt > Integer.MAX_VALUE || reInt < Integer.MIN_VALUE)
                return 0; // 如果超出int的表示范围就返回0
        }
        return (int)reInt;
    }

    public static void main(String[] args){
        System.out.println(reverse(1534236469));
    }
}
