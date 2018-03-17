package javaLeetCode;

import java.util.Hashtable;

public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode phead1, ListNode phead2){
        if (phead1 == null && phead2 == null) return null;

        Hashtable<Integer, Integer> hash = new Hashtable<>();

        ListNode node = phead1;
        int i = 0; // 键
        while (node != null){
            hash.put(i, node.val);
            i++;
            node = node.next;
        }

        node = phead2;
        while (node != null){
            if (hash.contains(node.val)) return node;
            node = node.next;
        }

        return null;
    }

    public ListNode findFirstCommonNodeB(ListNode pHead1, ListNode pHead2){
        int len1 = getListLength(pHead1);
        int len2 = getListLength(pHead2);
        int lenDif = len1 - len2;

        ListNode longListNode = pHead1;
        ListNode shortListNode = pHead2;
        if (len2 > len1){
            longListNode = pHead2;
            shortListNode = pHead1;
            lenDif = len2 - len1;
        }

        for (int i=0; i<lenDif; i++){
            longListNode = longListNode.next;
        }

        while (longListNode !=null && shortListNode != null && longListNode != shortListNode){
            longListNode = longListNode.next;
            shortListNode = shortListNode.next;
        }

        ListNode commonNode = longListNode;

        return commonNode;
    }

    private int getListLength(ListNode head){
        int len = 0;
        ListNode node = head;

        while (node != null){
            len++;
            node = node.next;
        }

        return len;
    }
}
