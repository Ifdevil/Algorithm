package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56 {

    public static void main(String[] args) {
        int[] a1 = new int[]{1,3};
        int[] a2 = new int[]{0,1};
        int[][] merges = new int[2][2];
        merges[0] = a1;
        merges[1] = a2;
        System.out.println(Arrays.deepToString(merge(merges)));
    }
    
    public static int[][] merge(int[][] intervals) {
        if(null == intervals || intervals.length == 0 || intervals.length == 1){
            return intervals;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<List<Integer>> result = new ArrayList<>();
        int[] temp = new int[2];
        for (int i = 0;i<intervals.length;i++){
            if(i == 0 || intervals[i][0] > temp[1]){
                if(i != 0){
                    result.add(Arrays.asList(temp[0],temp[1]));
                }
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
            }else {
                temp[0] = Math.min(temp[0],intervals[i][0]);
                temp[1] = Math.max(temp[1],intervals[i][1]);
            }
        }
        result.add(Arrays.asList(temp[0],temp[1]));
        int[][] news = new int[result.size()][2];
        for (int i = 0;i<result.size();i++){
            news[i] = new int[]{result.get(i).get(0),result.get(i).get(1)};
        }
        return news;
    }
}
