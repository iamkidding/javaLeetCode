package javaLeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeByRow {
    ArrayList<ArrayList<Integer>> print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> print = new ArrayList<>();

        if (pRoot == null) return print;

        Queue<TreeNode> temp = new LinkedList<>();

        temp.add(pRoot);
        int start = 0;
        int endCurr = 1, endNext = 0; // endCurr记录当前层有几个节点，endNext记录下一层有几个节点
        TreeNode node;
        while(!temp.isEmpty()){
            ArrayList<Integer> row = new ArrayList<>();
            while (start < endCurr){
                node = temp.poll();
                row.add(node.val);
                if (node.left != null){
                    temp.add(node.left);
                    endNext++;
                }
                if (node.right != null){
                    temp.add(node.right);
                    endNext++;
                }
                start++;
            }
            print.add(row);
            start = 0;
            endCurr = endNext; // 在一个循环进入下一层，节点数变为为下一层
            endNext = 0;  // 下一层节点数重新计算
        }

        return print;
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(11);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        ArrayList<ArrayList<Integer>> p = new PrintTreeByRow().print(n1);
        System.out.print(p);
    }
}
