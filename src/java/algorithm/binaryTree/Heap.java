package algorithm.binaryTree;

/**
 * 堆
 */
public class Heap {
    private int[] a;
    private int n;
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void buildHeap(int[] a){
        for (int i = count/2;i>=1;i--){
            heapify(a,count,i);
        }
    }

    public void insert(int data){
        if(count >= n) return;
        ++count;
        a[count] = data;
        int i = count;
        while ( i/2>0 && a[i] > a[i/2]){
            swap(a,i,i/2);
            i = i/2;
        }
    }
    // 大顶堆
    public void removeMax(){
        if(count == 0) return;
        a[1] = a[count];
        --count;
        heapify(a,count,1);
    }

    private void heapify(int[] a, int n, int i) {
        if(count == 0) return;
        while (true){
            int maxPos = i;
            // 左节点比较：父节点和左节点取最大值
            if( 2*i <= n && a[i] < a[2*i]){
                maxPos = 2*i;
            }
            // 右节点比较：和上一步获得最大值比较
            if( 2*i+1 <= n && a[maxPos] < a[2*i+1]){
                maxPos = 2*i+1;
            }
            // 左右都小于父节点
            if(maxPos == i) break;
            // 交换
            swap(a,i,maxPos);
            i = maxPos;
        }
    }

    public void sort(){
        // 建堆
        buildHeap(a);
        int k = count;
        while (k >= 1){
            swap(a,1,count);
            k--;
            heapify(a,k,1);
        }
    }

    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
