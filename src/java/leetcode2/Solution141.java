package leetcode2;

public class Solution141 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n2;
        System.out.println(hasCycle(n1));
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode l1 = head;
        ListNode l2 = head.next.next;
        while (l1 != null && l2 != null && l2.next!=null){
            if(l1 == l2){
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
