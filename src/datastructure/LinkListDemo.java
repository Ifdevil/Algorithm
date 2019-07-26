package datastructure;

import java.util.Random;
import java.util.Scanner;

/**
 * Java 实现单链表的头插法和尾插法
 */
public class LinkListDemo {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入长度：");
        int l=sc.nextInt();
        System.out.println("打印链表：");
        //调用数组生成方法 传入键盘值l
        Node head=creatLinkList2(l);
        for (int i = 0; i < l; i++) {
            System.out.print(head.data + " ");
            //把当前对象的下一个对象地址传给当前对象
            head = head.next;
        }

    }


    //尾插法
    public static Node creatLinkList(int length){
        Node head,tailer ;
        head = tailer = null;
        for (int i = 0; i < length; i++) {
            Node newnode = new Node();
            newnode.data = i;
            if(head==null){
                head = tailer = newnode;
            }else{
                tailer.next = newnode;
                tailer = newnode;
            }
        }
        return head;
    }
    //头插法
    public static Node creatLinkList2(int length){
        Node head,tailer;
        head = tailer = null;
        for (int i = 0; i < length; i++) {
            Node newnode = new Node();
            newnode.data = i;
            if(head==null){
                head = tailer = newnode;
            }else{
                newnode.next = head;
                head = newnode;
            }
        }
        return head;
    }



}

class Node{
    int data;
    Node next;
}
