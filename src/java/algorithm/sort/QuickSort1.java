package algorithm.sort;

import java.util.Arrays;

public class QuickSort1 {

    public static void main(String[] args) {
        int[] nums = {1,3,5,1,2,2};
        QuickSort1 q1 = new QuickSort1();
        q1.quickSort(0,nums.length-1,nums);
        System.out.println(Arrays.toString(nums));
    }
    
    public void quickSort(int left,int right,int[] nums){
        if (left < right){
            int partition = partition(left,right,nums);
            quickSort(left,partition-1,nums);
            quickSort(partition+1,right,nums);
        }
    }
    
    public int partition(int low,int high,int[] nums){
        int right = nums[high];
        int i = low;
        for (int k = low;k<high;k++){
            if(nums[k] < right){
                swap(i,k,nums);
                i++;
            }
        }
        swap(high,i,nums);
        return i;
    }
    
    public void swap(int left,int right,int[] nums){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
