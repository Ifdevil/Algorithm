package leetcode2;

import java.util.HashMap;
import java.util.Map;

public class Solution387 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar1("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        Map<Character,Integer> table = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            table.put(c,table.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (table.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static int firstUniqChar1(String s) {
        int index = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int beginIndex = s.indexOf(ch);
            // 从头开始的位置是否等于结束位置，相等说明只有一个，
            if (beginIndex != -1 && beginIndex == s.lastIndexOf(ch)) {
                //取小的，越小代表越前。
                index = (index == -1 || index > beginIndex) ? beginIndex : index;
            }
        }
        return index;
    }
}
