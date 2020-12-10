package datastructure_geek.array_linklist;

import java.util.Arrays;

/**
 * 支持动态扩容的数组
 */
public class ArraysDemo<T> {

    private T[] data;
    private int capacity;
    private int size;

    public ArraysDemo(int capacity){
        this.capacity = capacity;
        this.size = 0;
        data = (T[]) new Object[capacity];
    }

    public void add(T t){
        // 查看是否需要扩容
        ensureCapacityInternal(size + 1);
        // 添加元素
        data[size++] = t;
    }

    public void print(){
        System.out.println(Arrays.toString(data));
    }

    public void ensureCapacityInternal(int minCapacity){
        // 检查当前数组长度是否足够
        if(minCapacity - data.length > 0){
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity){
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if(newCapacity - minCapacity < 0 ){
            newCapacity = minCapacity;
        }
        T[] newdata = (T[]) new Object[newCapacity];
        for (int i = 0 ; i< data.length;i++){
            newdata[i] = data[i];
        }
        data = newdata;
    }

    public static void main(String[] args) {
        ArraysDemo<Integer> arraysDemo = new ArraysDemo<Integer>(2);
        for (int i = 0 ;i<13;i++){
            arraysDemo.add(i);
        }
        arraysDemo.print();
    }
}
