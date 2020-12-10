package leetcode1;

public class Solution206 {


    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode listNode = reverseList(n1);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
    
    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;    
        }
        ListNode listNode = reverseList(head.next);
        if(listNode == null){
            return head;
        }else {
            head.next.next = head;
            head.next = null;
        }
        return listNode;
    }
}
