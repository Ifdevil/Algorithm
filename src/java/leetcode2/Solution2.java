package leetcode2;

public class Solution2 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n7 = new ListNode(9);
        ListNode n8 = new ListNode(9);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(9);
        ListNode n11 = new ListNode(9);
        n4.next = n5;
        n5.next = n6;
        n6.next = n11;

        ListNode listNode = addTwoNumbers(n1, n4);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode result = head;
        int a = 0;
        while (l1 != null || l2 != null){
            int b = l1 != null ? l1.val : 0;
            int c = l2 != null ? l2.val : 0;
            int d = (b + c + a)%10;
            a = (b + c + a)/10;
            result.next = new ListNode(d);
            result = result.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(a > 0){
            result.next = new ListNode(a);
        }
        return head.next;
    }
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
