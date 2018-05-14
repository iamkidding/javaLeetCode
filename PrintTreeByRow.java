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
        while(!temp.isEmpty()){
            TreeNode node = temp.poll();
            ArrayList<Integer> row = new ArrayList<>();
            row.add(node.val);
            if (node.left != null)
                temp.add(node.left);
            if (node.right != null)
                temp.add(node.right);
        }
    }
}
