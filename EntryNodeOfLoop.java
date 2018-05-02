package javaLeetCode;

import java.util.HashMap;

public class EntryNodeOfLoop {
    public ListNode entryNodeOfLoop(ListNode pHead){
        ListNode node = pHead;

//        if (pHead == null) return null;

        HashMap<ListNode, Integer> nodeMap = new HashMap<>();

        nodeMap.put(node, node.val);
        node = node.next;
        while (node != null && !nodeMap.containsKey(node)){
            nodeMap.put(node, node.val);
            node = node.next;
        }

        if (node == null) return null;

        return node;
    }
}
