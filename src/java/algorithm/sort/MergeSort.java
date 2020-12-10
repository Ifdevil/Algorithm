package algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {2,1,3,2,5,6,1,7,9,8};
        System.out.println(Arrays.toString(mergeSort(nums)));
    }

    public static int[] mergeSort(int[] nums){
        if(nums.length<2) return nums;
        return mergeSort_c(nums,0,nums.length-1);
    }
    public static int[] mergeSort_c(int[] nums,int left,int right){
        if(left < right) {
            int p = (left + right) / 2;
            int[] nums1 = mergeSort_c(nums, left, p);
            int[] nums2 = mergeSort_c(nums, p+1, right);
            return merge(right - left + 1, nums1, nums2);
        }
        int[] single = {nums[left]};
        return single;
    }
    public static int[] merge(int length,int[] left,int[] right){
        int[] nums = new int[length];
        int a = 0;
        int b = 0;
        int k = 0;
        while (a<left.length && b<right.length){
            int a1 = left[a];
            int b1 = right[b];
            if(a1 < b1){
                nums[k++] = left[a++];
            }else {
                nums[k++] = right[b++];
            }
        }
        while (a < left.length){
            nums[k++] = left[a++];
        }
        while (b < right.length){
            nums[k++] = right[b++];
        }
        return nums;
    }
}
