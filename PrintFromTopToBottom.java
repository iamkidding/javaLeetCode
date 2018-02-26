package javaLeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom {
    public static ArrayList<Integer> printFromTopToBottomB(TreeNode root){
        ArrayList<Integer> print = new ArrayList<>();
        if (root == null) return print;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            print.add(node.val);

            if (node.left != null) nodeQueue.offer(node.left);
            if (node.right != null) nodeQueue.offer(node.right);
        }

        return print;
    }

    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(12);
        TreeNode c = new TreeNode(13);
        TreeNode d = new TreeNode(14);
        TreeNode e = new TreeNode(15);
        TreeNode f = new TreeNode(16);
        TreeNode g = new TreeNode(17);
        TreeNode h = new TreeNode(18);
        TreeNode i = new TreeNode(19);
        TreeNode j = new TreeNode(20);
        TreeNode k = new TreeNode(21);
        TreeNode l = new TreeNode(31);
        TreeNode m = new TreeNode(41);
        TreeNode n = new TreeNode(51);
        TreeNode o = new TreeNode(61);

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        d.left = h; d.right = i;
        e.left = j; e.right = k;
        f.left = l; f.right = m;
        g.left = n; g.right = o;

        ArrayList<Integer> p = printFromTopToBottomB(a);
        System.out.print(p);

    }
}
