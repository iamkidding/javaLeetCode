package javaLeetCode;
/**
 * Definition for a binary tree node.

 */
public class MergeTrees {
	public static class TreeNode {
	    int val;
		TreeNode left;
		TreeNode right;
	    TreeNode(int x) { val = x; }
		 }
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2){
    	TreeNode mergetree;
    	boolean t1n, t2n;
    	boolean t1c=false, t2c=false;
    	t1n = nodeIsNull(t1);
    	t2n = nodeIsNull(t2);
    	if (!t1n && !t2n){
    	    mergetree = new TreeNode(t1.val+t2.val);
    	}
    	else if ((t1n && !t2n) || (!t1n && t2n)){
            if(!t1n)
    		    mergetree = new TreeNode(t1.val);
            else
            	mergetree = new TreeNode(t2.val);
    	}
    	else return mergetree = null;
    	if (!t1n) t1c = nodeHasChild(t1);
    	if (!t2n) t2c = nodeHasChild(t2);
    	if (t1c || t2c) {
    		if (!(t1.left == null && t2.left == null)){
    		    if (t1.left==null) t1.left = new TreeNode(0);
    		    if (t2.left==null) t2.left = new TreeNode(0);
    		    mergetree.left = mergeTrees(t1.left, t2.left);
    		}
    		if (!(t1.right == null && t2.right == null)){    
    		    if (t1.right==null) t1.right = new TreeNode(0);
    		    if (t1.right==null) t1.right = new TreeNode(0);
    	        mergetree.right = mergeTrees(t1.right, t2.right);
    	    }
    	}
    	return mergetree;
    }
    public static boolean nodeHasChild(TreeNode t){
    	if (t.right != null || t.left != null){
    		return false;
    	}
    	return true;
    }
    public static boolean nodeIsNull(TreeNode t){
    	if (t == null)
    		return true;
    	else
    		return false;
    }
//    Runtime Error Message:
//    	Line 32: java.lang.NullPointerException
//    	Last executed input:
//    	[1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2]
//    	[1,null,1,null,1,null,1,null,1,null,1,2]
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(3);
        TreeNode t13 = new TreeNode(2);
        TreeNode t14 = new TreeNode(5);
        t11.left = t12;
        t12.left = t14;
        t11.right = t13;
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(1);
        TreeNode t23 = new TreeNode(3);
        TreeNode t25 = new TreeNode(4);
        TreeNode t27 = new TreeNode(7);
        t21.left = t22;
        t21.right = t23;
        t22.right = t25;
        t23.right = t27;
        TreeNode t = mergeTrees(t11, t22);
        TreeNode temp = t;
        while(temp != null){
        	System.out.print(t.val);
        	temp = temp.right;
        }
        while(t != null){
        	System.out.print(t.val);
        	temp = temp.right;
        }
	}

}
