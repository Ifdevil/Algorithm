package algorithm.sort;

import java.util.Arrays;

public class Sort1 {

    public static void main(String[] args) {
        int[] nums = {4,6,1,9,3,6,1,2,8,9};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    public static void bubbleSort(int[] nums){
        for (int i = 0;i<nums.length;i++){
            boolean flag = false;
            for (int j = 0;j<nums.length-1-i;j++){
                if(nums[j] > nums[j+1]){
                    int num = nums[j];
                    nums[j] = nums[j+1]; 
                    nums[j+1] = num;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
    
    public static void quickSort(int[] nums){
        quickSort2(nums,0,nums.length-1);
    }
    
    public static void quickSort2(int[] nums,int left,int right){
        if (left < right){
            int i = quickSort1(nums, left, right);
            quickSort2(nums,left,i-1);
            quickSort2(nums,i+1,right);
        }
    }
    
    public static int quickSort1(int[] nums,int left,int right){
        int start = left;
        int end = left;
        for (;start<right;start++){
            if(nums[start] < nums[right]){
                swap(nums,start,end);
                end++;  
            }
        }
        swap(nums,right,end);
        return end;
    }
    
    public static void swap(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    
    
}
