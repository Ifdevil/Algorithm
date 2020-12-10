package algorithm.sort;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        QuickSort2 q2 = new QuickSort2();
        int[] nums = {4,6,1,9,3,6,1,2,8,9};
        q2.quickSort(0,nums.length-1,nums);
        System.out.println(Arrays.toString(nums));
    }
    
    public void quickSort(int low,int high,int[] nums){
        if(low < high){
            int partiton = partition(low,high,nums);
            quickSort(low,partiton-1,nums);
            quickSort(partiton+1,high,nums);
        }
    }
    
    public int partition(int low,int high,int[] nums){
        int value = nums[high];
        int i = low;
        for (int j = low;j<high;j++){
            if(nums[j] < value){
                swap(i,j,nums);
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
