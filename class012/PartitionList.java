package class012;

public class PartitionList {
    public static void main(String[] args) {
        int n = 1;
        int i = 1;
        while (n < Integer.MAX_VALUE / 3) {
            n *= 3;
            i++;
            System.out.print(n+",");
        }

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode GreaterHead = null, GreaterTail = null;
        ListNode EqualHead = null, EqualTail = null;
        ListNode LessHead = null, LessTail = null;
        while (head != null) {
            if (head.val < x) {
                if (LessHead == null) {
                    LessHead = head;
                    LessTail = head;
                } else {
                    LessTail.next = head;
                    LessTail = LessTail.next;
                }
            } else if (head.val > x) {
                if (GreaterHead == null) {
                    GreaterHead = head;
                    GreaterTail = head;
                } else {
                    GreaterTail.next = head;
                    GreaterTail = GreaterTail.next;
                }
            } else {
                if (EqualHead == null) {
                    EqualHead = head;
                    EqualTail = EqualHead;
                } else {
                    EqualTail.next = head;
                    EqualTail = EqualTail.next;
                }
            }
            head = head.next;
        }

        // 拼接逻辑：按 Less -> Equal -> Greater 顺序连接
        if (GreaterTail != null) {
            GreaterTail.next = null; // 确保大于链表的尾部指向 null
        }

        if (EqualHead != null) {
            EqualTail.next = GreaterHead; // 等于链表尾部连接大于链表头部
        } else {
            EqualHead = GreaterHead; // 若无等于部分，EqualHead 直接指向大于链表头部
        }

        if (LessHead != null) {
            LessTail.next = EqualHead; // 小于链表尾部连接等于/大于链表头部
            return LessHead;
        } else {
            return EqualHead; // 若无小于部分，返回 EqualHead（可能包含等于或大于链表）
        }
    }
}