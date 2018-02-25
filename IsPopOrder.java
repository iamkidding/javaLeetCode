package javaLeetCode;

public class IsPopOrder {
    public boolean isPopOrder(int[] pushA, int[] popA){
//        对题目理解错误，以为是将栈压好之后弹出，但实际是边压边弹。
//        另外，按之前理解，以为栈可以同时弹出多个，但其实不可以
        if (pushA.length <= 0 || popA.length <= 0 || pushA.length != popA.length)
            return false;

        int fromHead=0, fromTail=pushA.length-1; // 两个指针，一个对原数组从头往后，另一个对弹出数组从后往前
        while (fromHead < pushA.length){
            // 当一个一个弹出时
            if (pushA[fromHead] == popA[fromTail]){
                fromHead++;
                fromTail--;
            }
            else { // 出现同时弹出的情况时
                int originFromHead = fromHead;
                int popTogether = 1; // 以为可以同时弹出╮(╯﹏╰）╭
                while (pushA[fromHead] != popA[fromTail]){
                    fromHead++;
                    popTogether++;
                }
                // 原数组指针移动到同时弹出的最后一个，然后两个指针同时--，进行比较
                while (fromHead > originFromHead){
                    fromHead--;
                    fromTail--;
                    if (pushA[fromHead] != popA[fromTail])
                        return false;
                }
                fromHead += popTogether;
                fromTail--;
            }
        }
        return true;
    }

    public boolean isPopOrderB(int[] pushA, int[] popA){
        return false;
    }

    public static void main(String[] args){
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        IsPopOrder is = new IsPopOrder();
        System.out.print(is.isPopOrder(push, pop));
    }
}
