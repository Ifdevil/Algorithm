package leetcode1;

import leetcode.Solution;

public class Solution23 {


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(6);
        ListNode n9 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;
        n7.next = n8;
        n8.next = n9;
        ListNode[] lists = {n1,n4,n7};
        Solution23 s = new Solution23();
        ListNode listNode = s.mergeKLists(lists);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(null == lists || lists.length == 0){
            return null;
        }
        ListNode result = lists[0];
        for (int j = 1;j<lists.length;j++){
            result = merge(result,lists[j]);
        }
        return result;
    }
    
    public ListNode merge(ListNode node1,ListNode node2){
        ListNode result = new ListNode();
        ListNode head = result;
        while (node1 != null && node2 != null){
            if(node1.val >= node2.val){
                result.next = node2;
                node2 = node2.next;
            }else {
                result.next = node1;
                node1 = node1.next;
            }
            result = result.next;
        }
        if(node1 != null){
            result.next = node1;
        }
        if(node2 != null){
            result.next = node2;
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
