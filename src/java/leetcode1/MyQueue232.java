package leetcode1;

import java.util.Stack;

public class MyQueue232 {

    public static void main(String[] args) {
        MyQueue232 queue = new MyQueue232();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // 返回 1
        System.out.println(queue.pop());   // 返回 1
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty()); // 返回 false
    }

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int length;
    
    public MyQueue232() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
        this.length = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
        length++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){
            while (stack1.size() > 0){
                stack2.push(stack1.pop());
            }
        }
        length--;
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            while (stack1.size() > 0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return length == 0;
    }
}
