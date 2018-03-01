package javaLeetCode;

public class VerifySequenceOfBST {
    public boolean verifySquenceOfBST(int[] sequence){
        return verifySquenceOfBST(sequence, sequence.length);
    }
    private boolean verifySquenceOfBST(int[] sequence, int length){
        if (sequence == null || sequence.length == 0) return false;

        int root = sequence[length-1];

        // 找到左子树和右子树的分界点
        int i=0;
        for (; i<length-1; i++){
            if (sequence[i] > root) break;
        }
        // 在右子树是否存在小于根节点的点，如果有，则不是某一二叉搜索树的后序遍历
        // 自己想的是在左子树存在大于根节点的点返回false，不如这样方便
        for (int j=i; j<length-1; j++){
            if (sequence[j] < root) return false;
        }
        // 判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > 0) left = verifySquenceOfBST(sequence, i);
        // 判断右子树
        boolean right = true;
        int [] sequenceRight = new int[length-i-1];
        System.arraycopy(sequence, i, sequenceRight, 0, length-i-1);
        if (i < length - 1) right = verifySquenceOfBST(sequenceRight, length-i-1);

        return (left && right);
    }

    public static void main(String[] args){
        int [] array = {15, 4, 7, 6, 3, 14, 10, 8};
        boolean result = (new VerifySequenceOfBST()).verifySquenceOfBST(array);
        System.out.print(result);
    }
}
