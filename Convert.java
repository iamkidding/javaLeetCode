package javaLeetCode;

public class Convert {
    public TreeNode convert(TreeNode pRootOfTree){
        TreeNode lastNodeInList = null;
        convert(pRootOfTree, lastNodeInList);

        TreeNode headOfList = lastNodeInList;
        while(headOfList != null && headOfList.left != null){
            headOfList = headOfList.left;
        }

        return headOfList;
    }

    private void convert(TreeNode node, TreeNode lastNodeInList){
        if (node == null) return;

        TreeNode current = node;

        if (current.left != null) convert(current.left, lastNodeInList);

        current.left = lastNodeInList;
        if (lastNodeInList != null) lastNodeInList.right = current;

        lastNodeInList = current;

        if (current.right != null) convert(current.right, lastNodeInList);
    }
}
