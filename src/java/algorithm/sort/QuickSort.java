package algorithm.sort;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {2,1,3,2,5,6,1,7,9,8};
        System.out.println(Arrays.toString(quickSort(nums)));
    }

    /**
     * 递归
     * @param nums
     * @return
     */
    public static int[] quickSort(int[] nums){
        quickSort_c_noRecurrence(nums,0,nums.length -1);
        return nums;
    }
    public static void quickSort_c(int[] nums,int left,int right){
        if(left < right){
            int i = partition(nums,left,right);
            quickSort_c(nums,left,i-1);
            quickSort_c(nums,i+1,right);
        }
    }

    /**
     * 非递归
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort_c_noRecurrence(int[] nums,int left,int right){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(right);
        stack.push(left);
        while (!stack.isEmpty()){
            int i = stack.pop();
            int j = stack.pop();
            if(i < j){ // 保证左边的值小于右边的值
                int k = partition(nums,i,j);
                if(k > i){ // 确保不是同一个值，保证左边的值小于右边的值
                    stack.push(k-1);
                    stack.push(i);
                }
                if(k < j){ // 确保不是同一个值，保证左边的值小于右边的值
                    stack.push(j);
                    stack.push(k+1);
                }
            }
        }
    }

    public static int partition(int[] nums,int left,int right){
        int value = nums[right];
        int i = left;
        int j = left;
        for (;j<right;j++){
            if(nums[j] < value){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,right);
        return i;
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
