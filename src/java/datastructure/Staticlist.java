package datastructure;

/**
 * Java 实现静态链表
 */
public class Staticlist {

    SNode[] node;
    private static final int MAX_SIZE = 15;
    private int length;
    private int head;
    private int current;

    public Staticlist() {
        node = new SNode[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE - 1; i++) {
            node[i] = new SNode(-1, -1);
        }
        node[MAX_SIZE - 1] = new SNode(-1, -1);
        this.length = 0;
        this.head = -1;
        this.current = 0;
    }

    public boolean addTo(int data, int index) {
        if(index<MAX_SIZE && index<=length && node!=null){
            int tcurrent = current;

            if(index == 0){
                node[tcurrent].data = data;
                node[tcurrent].next = head;
                head = tcurrent;
            }else{
                int preIndex = getTrueIndex(index-1);
                node[tcurrent].data = data;
                node[tcurrent].next = node[preIndex].next;
                node[preIndex].next = tcurrent;
            }
            length++;
            current++;
        }
        return true;

    }

    public int getTrueIndex(int index){
        int thead = head;
        for (int i = 0; i < index; i++) {
            thead = node[thead].next;
        }
        return thead;
    }

    public void insert(int data){
        if(length<MAX_SIZE){
            addTo(data,length);
        }
    }

    public static void main(String[] args) {
        Staticlist list = new Staticlist();

        //按顺序插入数据
        for (int i = 0; i < 10; i++) {
            list.insert(i);
        }


        //随机插入数据
        list.addTo(11,3);
        for (int i = 0; i < list.node.length; i++) {
            System.out.println(i+":"+list.node[i].data+":"+list.node[i].next);
        }
    }


}

class SNode{
    int data;
    int next;

    public SNode(int data, int next) {
        this.data = data;
        this.next = next;
    }
}
