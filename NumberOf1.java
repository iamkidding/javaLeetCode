package javaLeetCode;

public class NumberOf1{
//    自己的解法；
    public int NumberOf1_mine(int n){
        int count = 0;
        int cmp = 0;
        while (cmp < 32){ // 因为是int，所以比较32次即可，在比较32次后停止；
            cmp++;
            if ((n & 1) > 0) count++;
            n = n >> 1;
        }
        return count;
    }

//  剑指offer上的容易陷入死循环的方法，输入负数会陷入死循环
    public int NumberOf1_deadloop(int n){
        int count = 0;
        while (n > 0){ //书上用n作为循环条件，但Java不能用不等于0的int当做true使用
            if ((n & 1) > 0) count++;
            n = n >> 1;
        }
        return count;
    }
//  常规解法，n不移位，而是将比较的flag左移，比如n与0001比较，再与0010比较，也需比较32次
    public int NumberOf1_regular(int n){
        int count = 0;
        int flag = 1;
        while (flag > 0){
            if ((n & flag) > 0) count++;
            flag = flag << 1;
        }
        return count;
    }
//  最优解：把一个整数减去1，然后和原来的数比较，这样这个数最右边的1变为0，有几个1就能做几次这种比较
//  比如，1100.
//  1100 - 1 = 1011. 1100 & 1011 = 1000.
//  1000 - 1 = 0111. 1000 & 0111 = 0000.所以比较了2次，n变为0
    public int NumberOf1_surprise(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args){
    }
}
