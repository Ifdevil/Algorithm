package leetcode1;

import java.util.Arrays;

public class Solution6 {

    public static void main(String[] args) {
        String s = "AB";
        System.out.println(convert(s,2));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        String convert = "";
        int point = 0;
        boolean path = true;
        String[] rows = new String[numRows];
        Arrays.fill(rows,"");
        for (int i = 0;i<s.length();i++){
            rows[point] += s.charAt(i);
            if(point == numRows-1){
                path = false;
            }
            if(point == 0){
                path = true;
            }
            if(path){
                point++;
            }else {
                point--;
            }
        }
        for (int j = 0;j<numRows;j++){
            convert += rows[j];
        }
        return convert;
    }
}
