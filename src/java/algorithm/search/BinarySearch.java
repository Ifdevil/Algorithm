package algorithm.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 89, 100, 200, 300, 527};
        System.out.println(binarySearch(nums,1));
    }

    public static int binarySearch(int[] nums,int target){
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        int low = 0;
        int high = nums.length;
        int value = -1;
        while ( low < high){
            int middle = low+(high-low)/2;//(low + hight) / 2;
            if(nums[middle] == target){
                return middle;
            }
            if(value > target){
                high = middle;
            }
            if(value < target){
                low = middle + 1;
            }
        }
        return value;
    }
}
