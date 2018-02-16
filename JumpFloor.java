package javaLeetCode;

public class JumpFloor {
    public static int jumpFloor(int target){
        if (target <= 0) return 0;

        int count;
        if (target == 1) count = 1;
        else if (target == 2) count = 2;
        else count = jumpFloor(target - 1) + jumpFloor(target - 2);

        return count;
    }

    public static int anotherJumpFloor(int target){
        if (target <= 0) return 0;

        int f1 = 1, f2 = 2, n = 3;
        int fn = 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        while (n <= target){
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
            n++;
        }

        return fn;
    }

    public static void main(String[] args){
        System.out.print(jumpFloor(9));
        System.out.print(jumpFloor(9));
    }
}
