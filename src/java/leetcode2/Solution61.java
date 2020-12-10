package leetcode2;

public class Solution61 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode listNode = rotateRight(n1, 5);
        while (listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(null == head || k == 0 || head.next == null){
            return head;
        }
        // 哨兵节点
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = head;
        int count = 0;
        // 计算总长度
        while (cur != null){
            count++;
            cur = cur.next;
        }
        cur = head;
        k = k % count;
        if( k == 0) return pre.next;
        while (cur != null){
            if(count == k+1){
                break;
            }else {
                cur = cur.next;
            }
            count--;
        }
        ListNode next = cur.next;
        ListNode copy = next;
        cur.next = null;
        while (next.next != null){
            next = next.next;
        }
        next.next = pre.next;
        pre.next = copy;
        return pre.next;
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
