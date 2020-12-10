package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class MinStack155 {

    public static void main(String[] args) {
        MinStack155 minStack = new MinStack155();
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }

    private int min ;
    private List<Integer> container;
    private int len;
    
    public MinStack155() {
        this.container = new ArrayList<Integer>();
        this.min = Integer.MAX_VALUE;
        this.len = 0;
    }

    public void push(int x) {
        container.add(x);
        len++;
        if(x < min){
            min = x;
        }
    }

    public void pop() {
        container.remove(len-1);
        len--;
        min = Integer.MAX_VALUE;
        for (int i = 0;i<len;i++){
            if(container.get(i) < min){
                min = container.get(i);
            }
        }
    }

    public int top() {
        return container.get(len-1);
    }

    public int getMin() {
        return min;
    }
}
