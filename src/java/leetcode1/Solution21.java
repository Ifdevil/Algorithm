package leetcode1;

import java.util.ArrayList;

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
        ListNode newList = new ListNode();
        ListNode head = new ListNode();
        head = newList;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                newList.next = l1;
                newList = newList.next;
                l1 = l1.next;
            }else {
                newList.next = l2;
                newList = newList.next;
                l2 = l2.next;
            }
        }
        
        if (l1 != null){
            newList.next = l1;
        }

        if (l2 != null){
            newList.next = l2;
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
