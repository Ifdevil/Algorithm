package algorithm.sort;

import java.util.Arrays;

public class Sort2 {

    public static void main(String[] args) {
        int[] nums = {2,1,3,2,5,6,1,7,9,8};
        
        System.out.println(Arrays.toString(merge(nums)));
    }
    
    public static void bubbleSort(int[] nums){
        for (int i = 0;i<nums.length-1;i++){
            for (int j = 0;j<nums.length-i-1;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    
    public static void quick(int[] nums){
        quickSort(nums,0,nums.length-1);
    }
    public static void quickSort(int[] nums,int low,int high){
        if(low < high){
            int partition = partition(nums,low,high);
            quickSort(nums,low,partition-1);
            quickSort(nums,partition+1,high);
        }
    }
    public static int partition(int[] nums,int low,int high){
        int i = low;
        int j = low;
        int value = nums[high];
        while (i<high){
            if(nums[i] < value){
                swap(nums,i,j);
                j++;
            }
            i++;
        }
        swap(nums,high,j);
        return j;
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
    public static int[] merge(int[] nums){
        return mergeSort(nums,0,nums.length-1);
    }
    public static int[] mergeSort(int[] num,int low,int high){
        if(low < high){
            int middle = (low+high)/2;
            int[] nums1 = mergeSort(num,low,middle);
            int[] nums2 = mergeSort(num,middle+1,high);
            return merge(nums1,nums2);
        }
        int[] tmp = new int[1];
        tmp[0] = num[low];
        return tmp;
    }
    public static int[] merge(int[] nums1,int[] nums2){
        int i = 0;
        int j = 0;
        int count = 0;
        int[] tmp = new int[nums1.length+nums2.length];
        while (i<nums1.length || j<nums2.length){
            if(i == nums1.length){
                tmp[count] = nums2[j];
                j++;
            }else if(j == nums2.length){
                tmp[count] = nums1[i];
                i++;
            }else {
                if(nums1[i] > nums2[j]){
                    tmp[count] = nums2[j];
                    j++;
                }else {
                    tmp[count] = nums1[i];
                    i++;
                }
            }
            count++;
        }
        return tmp;
    }
}
