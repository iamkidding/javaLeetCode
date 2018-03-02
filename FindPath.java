package javaLeetCode;

import java.util.ArrayList;
public class FindPath {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> singlePath = new ArrayList<>();
        if (root == null) return result;

        int currentSum = 0;
        findPath(root, target, result, currentSum, singlePath);

        return result;
    }
    private void findPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> path,
                          int currentSum, ArrayList<Integer> singlePath){
        currentSum += root.val;
        singlePath.add(root.val);
        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum == target && isLeaf){
            path.add(singlePath);
        }

        if (root.left != null) findPath(root.left, target, path, currentSum, singlePath);
        if (root.right != null) findPath(root.right, target, path, currentSum, singlePath);

        singlePath.remove(singlePath.size()-1);
    }
}
