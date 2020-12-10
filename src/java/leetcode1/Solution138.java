package leetcode1;

import java.util.HashMap;

public class Solution138 {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node h1 = new Node(2);
        head.next = h1;
        head.random = h1;
        h1.random = h1;
        
        Node node = copyRandomList(head);
        while (node != null){
            System.out.println(node);
            node = node.next;
        }
        
    }
    static HashMap<Node, Node> map = new HashMap<Node, Node>();
    public static Node copyRandomList(Node head) {
        if(map.containsKey(head)){
            return map.get(head);
        }
        if (head != null){
            Node copy = new Node(head.val);
            map.put(head,copy);
            if(head.random != null){
                if(head.random == head){
                    copy.random = copy;
                }else {
                    copy.random = copyRandomList(head.random);
                }
            }
            if(head.next != null){
                copy.next = copyRandomList(head.next);
            }
            return copy;
        }
        return null;
    }

    public static Node copyRandomList1(Node head) {

        if (head == null) {
            return null;
        }

        // Creating a new weaved list of original and copied nodes.
        Node ptr = head;
        while (ptr != null) {

            // Cloned node
            Node newNode = new Node(ptr.val);

            // Inserting the cloned node just next to the original node.
            // If A->B->C is the original linked list,
            // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        // Now link the random pointers of the new nodes created.
        // Iterate the newly created list and use the original nodes' random pointers,
        // to assign references to random pointers for cloned nodes.
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // Unweave the linked list to get back the original linked list and the cloned list.
        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        Node ptr_old_list = head; // A->B->C
        Node ptr_new_list = head.next; // A'->B'->C'
        Node head_old = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
