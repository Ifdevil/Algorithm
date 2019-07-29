package datastructure;

/**
 * Java 简易顺序栈
 */
public class StackDemo {

    private ElementData[] elements = new ElementData[10];
    private int top = -1;


    public ElementData push(ElementData e){
        synchronized (this){
            top++;
            elements[top] = e;
        }
        return e;
    }

    public synchronized ElementData pop(){
        if(top == -1)
            throw new RuntimeException("empty");
        return elements[top--];
    }

    public int getSize(){
        return elements.length;
    }


    public static void main(String[] args) {
        StackDemo stack = new StackDemo();
        for (int i = 0; i < 6; i++) {
            ElementData e = new ElementData();
            e.data = i;
            stack.push(e);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(stack.pop().data);
        }
    }


}
class ElementData{
    int data;
}