package datastructure;

/**
 * 直接插入排序  空间复杂度O(1)，时间复杂度O(n2)
 */
public class InsertSort {


    public static void main(String[] args) {
        int[] a = {2,1,3100,456,21,0,5,6,8};
        insertSort(a,9);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    public static void insertSort(int[] n,int len){
        int i ;
        int j ;
        int temp;
        for (i = 1; i < len; i++) {
            if(n[i-1] > n[i]){
                temp = n[i];
                for( j = i-1; j>=0 && n[j]>temp ;j--){
                    n[j+1] = n[j];
                }
                n[j+1] = temp;
            }
        }
    }
}
