package leetcode1;

public class Solution876 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        ListNode listNode = middleNode(n1);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode middleNode(ListNode head) {
        if(null == head){
            return null;
        }
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        ListNode slow = sentry.next;
        ListNode fast = sentry.next.next;
        while (fast != null){
            if(fast.next == null){
                fast = fast.next;
            }else {
                fast = fast.next.next;
            }
            slow = slow.next;
        }
        return slow;
    }

    static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }
}
