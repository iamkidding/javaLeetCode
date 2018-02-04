package javaLeetCode;
import java.util.Stack;

public class ReverseList {
    public static ListNode reverseList(ListNode head){
        if (head == null) return null;

        Stack<ListNode> revereList = new Stack<>();
        ListNode node = head;

        while (node != null){
            revereList.push(node);
            node = node.next;
        }
        ListNode reverseNodeHead = revereList.peek();
        while (!revereList.isEmpty()) {
            node = revereList.pop();
            if (!revereList.isEmpty()) {
                node.next = revereList.peek();
            }
            else{
                node.next = null;
            }
        }
        return reverseNodeHead;
    }
    public static ListNode reverseListB(ListNode head){
        if (head == null) return null;

        ListNode preNode = null;
        ListNode reversedNode = null;
        ListNode node = head;
        while(node != null){
            ListNode nodeNext = node.next;

            if (nodeNext == null) reversedNode = node;

            node.next = preNode;

            preNode = node;
            node = nodeNext;
        }
        return reversedNode;
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
        ListNode node = reverseListB(node1);
        while (node != null){
            System.out.print(node.val);
            node = node.next;
        }
    }
}
