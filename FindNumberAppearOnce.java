package javaLeetCode;

public class FindNumberAppearOnce {
    public void findNumberAppearOnceB(int[] array, int[] num1, int[] num2){
        if (array == null || array.length < 2) return;

        int resultExclusiveOR = 0;
        for (int i=0; i<array.length; i++){
            resultExclusiveOR ^= array[i]; // 得到数组中两个不同数字的异或结果
        }

        int indexOf1 = findFirstBits1(resultExclusiveOR); // 找到结果中第一个1的位置，即二进制表示两个数第一个不同的位置
        // 关键是将两个不同的数分开，并进行异或运算
        for (int j=0; j<array.length; j++){
            if (isBit1(array[j], indexOf1)) // 对在该位置二进制为1的数使用异或运算，相同的数会分在一起异或
                num1[0] ^= array[j];
            else
                num2[0] ^= array[j];
        }

    }

    private int findFirstBits1(int num){
        int indexBit = 0;
        while (((num & 1) == 0) && indexBit < 32){
            num = num >> 1;
            ++indexBit;
        }

        return indexBit;
    }

    private boolean isBit1(int num, int indexBit){
        num = num >> indexBit;
        return (num & 1) == 1;
    }

    public static void main(String[] args){
        int i = 0;
        int[] a = {1, 2, 5, 1, 2};
        for (int j=0; j<a.length; j++){
            i ^= a[j];
        }
        System.out.print(i);
    }
}
