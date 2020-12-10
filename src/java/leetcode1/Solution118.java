package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {

    public static void main(String[] args) {
        
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == -0){
            return result;
        }
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for (int i = 1;i<numRows;i++){
            List<Integer> integers1 = new ArrayList<>();
            List<Integer> integers2 = result.get(i - 1);
            integers1.add(1);
            for (int j = 1;j<i;j++){
                integers1.add(integers2.get(j-1) + integers2.get(j));
            }
            integers1.add(1);
            result.add(integers1);
        }
        return result;
    }
    
}
