package leetcode2;

public class Solution19 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
//        ListNode n2 = new ListNode(3);
//        ListNode n3 = new ListNode(5);
//        ListNode n4 = new ListNode(7);
//        ListNode n5 = new ListNode(9);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
        ListNode listNode = removeNthFromEnd(n1, 1);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int a = 0;
        ListNode result = new ListNode();
        result.next = head;
        ListNode temp = result;
        while (head != null){
            a++;
            head = head.next;
            if(a > n){
                temp = temp.next;
            }
        }
        temp.next = temp.next.next;
        return result.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
