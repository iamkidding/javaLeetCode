package javaLeetCode;

public class CloneLinkedList {
    public RandomListNode clone(RandomListNode pHead){
        if (pHead == null) return null;

        RandomListNode cloneHead = new RandomListNode(pHead.label);
        RandomListNode node = cloneHead;

        while (pHead.next != null){
            node.next = new RandomListNode(pHead.next.label);
            if (pHead.random != null) node.random = new RandomListNode(pHead.random.label);
            node = node.next;
            pHead = pHead.next;
        }

        return cloneHead;
    }

    public RandomListNode cloneB(RandomListNode pHead){
        // 分为三步。
        cloneNode(pHead); // 1.在原节点后面插入一个复制的节点
        connectRandom(pHead); // 2.将每个复制节点的random指向前一个节点（即复制原节点的random的next)
        return disconnectNode(pHead); // 将链表分开为原链表和复制链表
    }

    private void cloneNode(RandomListNode pHead){
        // 在每个节点后插入一个复制的此节点
        RandomListNode pNode = pHead;

        while (pNode != null) {
            RandomListNode clonedNode = new RandomListNode(pHead.label);
            clonedNode.next = pHead.next;
            pHead.next = clonedNode;

            pNode = clonedNode.next;
        }
    }

    private void connectRandom(RandomListNode pHead){
        RandomListNode pNode = pHead;

        while (pNode != null){
            RandomListNode clonedNode = pNode.next;
            if (pNode.random != null) clonedNode.random = pNode.random.next;
            pNode = clonedNode.next; // 要跳过复制节点，所以不能为pNode = pNode.next
        }
    }

    private RandomListNode disconnectNode(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode clonedNode = null;
        RandomListNode clonedHead = null;

        if (pNode != null){
            clonedHead = pNode.next;
            clonedNode = clonedHead;
            pNode.next = clonedNode.next; // 原节点.next指向原链表中的原下一个节点，使原链表恢复
            pNode = pNode.next;
        }

        while (pNode != null){
            clonedNode.next = pNode.next;
            clonedNode = pNode.next;
            pNode.next = clonedNode.next;
            pNode = clonedNode.next;
        }

        return clonedHead;
    }
}
