package datastructure;

/**
 * 查找算法
 */
public class Search {


    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,8,9,10,50,100};
        System.out.println(binary_search(arr,1));
    }


    /**
     * 折半查找
     * @param arr
     * @param target
     * @return
     */
    public static int binary_search(int[] arr,int target){
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high){
            mid = (low + high)/2;
            if(arr [mid]==target){
                return mid;
            }else if (arr [mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;

    }
}
