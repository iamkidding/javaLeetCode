package javaLeetCode;

public class ReconstructBinaryTree {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
        TreeNode(int x) { val = x; }
	}
//	书上标准解法
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length != in.length || pre == null || in == null)
    		return null;
        return reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
	}
	
	private TreeNode reConstructBinaryTree(int[] pre, int ps, int pe, int[] in, int is, int ie) {
		if (ps > pe) return null;
		int index = is;
		while (index <= ie && in[index] != pre[ps]) index++;
		TreeNode node = new TreeNode(pre[ps]);
		node.left = reConstructBinaryTree(pre, ps+1, index+ps-is, in, is, index-1);
		node.right = reConstructBinaryTree(pre, ps+index-is+1, pe, in, index+1, ie);
		return node;
	}
//自己的解法
    public TreeNode reConstructBinaryTreeSong(int [] pre,int [] in) {
    	if (pre.length <= 0 || in.length <= 0 || pre == null || in == null)
    		return null;
        TreeNode root = new TreeNode(pre[0]);
        int leftLen = 0;
        while (leftLen <= in.length && in[leftLen] != pre[0]) 
        	leftLen++;
	    if (leftLen > 0){
            int[] leftPre = new int[leftLen];
	        int[] leftIn = new int[leftLen];
	        for (int i=0; i<leftLen; i++) {
	        	leftPre[i] = pre[i+1];
	        	leftIn[i] = in[i];
	        }
	        root.left = reConstructBinaryTreeSong(leftPre, leftIn);
	    }
	    else root.left = null;
	    int rightLen = pre.length - leftLen - 1;
	    if (rightLen > 0) {
            int[] rightPre = new int[rightLen];
            int[] rightIn = new int[rightLen];
            for (int i=0; i<rightLen; i++) {
            	rightPre[i] = pre[i+leftLen+1];
            	rightIn[i] = in[i+leftLen+1];
            }
            root.right = reConstructBinaryTreeSong(rightPre, rightIn);
        }
	    else root.right = null;
        return root;
	}

}
