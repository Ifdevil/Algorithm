package datastructure;

/**
 * Java 实现简易循环Array队列
 */
public class CircularQueueDemo {

    private int capacity = 10;
    private QueueData[] queues = new QueueData[capacity];
    private int front = 0;
    private int rear = 0;

    public boolean add(QueueData q){
        queues[rear] = q;
        rear =(rear + 1) % capacity;
        if(rear == front){
            throw new RuntimeException("full");
        }
        return true;
    }

    public QueueData remove(){
        if(front == rear){
            throw new RuntimeException("empty");
        }
        QueueData reomved = queues[front];
        queues[front] = null;
        front = (front + 1) % capacity;
        return reomved;
    }


}

class QueueData{
    int data;
}
