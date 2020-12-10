package datastructure;

/**
 * Java 链栈的实现
 */
public class LinkListStackDemo {


    private LinkStackElement head;
    private LinkStackElement top;

    LinkListStackDemo(){
        head = new LinkStackElement();
        top = new LinkStackElement();
        top.data = -1;
        head.data = -1;
        top.next = head;
        head.next = null;
    }

    public LinkStackElement push(LinkStackElement e){
        e.next = top.next;
        top.next = e;
        return e;
    }

    public LinkStackElement pop(){
        if(head == null){
            throw new RuntimeException("empty!");
        }
        LinkStackElement e = top.next;
        top.next = e.next;
        return e;
    }

    public static void main(String[] args) {
        LinkListStackDemo stack = new LinkListStackDemo();
        for (int i = 0; i < 6; i++) {
            LinkStackElement e = new LinkStackElement();
            e.data = i;
            stack.push(e);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(stack.pop().data);
        }
    }

}

class LinkStackElement{
    int data;
    LinkStackElement next;
}
