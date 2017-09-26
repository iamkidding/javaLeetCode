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
//	自己的解法，出错
//	测试用例:[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
//	对应输出应该为:{1,2,5,3,4,6,7}
//	输出为:{1,2,4,3,3,#,4,#,#,#,#,#,4}
    public TreeNode reConstructBinaryTreeSong(int [] pre,int [] in) {
    	if (pre.length <= 0 || in.length <= 0 || pre == null || in == null)
    		return null;
        TreeNode root = new TreeNode(pre[0]);
        int leftKidTreeNum = 0;
        while (leftKidTreeNum <= in.length && in[leftKidTreeNum] != pre[0]) 
        	leftKidTreeNum++;
	    if (leftKidTreeNum > 0){
            int[] leftPre = new int[leftKidTreeNum];
	        int[] leftIn = new int[leftKidTreeNum];
	        for (int i=0; i<leftKidTreeNum; i++) {
	        	leftPre[i] = pre[i+1];
	        	leftIn[i] = in[i];
	        }
	        root.left = reConstructBinaryTreeSong(leftPre, leftIn);
	    }
	    else root.left = null;
	    int rightKidTreeNum = pre.length - leftKidTreeNum - 1;
	    if (rightKidTreeNum > 0) {
            int[] rightPre = new int[rightKidTreeNum];
            int[] rightIn = new int[rightKidTreeNum];
            for (int i=0; i<rightKidTreeNum; i++) {
            	rightPre[i] = pre[i+leftKidTreeNum];
            	rightIn[i] = in[i+leftKidTreeNum];
            }
            root.right = reConstructBinaryTreeSong(rightPre, rightIn);
        }
	    else root.right = null;
        return root;
	}

}
