package javaLeetCode;
import javaLeetCode.ListNode;

public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode phead){
        if (phead == null) return null;

        int cmp = phead.val; //保存节点的val用于比较
        ListNode node = phead;  //遍历链表
        ListNode preNode = node;  //当前节点的前一个节点
        boolean isFirst = true; //用来判断并保存头节点
        while (node.next != null) {
            if (node.next.val == cmp) {
                while (node.next.val == cmp){ //将当前节点之后的重复节点跳过，即将当前节点next指到第一个不重复的节点
                    node.next = node.next.next;
                    if (node.next == null) break; //当重复节点在最后时，node.next为null，在判断循环时不存在val值
                }
                preNode.next = node.next; //进入这个判断说明当前Node.val与后面的重复，所以将前一个节点的next直到当前Node的next
                node = node.next;
                if (isFirst) phead = node;
            }
            else { //不重复的情况
                preNode = node;
                node = node.next;
                isFirst = false;
            }
            if (node == null) break; //避免while循环条件出现NullPointerException
            cmp = node.val;
        }
        return phead;
    }

}
