package leetcode2;

import java.util.HashSet;
import java.util.Set;

public class Solution73 {

    public static void main(String[] args) {
        
    }

    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length==0){
            return;
        }
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> rowSet = new HashSet<>();
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    colSet.add(j);
                    rowSet.add(i);
                }
            }
        }
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){
                if(colSet.contains(j)){
                    matrix[i][j] = 0;
                }
                if(rowSet.contains(i)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}