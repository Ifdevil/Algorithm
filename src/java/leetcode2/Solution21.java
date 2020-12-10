package leetcode2;

public class Solution21 {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l21 = new ListNode(2);
        ListNode l31 = new ListNode(5);
        l11.next = l21;
        l21.next = l31;

        ListNode l12 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l32 = new ListNode(6);
        l12.next = l22;
        l22.next = l32;

        ListNode listNode = mergeTwoLists(l11, l12);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode copy = head;
        while (l1 != null || l2 != null){
            if(l1 == null){
                copy.next = l2;
                break;
            }else if(l2 == null){
                copy.next = l1;
                break;
            }else {
                if(l1.val > l2.val){
                    copy.next = l2;
                    l2 = l2.next;
                }else {
                    copy.next = l1;
                    l1 = l1.next;
                }
            }
            copy = copy.next;
        }
        return head.next;
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
