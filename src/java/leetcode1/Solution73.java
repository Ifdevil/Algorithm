package leetcode1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution73 {

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        for(int i=0;i<matrix.length;i++)
            System.out.println(Arrays.toString(matrix[i]));
    }

    public static void setZeroes(int[][] matrix) {
        if(matrix == null |  matrix.length == 0 || matrix[0].length==0){
            return;
        }
        int m = matrix[0].length;
        int n = matrix.length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();
        for (int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                if(matrix[i][j] == 0){
                    // 列 = 0;
                    row.add(i);
                    // 行 = 0;
                    column.add(j);
                }
            }
        }
        for (Integer r:row){
            for (int i = 0;i<m;i++){
                matrix[r][i] = 0;
            }
        }
        for (Integer c:column){
            for (int i = 0;i<n;i++){
                matrix[i][c] = 0;
            }
        }
    }
}
