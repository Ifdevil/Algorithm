package leetcode2;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public static void main(String[] args) {
        
    }

    public int lengthOfLongestSubstring(String s) {
        if(null == s || s.length() == 0){
            return 0;
        }
        int max = 0;
        int start = -1;
        Set<Character> ch = new HashSet<>();
        for (int i = 0;i<s.length();i++){
            if(i != 0){
                ch.remove(s.charAt(i-1));
            }
            while (start + 1 < s.length() && !ch.contains(s.charAt(i))){
                ch.add(s.charAt(i));
                start++;
            }
            max = Math.max(start - i + 1,max);
        }
        return max;
    }
}
