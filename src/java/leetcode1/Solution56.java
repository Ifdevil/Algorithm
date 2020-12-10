package leetcode1;

import java.util.Arrays;

public class Solution56 {

    public static void main(String[] args) {
        int[] a1 = new int[]{1,2};
        int[] a2 = new int[]{3,5};
        int[] a3 = new int[]{5,8};
        int[][] merges = new int[3][2];
        merges[0] = a1;
        merges[1] = a2;
        merges[2] = a3;
        System.out.println(Arrays.deepToString(merge(merges)));
    }

    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(len < 2){
            return intervals;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int count = -1;
        int[][] copy = new int[len][2];
        for (int i = 0;i<len;i++){
            int[] a = intervals[i];
            if(count == -1 || a[0] > copy[count][1]){
                copy[++count] = a;
            }else {
                copy[count][1] = Math.max(copy[count][1],a[1]);
            }
        }
        return Arrays.copyOf(copy, count+1);
    }
}
