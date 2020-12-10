package leetcode1;

public class Solution141 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = null;
//        n3.next = n2;
        System.out.println(hasCycle(n1));
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode step1 = head;
        ListNode step2 = head;
        while (step1 != null && step2 != null && step2.next != null){
            step1 = step1.next;
            step2 = step2.next.next;
            if(step1 == step2){
                return true;
            }
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
