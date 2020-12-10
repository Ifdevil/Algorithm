package algorithm.sort;

import java.util.Arrays;

public class QuickSort3 {

    public static void main(String[] args) {
        int[] nums = {2,1,3,2,5,6,1,7,9,8};
        quick(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    public static void quick(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    public static void quickSort(int[] nums,int low,int high){
        if(low < high){
            int q = partition(nums,low,high);
            quickSort(nums,low,q-1);
            quickSort(nums,q+1,high);
        }
    }
    
    public static int partition(int[] nums,int low,int high){
        int i = low;
        int j = low;
        int value = nums[high];
        for (;i<high;i++){
            if(nums[i] < value){
                swap(nums,i,j);
                j++;
            }
        }
        swap(nums,j,high);
        return j;
    }
    
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
