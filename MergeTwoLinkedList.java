package javaLeetCode;

public class MergeTwoLinkedList {
    public static ListNode mergeTwoLinkedList(ListNode list1,ListNode list2){
        if ((list1 == null) && (list2 == null)) return null;

        ListNode newFirstNode;
        //其中一个链表为null的时候
        if (list1 == null) {
            newFirstNode = list2;
            return newFirstNode;
        }
        if (list2 == null) {
            newFirstNode = list1;
            return newFirstNode;
        }
        // 确定两个链表头节点小的为新链表首节点
        if (list1.val > list2.val){
            newFirstNode = list2;
            list2 = list2.next;
        }
        else{
            newFirstNode = list1;
            list1 = list1.next;
        }

        ListNode newList = newFirstNode;
        while (list1 != null || list2 != null){
           if (list1 != null && list2 != null){
               if (list1.val > list2.val){
                   newList.next = list2;
                   list2 = list2.next;
               }
               else {
                   newList.next = list1;
                   list1 = list1.next;
               }
               newList = newList.next;
           }

           if (list1 == null) {
               while (list2 != null){
                   newList.next = list2;
                   list2 = list2.next;
                   newList = newList.next;
               }
           }
           if (list2 == null) {
               while (list1 != null){
                   newList.next = list1;
                   list1 = list1.next;
                   newList = newList.next;
               }
           }
        }
        return newFirstNode;
    }

    public ListNode mergeTwoLinkedListB(ListNode list1, ListNode list2){
        if (list1 == null){
            return list2;
        }
        else if(list2 == null){
            return list1;
        }

        ListNode mergedHead;

        if (list1.val < list2.val){
            mergedHead = list1;
            mergedHead.next = mergeTwoLinkedListB(list1.next, list2);
        }
        else{
            mergedHead = list2;
            mergedHead.next = mergeTwoLinkedListB(list1, list2.next);
        }

        return mergedHead;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(6);
        ListNode node9 = new ListNode(8);
        ListNode node10 = new ListNode(15);
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        ListNode m = mergeTwoLinkedList(node1, node6);
        while (m != null){
            System.out.print(m.val);
            m = m.next;
        }
    }
}

