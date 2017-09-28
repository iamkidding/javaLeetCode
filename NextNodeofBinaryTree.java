package javaLeetCode;

public class NextNodeofBinaryTree {
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	public TreeLinkNode GetNextSong(TreeLinkNode pNode) {
        TreeLinkNode pNext = null;
	    if (pNode == null) return pNext;
	    if (pNode.right != null) {
	    	pNext = pNode.right;
	    	while(pNext.left != null) pNext = pNext.left;
	    }
	    else if (pNode.next != null) {
	    	while (pNode.next != null && pNode != pNode.next.left){
                pNode = pNode.next;
            }
	    	pNext = pNode.next; 
	    }
	    return pNext;
	}
	public TreeLinkNode GetNext(TreeLinkNode pNode){
		if (pNode == null) return null;
        TreeLinkNode pNext = null;
        if (pNode.right != null){
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null)
                pRight = pRight.left;
            pNext = pRight;
        }
        else if (pNode.next != null){
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode pParent = pNode.next;
            while (pParent != null && pCurrent == pParent.right){
                pCurrent = pParent;
                pParent = pParent.next;
            }
            pNext = pParent;
        }
	    return pNext;
	}
}
