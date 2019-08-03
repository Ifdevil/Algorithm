package datastructure;

/**
 * 查找算法
 */
public class Search {


    public static void main(String[] args) {
        int[] arr = {1,3,5,8,6,7,9,10,50,100,200};
        //System.out.println(binary_search(ar,1));
        System.out.println(block_search(arr,3));
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

    /**
     * 分块查找
     * @param arr
     * @param target
     * @return
     */
    public static int block_search(int[] arr,int target){
        int len = 3;
        Index[] indexs = new Index[arr.length % len == 0 ? arr.length / len : arr.length / len +1 ];
        int max = 0;
        Index index = null;
        // 建立一个索引表
        for (int i = 0; i < arr.length; i++){
            if(arr [i]> max ) max = arr [i];
            if(i%len == 0){
                index = new Index();
                index.index = i;
                index.max = max;
                indexs[i/len] = index;
            }
            index.max = max;


        }

        int low = 0;
        int high = indexs.length-1;
        int mid = 0;
        int block_index = 0;
        // 块间查找
        while (low <= high){
            mid = (low + high)/2;
            if( target > indexs[mid].max){
                low = mid + 1;
             }else if ( target < indexs[mid].max ){
                high = mid - 1;
            }else{
                break;
            }
        }
        block_index = indexs[mid].index;
        // 块内顺序查找
        return order_search(arr,target,block_index,3);
    }

    /**
     * 顺序查找
     * @param arr
     * @param target
     * @param start
     * @param len
     * @return
     */
    public static int order_search(int[] arr,int target,int start,int len){
        for (int i = start; i < start + len; i++) {
            if(arr [i] == target){
                return i;
            }
        }
        return -1;
    }

    private static class Index{
        int max;
        int len;
        int index;

        public String toString() {
            return "max:"+max +"; index:"+index ;
        }
    }
}
