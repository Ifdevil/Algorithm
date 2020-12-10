package algorithm.search;

public class BinarySearchChange1 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 6, 6, 6, 6, 6, 300, 527};
        System.out.println(binarySearch1(nums1,6));
        System.out.println(binarySearch2(nums1,6));
        System.out.println(binarySearch3(nums1,6));

        int[] nums2 = {4,5,6,1,2,3};
        System.out.println(search(nums2,3));
    }

    /**
     * 二分法查找第一个等于给定元素值的位置
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch1(int[] nums,int target){
        if(nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int middle = low + (high - low)/2;
            if(nums[middle] == target && (middle == 0 || nums[middle-1]<target)){
                return middle;
            }
            if(nums[middle]>=target){
                high = middle - 1;
            }
            if(nums[middle]<target){
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 二分法查找最后一个等于给定元素值的位置
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch2(int[] nums,int target){
        if(nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int middle = low + (high - low)/2;
            if(nums[middle] > target){
                high = middle - 1;
            }
            else if(nums[middle] < target){
                low = middle + 1;
            }else{
                if(middle == nums.length -1 || nums[middle+1] > target){
                    return middle;
                }else {
                    low = middle + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分法查找第一个大于等于给定值的元素
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch3(int[] nums,int target){
        if(nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int middle = low + (high - low)/2;
            if(nums[middle] >= target){
                if(middle==0 || nums[middle-1] < target) return middle;
                else high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int middle = low + (high - low)/2;
            if(nums[middle] == target){
                return middle;
            }
            if(nums[middle] > target){
                // 左边有序
                if(nums[low] <= target && target <= nums[middle-1]){
                    high = middle - 1;
                }else {
                    low = middle + 1;
                }
            }
            if(nums[middle] < target){
                // 右边有序
                if(nums[middle+1] <= target && nums[high] >= target){
                    low = middle + 1;
                }else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }
}
