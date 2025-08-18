package class009;

public class ListReverse {
    public static void main(String[] args) {
        ListNode head = null;
        ListNode cur=null;
        for(int i=0;i<10;i++){
            if(head==null){
                head=new ListNode(i);
                cur=head;
            }else{
                cur.next=new ListNode(i);
                cur=cur.next;
            }
        }
        ListNode reverse=reverseList(head);
        while(reverse!=null){
            System.out.print(reverse.val+" ");
            reverse=reverse.next;
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
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null,cur=null,next=null;
        cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}