package leetcode2;

import java.util.List;

public class Solution25 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode listNode = reverseKGroup(n1, 2);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        
        while (head != null){
            ListNode tail = pre;
            for (int i = 0;i<k;i++){
                tail = tail.next;
                if(tail == null){
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reserve = reserve(head, tail);
            head = reserve[0];
            tail = reserve[1];
            tail.next = nex;
            pre.next = head;
            head = tail.next;
            pre = tail;
        }
        return hair.next;
    }
    
    public static ListNode[] reserve(ListNode head,ListNode tail){
        ListNode pre = tail.next;
        ListNode cur = head;
        while (cur != tail.next){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail,head};
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
