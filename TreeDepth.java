package javaLeetCode;

public class TreeDepth {
    public int treeDepth(TreeNode root){
        if (root == null) return 0;

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        return (leftDepth > rightDepth)? leftDepth+1:rightDepth+1;
    }

}
