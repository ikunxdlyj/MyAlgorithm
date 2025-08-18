package class010;

public class MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = null;
        ListNode cur = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (res == null) {
                    res = new ListNode(l1.val);
                    cur = res;
                } else {
                    cur.next = new ListNode(l1.val);
                    cur = cur.next;
                }
                l1 = l1.next;
            } else {
                if (res == null) {
                    res = new ListNode(l2.val);
                    cur = res;
                } else {
                    cur.next = new ListNode(l2.val);
                    cur = cur.next;
                }
                l2 = l2.next;
            }
        }
        cur.next = l1 == null ? l2 : l1;
        return res;
    }
}