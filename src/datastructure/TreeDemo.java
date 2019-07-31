package datastructure;

import java.util.Stack;

/**
 * 二叉树的遍历
 */
public class TreeDemo {


    //中序遍历--递归
    public void infixOrder(BiTreeNode current){
        if(current != null){
            infixOrder(current.leftChild);
            System.out.println(current.data+" ");
            infixOrder(current.rightChild);

        }
    }

    //前序遍历--递归
    public void preOrder(BiTreeNode current){
        if(current != null){
            System.out.print(current.data+" ");
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }
    }

    //后序遍历--递归
    public void postOrder(BiTreeNode current){
        if(current != null){
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.print(current.data+" ");
        }
    }

    //非递归中序遍历
    public void infixOrder2(BiTreeNode current){
        Stack t = new Stack();
        while (current!=null || !t.isEmpty()){
            while (current!=null){
                t.push(current);
                current = current.leftChild;
            }
            current = (BiTreeNode) t.pop();
            System.out.println(current.data);
            current = current.rightChild;
        }
    }
    //非递归先序遍历
    public void preOrder2(BiTreeNode current){
        Stack t = new Stack();
        while (current!=null || !t.isEmpty()){
            while (current!=null){
                System.out.println(current.data);
                t.push(current);
                current = current.leftChild;
            }
            current = (BiTreeNode) t.pop();
            current = current.rightChild;
        }
    }
    //非递归后序遍历
    public void postOrder2(BiTreeNode current){
        Stack t = new Stack();
        BiTreeNode r = null;
        while (current!=null || !t.isEmpty()){
            while (current!=null){
                t.push(current);
                current = current.leftChild;
            }
            current = (BiTreeNode) t.peek();
            if(current.rightChild!=null && r!=current.rightChild){
                current = current.rightChild;
            }else{
                current = (BiTreeNode) t.pop();
                System.out.println(current.data);
                r = current;
                current = null;
            }

        }
    }
}

class BiTreeNode{
    int data;
    BiTreeNode leftChild;
    BiTreeNode rightChild;
}
