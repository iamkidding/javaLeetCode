package javaLeetCode;

public class IsSubtree {
    public static boolean isSubtree(TreeNode rootA, TreeNode rootB){
        if (rootA == null || rootB == null) return false;

        boolean isSubtree = false;
        TreeNode node = searchNode(rootA, rootB); //在A中找到val==B.val的节点
        if (node == null) return false;
        isSubtree = isSameTree(node, rootB);

        return isSubtree;
    }

    private static boolean isSameTree(TreeNode A, TreeNode B){
//        if (A.left == null && B.left == null && A.right == null && B.right == null
//                && A.val == B.val) return true;
        if (A == null || B == null) return true;
        else if ((A == null && B != null) ||
                 (A != null && B == null) ||
                 (A.val != B.val) ||
                !isSameTree(A.left, B.left)||
                !isSameTree(A.right, B.right)){
            return false;
        }
        else return true;
    }

    private static TreeNode searchNode(TreeNode node, TreeNode target){
        if (node.val == target.val) {
            return node;
        }
        else {
            TreeNode sNode = null;
            if (node.left != null)
                sNode = searchNode(node.left, target);
            if (sNode == null && node.right != null)
                sNode = searchNode(node.right, target);
            return sNode;
        }
    }

    public boolean hasSubtree(TreeNode rootA, TreeNode rootB){
        boolean result = false;

        if (rootA != null && rootB != null){
            if (rootA.val == rootB.val)
                result = doesTree1HasTree2(rootA, rootB);
            if (!result)
                result = hasSubtree(rootA.left, rootB);
            if (!result)
                result = hasSubtree(rootA.right, rootB);
        }

        return result;
    }

    private boolean doesTree1HasTree2(TreeNode A, TreeNode B){
        if (B == null) return true;
        if (A == null) return false;

        if (A.val != B.val) return false;

        return doesTree1HasTree2(A.left, B.left) && doesTree1HasTree2(A.right, B.right);
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        boolean result = isSubtree(n1, n2);
        System.out.print(result);
    }
}
