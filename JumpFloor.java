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

    public static void main(String[] args){
        System.out.print(jumpFloor(4));
    }
}
