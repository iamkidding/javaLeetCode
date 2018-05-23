package javaLeetCode;

public class CheckPossibillity {
    public boolean checkPossibillty(int[] nums){
        if (nums.length == 0) return false;

        int count=0;
        int N = nums.length;
        int v = nums[N/2];
        int i=0, j=N-1;

        while (true){
            while (nums[i++] != v) {if (nums[i] > v) {count++;System.out.println("in");}}
            while (nums[j--] != v) {if (nums[j] < v) count++;}
            if (count >= 2) return false;
            System.out.println(i);
            System.out.println("out");
            if (j <= i) break;

//  exch(nums, i, j);
        }


        return true;
    }

    private void exch(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args){
        int[] a = {4, 2, 1};
        System.out.println(new CheckPossibillity().checkPossibillty(a));
    }
}
