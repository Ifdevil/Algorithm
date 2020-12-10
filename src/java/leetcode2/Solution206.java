package leetcode2;

public class Solution206 {

    public static void main(String[] args) {
        
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null){
           ListNode next = head.next;
           head.next = pre;
           pre = head;
           head = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode pre = new ListNode(-1);
        while (head != null){
            ListNode next = head.next;
            head.next = pre.next;
            pre.next = head;
            head = next;
        }
        return pre.next;
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}
