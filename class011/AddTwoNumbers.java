package class011;

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int sum = 0, carry = 0, val = 0;
        ListNode res = null, cur = null;
        for (; l1 != null || l2 != null; l1 = l1 == null ? null : l1.next, l2 = l2 == null ? null : l2.next) {
            sum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            carry = sum / 10;
            val = sum % 10;
            if (res == null) {
                res = new ListNode(val);
                cur = res;
            } else {
                res.next = new ListNode(val);
                cur = res.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return res;
    }
}