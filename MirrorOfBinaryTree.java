package javaLeetCode;

public class MirrorOfBinaryTree {
    public static void mirror(TreeNode root){
        if (root == null) return;
        if (root.right == null && root.left == null) return;//递归返回条件

        TreeNode cache;//交换节点
        cache = root.right;
        root.right = root.left;
        root.left = cache;

        if (root.left != null) mirror(root.left);
        if (root.right != null) mirror(root.right);
    }

}
