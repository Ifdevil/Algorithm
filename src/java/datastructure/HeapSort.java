package datastructure;

/**
 * 最大堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = {2,1,3100,456,21,0,5,6,8,3,78,9999,10};
        buildMaxHeap(a,a.length);
        for (int i = a.length-1; i > 0; i--) {
            change(a,0,i);
            adjustDown(a,0,i-1);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

    public static void buildMaxHeap(int[] a,int len){
        for (int i = (len-1)/2-1; i >=0 ; i--) {
            adjustDown(a,i,len);
        }
    }

    public static void adjustDown(int[] a,int k,int len){
        int temp = a[k];
        for (int i = 2*k+1; i < len; i=2*i+1) {
            if(i<len && a[i] < a[i+1]) i++;
            if(a[i] > temp){
                a[k] = a[i];
                k=i;
            }else{
                break;
            }
        }
        a[k] = temp;

    }

    public static void change(int[] a,int low,int high){
        int temp = a[0];
        a[0] = a[high];
        a[high] = temp;
    }
}
