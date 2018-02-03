package javaLeetCode;

public class FindKthToTail {
    public static ListNode findKthToTail(ListNode head, int k){
        if (head == null || k <= 0) return null;

        int length = 1;
        ListNode node = head;
        while (node.next != null){
            length++;
            node = node.next;
        }
        node = head;
        int i = 0;
        if (length-k < 0) return null;
        while (i < length-k){
            node = node.next;
            i++;
        }
        return node;
    }

    public static ListNode findKthToTailB(ListNode head, int k){
        if (head == null || k <= 0) return null;
        //使用两个指针，一个先走，一个后走，两个指针之间相差k-1，这样当fast走到链表，slow正好走到倒数第k个
        ListNode nAhead=head , nBehind=head ;
        for (int i=0; i<k-1; i++){
            if (nAhead.next != null){
                nAhead = nAhead.next;
            }
            else{
                return null;
            }
        }
        while (nAhead.next != null){
            nAhead = nAhead.next;
            nBehind = nBehind.next;
        }
        return nBehind;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.print(findKthToTailB(node1, 1).val);
    }
}
