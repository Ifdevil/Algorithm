package datastructure;

/**
 * 简单选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = {2,1,3100,456,21,0,5,6,8};
        selectsort(a,a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * 简单选择排序
     * @param a
     * @param len
     */
    public static void selectsort(int[] a,int len){
        int min;
        for (int i = 0; i < len; i++) {
            min = i;
            for (int j = i+1; j < len; j++) {
                if(a[j] < a[min]) min = j;
            }
            if(min != i){
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }
}
