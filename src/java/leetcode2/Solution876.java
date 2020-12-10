package leetcode2;

public class Solution876 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        ListNode listNode = middleNode(n1);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode middleNode(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode l1 = head;
        ListNode l2 = head;
        while (l2 != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return l1;
    }
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
