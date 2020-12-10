package datastructure;

/**
 * 冒泡排序
 */
public class BubbleSort {


    public static void main(String[] args) {

        int[] a = {2,1,3100,456,21,0,5,6,8};
        bubblesort(a,a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * 冒泡排序
     * @param n
     * @param len
     */
    public static void bubblesort(int[] n,int len){
        for (int i = 0; i < len-1; i++) {
            boolean flag = false;
            for (int j = len-1; j > i ; j--) {
                if(n[j-1]>n[j]){
                    int temp = n[j];
                    n[j] = n[j-1];
                    n[j-1] = temp;
                    flag =true;
                }
            }
            if(!flag){
                return;
            }
        }
    }
}
