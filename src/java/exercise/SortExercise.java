package exercise;

import java.util.Arrays;

public class SortExercise {

    public static void main(String[] args) {
        int[] nums = {2,1,3,2,5,6,1,7,9,8};
        System.out.println(Arrays.toString(mergeSort(nums)));
    }
    
    public static void maoPao(int[] nums){
        for (int i = 0;i<nums.length;i++){
            boolean flag = false;
            for (int j = 1;j<nums.length-i;j++){
                if(nums[j-1] > nums[j]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
            if(!flag){
                return;
            }
        }
    }
    
    public static void quickSort(int[] nums){
        int high = nums.length - 1;
        quickSort_1(nums, 0, high);
        
    }
    private static void quickSort_1(int[] nums,int low,int high){
        if (low < high){
            int middle = partition(nums,low,high);
            quickSort_1(nums,low,middle-1);
            quickSort_1(nums,middle+1,high);
        }
    }
    private static int partition(int[] nums,int low,int high){
        int i = low;
        for (int j = low;j<high;j++){
            if(nums[j] < nums[high]){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,high);
        return i;
    }
    
    public static int[] mergeSort(int[] nums){
        return mergeSort_1(nums,0,nums.length-1);
    }
    
    private static int[] mergeSort_1(int[] nums,int low,int high){
        if(low < high){
            int middle = (low+high)/2;
            int[] nums1 = mergeSort_1(nums,low,middle);
            int[] nums2 = mergeSort_1(nums,middle+1,high);
            return merge(high - low + 1,nums1,nums2);
        }
        int[] single = {nums[low]};
        return single;
    }
    private static int[] merge(int length,int[] nums1,int[] nums2){
        int[] nums = new int[length];
        int a = 0;
        int b = 0;
        int c = 0;
        while (a < nums1.length && b < nums2.length){
            if(nums1[a] <= nums2[b]){
                nums[c++] = nums1[a++];
            }else {
                nums[c++] = nums2[b++];
            }
        }
        while (a < nums1.length){
            nums[c++] = nums1[a++];
        }
        while (b < nums2.length){
            nums[c++] = nums2[b++];
        }
        return nums;
    }
    
    private static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
