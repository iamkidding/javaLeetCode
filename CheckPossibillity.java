package javaLeetCode;

public class CheckPossibillity {
    public boolean checkPossibillty(int[] nums){
        if (nums.length == 0) return false;

        int count=0;
        int N = nums.length;
        int v = nums[N/2];
        int i=0, j=N-1;

        while (i <= j) {
            if (nums[i] > v) count++;
            i++;
            if (nums[j] < v) count++;
            j--;
            if (count >= 2) return false;
        }
        return true;
    }

    public static void main(String[] args){
        int[] a = {1, 1, 1};
        System.out.println(new CheckPossibillity().checkPossibillty(a));
    }
}
