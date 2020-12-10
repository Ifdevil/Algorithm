package leetcode1;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s.length() == 0){
            return max;
        }
        int start = -1;
        int move = 0;
        Map<Character,Integer> ch = new HashMap<>();
        for (move =0;move<s.length();move++){
            char c = s.charAt(move);
            if(!ch.containsKey(c)){
                ch.put(c,move);
                max = Math.max(move - start, max);
            }else {
                start = Math.max(start,ch.get(c));
                ch.put(c,move);
                max = Math.max(move - start, max);
            }
        }
        return max;
        
    }
}
