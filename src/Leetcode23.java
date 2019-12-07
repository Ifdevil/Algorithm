import java.util.PriorityQueue;

/**
 * 合并K个排序链表
 */
public class Leetcode23 {

    public static void main(String[] args) {
        Leetcode23 s = new Leetcode23();
        ListNode n1 = new ListNode(1);
//        ListNode nn1  = new ListNode(2);
//        n1.next = nn1;
//        ListNode nn2 = new ListNode(3);
//        nn1.next = nn2;
//
//        ListNode n2 = new ListNode(1);
//        ListNode nn21  = new ListNode(2);
//        n2.next = nn21;
//        ListNode nn22 = new ListNode(3);
//        nn21.next = nn22;
//
//        ListNode n3 = new ListNode(1);
//        ListNode nn31  = new ListNode(2);
//        n3.next = nn31;
//        ListNode nn32 = new ListNode(3);
//        nn31.next = nn32;
        ListNode[] lists = {n1};
        ListNode head = s.mergeKLists(lists);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 暴力
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        int size = lists.length;
        PriorityQueue queue = new PriorityQueue();
        ListNode node = null;
        for (int i = 0; i < size; i++) {
            node = lists[i];
            while (node!=null){
                queue.add(node.val);
                if(node.next!=null){
                    node = node.next;
                }else {
                    node = null;
                }
            }
        }
        ListNode head = null;
        ListNode listNode = null;
        while (!queue.isEmpty()){
            if(listNode==null){
                listNode = new ListNode((int)queue.poll());
                head = listNode;
            }else{
                listNode.next = new ListNode((int)queue.poll());
                listNode = listNode.next;
            }

        }
        return head;
    }

    /**
     * 两两比较
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists){
        // 两两合并
        ListNode head = null;
        return head;
    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}



