package leetcode1;

public class Solution61 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(2);
//        ListNode n4 = new ListNode(7);
//        ListNode n5 = new ListNode(9);
        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
        ListNode listNode = rotateRight(n1, 5);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head==null || head.next==null){
            return head;
        }
        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }
        k = k%count;
        if(k ==0 || count == k)return sentry.next;
        int r = count - k > 0 ? count-k:count-(k-count);
        ListNode l1 = sentry;
        while (r > 0){
            r--;
            l1 = l1.next;
        }
        ListNode l2 = l1.next;
        ListNode l3 = l2;
        l1.next = null;
        while (l2.next != null){
            l2 = l2.next;
        }
        l2.next = sentry.next;
        return l3;
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if(k == 0 || head==null || head.next==null){
            return head;
        }
        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        int count = 1;
        while (head.next != null){
            count++;
            head = head.next;
        }
        head.next = sentry.next;
        ListNode new_tail = sentry.next;
        for (int i = 0; i < count - k % count - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;
        new_tail.next = null;
        return new_head;
    }
    
    

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
