package leetcode2;

import java.util.HashMap;

public class Solution138 {

    public static void main(String[] args) {
        
    }
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();
    
    public Node copyRandomList(Node head) {
        if(null == head){
            return null;
        }
        if(visitedHash.containsKey(head)){
            return visitedHash.get(head);
        }
        Node copy = new Node(head.val);
        visitedHash.put(head,copy);
        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);
        return copy;
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
    }
}
