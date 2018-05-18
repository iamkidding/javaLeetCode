package javaLeetCode;

public class IsPalindrome {
    public static boolean isPalindrome(int x){
        if (x < 0) return false;
        // 比较翻转后和原数是否相同，相同则是回文数
        long reversedX = 0;
        int oldX = x;
        int temp;
        while (x > 0){
            temp = x % 10;
            reversedX = reversedX * 10 + temp;
            x = x / 10;
        }

        return oldX == reversedX;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome(0));
    }
}
