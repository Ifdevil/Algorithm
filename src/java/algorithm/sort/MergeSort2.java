package algorithm.sort;

import java.util.Arrays;

public class MergeSort2 {

    public static void main(String[] args) {
        int[] nums = {5,1,7,9,2,90,111,123,0,2};
        System.out.println(Arrays.toString(merge(nums)));
    }
    
    public static int[] merge(int[] nums){
        return partition(nums,0,nums.length-1);
    }
    
    public static int[] partition(int[] nums,int low,int high){
        if(low < high){
            int middle = (low + high)/2;
            int[] nums1 = partition(nums,low,middle);
            int[] nums2 = partition(nums,middle+1,high);
            return mergeAll(nums1,nums2);
        }
        int[] temp = new int[1];
        temp[0] = nums[low];
        return temp;
    }
    
    public static int[] mergeAll(int[] nums1,int[] nums2){
        int i = 0;
        int j = 0;
        int count = 0;
        int[] temp = new int[nums1.length+nums2.length];
        while (i<nums1.length || j<nums2.length){
            if(i==nums1.length){
                temp[count] = nums2[j];
                j++;
            }else if(j==nums2.length){
                temp[count] = nums1[i];
                i++;
            }else {
                if(nums1[i] > nums2[j]){
                    temp[count] = nums2[j];
                    j++;
                }else {
                    temp[count] = nums1[i];
                    i++;
                }
            }
            count++;
        }
        return temp;
    }
}
