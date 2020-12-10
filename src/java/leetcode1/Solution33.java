package leetcode1;

public class Solution33 {

    public static void main(String[] args) {
        Solution33 s33 = new Solution33();
        int[] nums = {3,1};
//        int[] nums = {0,1,2,4,5,6,7};
        System.out.println(s33.search1(nums,1));
    }


    public int search1(int[] nums, int target) {
        if(null == nums || nums.length == 0){
            return -1;
        }
        // 二分
        int low = 0;
        int high = nums.length-1;
        while (high >= low){
            int mid = (low + high)/2;
            if(nums[mid] == target) return mid;
            if(nums[0] <= nums[mid]){
                // 左边有序
                if(nums[0] <= target && nums[mid] > target){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else {
                // 右边有序
                if(nums[mid] <= target && nums[high] >= target){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        if(null == nums || nums.length == 0){
            return -1;
        }
        int n1 = nums[0];
        int n2 = nums[nums.length - 1];
        if(n1 > n2){
            if(target >= n1){
                int index = 0;
                while (nums[index+1]>nums[index] || nums[index] == target){
                    if(nums[index]==target){
                        return index;
                    }else {
                        index++;
                    }
                }
            }else {
                int index = nums.length-1;
                while (nums[index-1]<nums[index] || nums[index] == target){
                    if(nums[index]==target){
                        return index;
                    }else {
                        index--;
                    }
                }
            }
        }else {
            // 二分
            int low = 0;
            int high = nums.length-1;
            while (high >= low){
                int mid = (low + high)/2;
                if(nums[mid] > target){
                    high = mid-1;
                }else if(nums[mid] < target){
                    low = mid +1;
                }else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
