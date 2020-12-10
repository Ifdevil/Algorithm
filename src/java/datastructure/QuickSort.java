package datastructure;

/**
 * 快速排序
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] a = {2,1,3100,456,21,0,5,6,8};
        quicksort(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * 快速排序
     * @param a
     * @param low
     * @param high
     */
    public static void quicksort(int[] a,int low,int high){
        if (low<high){
//            low = sort1(a,low,high);
//            quicksort(a,low+1,high);
//            quicksort(a,0,low-1);
            int q = sort(a,low,high);
            quicksort(a,low,q-1);
            quicksort(a,q+1,high);
        }
    }

    public static int sort(int[] a,int low,int high){
        int temp = a[low];
        while (low < high){
            while (temp < a[high] && high > low) {
                high--;
            }
            a[low] = a[high];
            while (temp > a[low] && low < high) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

    public static int sort1(int[] a,int low,int high){
        int temp = a[high];
        int i = low;
        for (int j = i; j < high; j++) {
            if(a[j] < temp){
                swap(a,j,low);
                low++;
            }
        }
        swap(a,low,high);
        return low;
    }

    public static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
