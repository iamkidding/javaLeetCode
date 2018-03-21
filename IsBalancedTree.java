package javaLeetCode;

public class IsBalancedTree {
    public boolean isBalanced(TreeNode root){
        if (root == null) return true;

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        if ((leftDepth < rightDepth && leftDepth == rightDepth - 1)
                || (rightDepth < leftDepth && rightDepth == leftDepth - 1)
                || (rightDepth == leftDepth))
            return true;

        return false;
    }

    private int treeDepth(TreeNode root){
        if (root == null) return 0;

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        return leftDepth > rightDepth ? leftDepth+1 : rightDepth+1;
    }

    public boolean isBalancedB(TreeNode root){
        int depth = 0;
        return isBalancedB(root, depth);
    }

    private boolean isBalancedB(TreeNode root, int depth){
        if (root == null) {
            depth = 0;
            return true;
        }

        int left=0, right=0;
        if (isBalancedB(root.left, left) && isBalancedB(root.right, right)){
            int diff = left - right;
            if (diff <= 1 && diff >= -1){
                depth = 1 + (left > right? left : right);
                return true;
            }
        }

        return false;
    }
}

