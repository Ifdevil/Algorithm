/**
 * 两两交换链表中的节点
 */
public class Leetcode24 {

    public static void main(String[] args) {
        Leetcode24 s = new Leetcode24();
        ListNode n1 = new ListNode(1);
        ListNode nn1  = new ListNode(2);
        n1.next = nn1;
        ListNode nn2 = new ListNode(3);
        nn1.next = nn2;
        ListNode nn3 = new ListNode(4);
        nn2.next = nn3;

        ListNode head = s.swapPairs(n1);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
