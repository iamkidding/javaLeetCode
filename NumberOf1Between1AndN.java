package javaLeetCode;

public class NumberOf1Between1AndN {
    public static int numberOf1Between1AndN(int n){
        if (n <= 0) return 0;

        int count = 0;
        for (int i=0; i <= n; i++){
            int j = i;
            while (j > 0){
                if (j % 10 == 1){
                    count++;
                }
                j = j / 10;
            }
        }

        return count;
    }

    public static void main(String[] args){
        System.out.print(numberOf1Between1AndN(11));
    }
}
