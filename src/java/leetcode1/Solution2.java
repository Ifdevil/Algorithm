package leetcode1;

public class Solution2 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(4);
        n4.next = n5;
        n5.next = n6;

        ListNode listNode = addTwoNumbers(n1, n4);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode l3 = new ListNode(0);
        ListNode result = l3;
        ListNode next;
        while (l1!=null || l2!=null){
            int a = l1 != null?l1.val:0;
            int b = l2 != null?l2.val:0;
            c = (c+a+b)/10;
            next = new ListNode( (c+a+b)%10);
            l3.next = next;
            l3 = next;
            if(l1 !=null)l1 = l1.next;
            if(l2 !=null)l2 = l2.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
