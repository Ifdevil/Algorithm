package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if(S == null || S.length() == 0){
            return result;
        }
        int start = 0;
        int end = 0;
        for (int i = 0;i<S.length();i++){
            char c = S.charAt(i);
            int indexOf = S.lastIndexOf(c);
            if(indexOf >= i){
                end = Math.max(end,indexOf);
            }
            if(i == end){
                result.add(end-start+1);
                start = i+1;
            }
        }
        return result;
    }
}
