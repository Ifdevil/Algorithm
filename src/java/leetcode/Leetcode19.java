package leetcode;

/**
 * 删除链表的倒数第N个节点
 */
public class Leetcode19 {

    public static void main(String[] args) {
        Leetcode19 l = new Leetcode19();
        ListNode a = l.new ListNode(1);
        a.next = l.new ListNode(2);
        a.next.next = l.new ListNode(3);
        System.out.println(removeNthFromEnd(a,3).val);
    }
    // 方法1
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int n1 = 0;
        int count = 0;
        ListNode store = head;
        while (head!=null){
            count++;
            head = head.next;
        }
        if(count<n || n<0){
            return null;
        }
        head = store;
        ListNode pre = null;
        while (head!=null){

            if(n1==count-n){
                if(pre!=null){
                    pre.next = head.next;
                }else{
                    head = head.next;
                    return head;
                }
            }
            pre = head;
            head = head.next;
            n1++;
        }
        return store;

    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
