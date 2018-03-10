package javaLeetCode;

public class Traversal {
    public static void inOrderTraversal(TreeNode root){
        if (root == null) return;

//        TreeNode pCurrent = root;

        if (root.left != null) inOrderTraversal(root.left);

        System.out.print(root.val);

        if (root.right != null) inOrderTraversal(root.right);
    }

    public static void preOrderTraversal(TreeNode root){
        if (root == null) return;
        else System.out.print(root.val);

        if (root.left != null) preOrderTraversal(root.left);
        if (root.right != null) preOrderTraversal(root.right);
    }

    public static void postOrderTraversal(TreeNode root){
        if (root == null) return;

        if (root.left != null) postOrderTraversal(root.left);
        if (root.right != null) postOrderTraversal(root.right);

        System.out.print(root.val);
    }

    public static void main(String[] args){
        TreeNode n6 = new TreeNode(6);
        TreeNode n1 = new TreeNode(1);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n10 = new TreeNode(10);

        n6.left = n3;
        n6.right = n8;
        n3.left = n1;
        n3.right = n5;
        n8.left = n7;
        n8.right = n10;

        postOrderTraversal(n6);
    }
}
