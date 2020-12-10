package leetcode1;

public class Solution19 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode listNode = removeNthFromEnd2(n1, 2);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //取长度
        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        int count = 0;
        while (head!=null){
            count++;
            head = head.next;
        }
        int r = count - n;
        head = sentry;
        while (r > 0){
            r--;
            head = head.next;
        }
        head.next = head.next.next;
        return sentry.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        int count = 0;
        ListNode l1 = new ListNode(-1);
        l1 = sentry;
        while (head != null){
            count++;
            head = head.next;
            if(count > n){
                l1 = l1.next;
            }
        }
        l1.next = l1.next.next;
        return sentry.next;
    }
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
