package datastructure;

/**
 * 插入类排序
 */
public class InsertSort {


    public static void main(String[] args) {
        int[] a = {2,1,3100,456,21,0,5,6,8};
        insertSort3(a,a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * 直接插入排序  空间复杂度O(1)，时间复杂度O(n2)
     * @param n
     * @param len
     */
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

    /**
     * 折半插入排序
     * @param n
     * @param len
     */
    public static void insertSort2(int[] n,int len){
        int i;
        int j;
        int temp;
        int low;
        int high;
        int mid;

        for (i = 1; i < len; i++) {
            low = 0;
            high = i-1;

            if(n[i-1] > n[i]){
                temp = n[i];
                while (low <= high){
                    mid = (low + high)/2;
                    if(n[mid]>temp){
                        high = mid-1;
                    }else if (n[mid] < temp){
                        low = mid+1;
                    }
                }
                for (j = i-1;j>=high+1;j--){
                    n[j+1] = n[j];
                }
                n[high+1] = temp;
            }
        }
    }

    /**
     * 希尔排序
     * @param n
     * @param len
     */
    public static void insertSort3(int[] n,int len){
        int i;
        int j;
        int temp;
        for(int d = len/2;d>=1;d /= 2){
            for (i = d;i<len;i++){
                temp = n[i];
                if(n[i-d]>n[i]){
                    for (j=i-d;j>=0&&n[j]>temp;j-=d){
                        n[j+d] = n[j];
                    }
                    n[j+d] = temp;
                }
            }
        }
    }
}
