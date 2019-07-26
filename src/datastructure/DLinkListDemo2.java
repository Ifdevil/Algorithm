package datastructure;

import java.util.Scanner;

/**
 * Java 实现双链表
 */
public class DLinkListDemo2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入长度：");
        int l=sc.nextInt();
        System.out.println("打印链表：");
        //调用数组生成方法 传入键盘值l
        Dnode head=createDLinkList1(l);
        for (int i = 0; i < l; i++) {
            System.out.print(head.data + " ");
            //把当前对象的下一个对象地址传给当前对象
            head = head.next;
        }

    }
    //尾插法
    private static Dnode createDLinkList1(int length){
        Dnode head,tailer;
        head = tailer = null;
        Dnode newnode = null;
        for (int i = 0; i < length; i++) {
            newnode = new Dnode();
            newnode.data = i;
            if(head == null){
                head = tailer = newnode;
            }else{
                tailer.next = newnode;
                newnode.pre = tailer;
                tailer = newnode;
            }
        }
        return head;
    }

}
class Dnode{
    int data;
    Dnode pre;
    Dnode next;
}
