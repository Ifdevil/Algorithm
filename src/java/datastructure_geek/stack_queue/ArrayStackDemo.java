package datastructure_geek.stack_queue;

import java.util.Arrays;

public class ArrayStackDemo<T> {

    T[] data;
    int headIndex;
    int size;
    int capacity;

    public ArrayStackDemo(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.headIndex = -1;
        data = (T[]) new Object[capacity];
    }

    public void push(T t){
        // 校验是否有足够空间容纳
        data[size++] = t;
        headIndex++;
    }

    public T pop(){
        if(headIndex >= 0){
            T t = data[headIndex];
            data[headIndex--] = null;
            return t;
        }
        return null;
    }

    public void print(){
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        ArrayStackDemo<Integer> stack = new ArrayStackDemo<Integer>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
