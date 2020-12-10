package leetcode2;

import java.util.Arrays;

public class Solution6 {

    public static void main(String[] args) {
        System.out.println(convert("AB",1));
    }

    public static String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows == 1){
            return s;
        }
        String[] result = new String[numRows];
        Arrays.fill(result,"");
        int count = 1;
        boolean flag = true;
        for (int i = 0;i<s.length();i++){
            String s1 = result[count-1];
            s1+=s.charAt(i);
            result[count-1] = s1;
            if(!flag){
                count--;
                if(count <= 1){
                    flag = true;
                }
            }else {
                count++;
                if(count >= numRows){
                    flag = false;
                }
            }
        }
        String re = "";
        for (int i = 0;i<numRows;i++){
            re+=result[i];
        }
        return re;
    }
}
