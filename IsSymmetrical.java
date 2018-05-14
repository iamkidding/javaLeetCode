package javaLeetCode;

public class IsSymmetrical {
    public boolean isSymmetrical(TreeNode pRoot){
        if (pRoot == null) return true;

        boolean isSymmetrical = false;
        TreeNode rightSubTree = pRoot.right;
        TreeNode leftSubTree = pRoot.left;

        if (rightSubTree == null && leftSubTree == null) return true;

        isSymmetrical = isSymmetricalCore(leftSubTree, rightSubTree, isSymmetrical);

        return isSymmetrical;
    }

    private boolean isSymmetricalCore(TreeNode leftSubTree, TreeNode rightSubTree, boolean isSym){
        if (leftSubTree.val == rightSubTree.val) isSym =  true;
        else isSym = false;
        if (leftSubTree.left != null && rightSubTree.right != null && isSym)
            isSym = isSymmetricalCore(leftSubTree.left, rightSubTree.right, isSym);
        else if (leftSubTree.left == null ^ rightSubTree.right == null) isSym = false;
        if (leftSubTree.right != null && rightSubTree.left != null && isSym)
            isSym = isSymmetricalCore(leftSubTree.right, rightSubTree.left, isSym);
        else if (leftSubTree.right == null ^ rightSubTree.left == null) isSym = false;
        return isSym;
    }

    public boolean isSymmetricalB(TreeNode pRoot){
        return isSymmetricalB(pRoot, pRoot);
    }

    private boolean isSymmetricalB(TreeNode pRoot1, TreeNode pRoot2){
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }

        if (pRoot1 == null || pRoot2 == null){
            return false;
        }

        if (pRoot1.val != pRoot2.val){
            return false;
        }

        return isSymmetricalB(pRoot1.left, pRoot2.right) && isSymmetricalB(pRoot1.right, pRoot2.left);
    }
}
