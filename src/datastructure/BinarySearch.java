package datastructure;

public class BinarySearch {


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println(bsearch(a,9,5));
    }

    /**
     * 二分法查找
     * 有序数组、且不重复
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch(int[] a,int n,int value){
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + ((high-low)>>1);
            if(a[mid] == value){
                return mid;
            }
            if (a[mid] > value) {
                high = mid -1;
            }
            if(a[mid] < value){
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分法搜索变体
     * 有序数组、有重复元素，查找第一个与给定值相等元素的位置
     * 两种写法
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low < n && a[low]==value) return low;
        else return -1;
    }
    public static int bsearch12(int[] a, int n, int value) {
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + ((high - low) >> 1);
            if(a[mid] > value){
                high = mid - 1;
            }
            if(a[mid] < value){
                low = mid +1;
            }
            if(a[mid] == value){
                if(mid == 0 || a[mid - 1] != value) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分法搜索变体
     *      * 有序数组、有重复元素，查找最后一个与给定值相等元素的位置
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + ((high - low) >> 1);
            if(a[mid] > value){
                high = mid - 1;
            }
            if(a[mid] < value){
                low = mid +1;
            }
            if(a[mid] == value){
                if(mid == n-1 || a[mid + 1] != value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分法搜索变体
     *      * 有序数组、有重复元素，查找第一个大于等于给定值相等元素的位置
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + ((high - low) >> 1);
            if(a[mid] >= value){
                if(mid == 0 || a[mid - 1] < value) return mid;
                else high = mid - 1;
            }
            if(a[mid] < value){
                low = mid +1;
            }
        }
        return -1;
    }

    /**
     * 二分法搜索变体
     *      * 有序数组、有重复元素，查找最后一个小于等于给定值相等元素的位置
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch4(int[] a, int n, int value) {
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + ((high - low) >> 1);
            if(a[mid] >= value){
                high = mid - 1;
            }
            if(a[mid] < value){
                if(mid == n-1 || a[mid + 1] > value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

}
