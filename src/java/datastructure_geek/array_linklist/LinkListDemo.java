package datastructure_geek.array_linklist;

public class LinkListDemo {

    public static void main(String[] args) {
        // 测试合并有序链表
        ListNode node = new ListNode();
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        node.value = 1;
        node.next = node1;
        node1.value = 2;
        node1.next = node2;
        node2.value = 3;
        node2.next = node3;
        node3.value = 4;
        node3.next = node4;
        node4.value = 5;
        node4.next = node5;
        node5.value = 6;
        node.print();
        System.out.println();
        System.out.println(getMiddleNode(node).value);
    }

    /**
     * 单链表反转
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 合并有序链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode MergeSortedLists(ListNode l1,ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode l3 = new ListNode();
        ListNode next = l3;
        while (l1 != null && l2!= null){
            if(l1.value <= l2.value){
                next.next = l1;
                l1 = l1.next;
            }else {
                next.next = l2;
                l2 = l2.next;
            }
            next = next.next;
        }
        if(l1 != null){
            next.next = l1;
        }
        if(l2 != null){
            next.next = l2;
        }
        return l3.next;
    }

    /**
     * 合并有序链表，递归实现
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode MergeSortedLists2(ListNode l1,ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if(l1.value < l2.value){
            l1.next = MergeSortedLists2(l1.next,l2);
            return l1;
        }else{
            l2.next = MergeSortedLists2(l1,l2.next);
            return l2;
        }
    }

    /**
     * 获取链表中间节点
     * @param node
     * @return
     */
    public static ListNode getMiddleNode(ListNode node){
        ListNode l1 = node;
        ListNode l2 = l1.next.next;
        while (l2 != null && l2.next !=null){
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

    private static class ListNode{
        int value;
        ListNode next;

        public void print(){
            System.out.print(value+",");
            ListNode node = next;
            while (node!=null){
                System.out.print(node.value+",");
                node = node.next;
            }
        }
    }
}
