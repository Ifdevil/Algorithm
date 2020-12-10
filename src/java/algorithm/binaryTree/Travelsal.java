package algorithm.binaryTree;

public class Travelsal {

    public static void main(String[] args) {

    }

    /**
     * 前序遍历
     * @param node
     */
    public void preOrder(Node node){
        if(node != null){
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     * @param node
     */
    public void inOrder(Node node){
        if(node != null){
            preOrder(node.left);
            System.out.println(node.data);
            preOrder(node.right);
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    public void postOrder(Node node){
        if(node != null){
            preOrder(node.left);
            preOrder(node.right);
            System.out.println(node.data);
        }
    }

    static class Node{
        Object data;
        Node left;
        Node right;
    }
}
