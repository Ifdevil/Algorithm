package leetcode2;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        if(null == S || S.length() == 0){
            return list;
        }
        int[] last = new int[26];
        for (int i = 0;i<S.length();i++){
            last[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0;i<S.length();i++){
            end = Math.max(end,last[S.charAt(i) - 'a']);
            if(end == i){
                list.add(end-start+1);
                start = i+1;
            }
        }
        return list;
    }
}
