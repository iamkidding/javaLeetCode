package javaLeetCode;

public class HasCircle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode pSlow = head.next;
        if (pSlow == null) return false;
        ListNode pFast = pSlow.next;

        while (pSlow != null && pFast != null){
            pSlow = pSlow.next;

            pFast = pFast.next;
            if (pFast != null) pFast = pFast.next;

            if (pFast == pSlow) return true;
        }

        return false;
    }
}
