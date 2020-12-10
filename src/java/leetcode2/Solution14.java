package leetcode2;

public class Solution14 {

    public static void main(String[] args) {
        String[] strs = {"dog","docecar","dor"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(null == strs || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String s1 = strs[0];
        for (int i = 1;i<strs.length;i++){
            if(s1.equals("")){
                return "";
            }
            String s2 = strs[i];
            int i1 = 0;
            String common = "";
            while (i1<s1.length() && i1<s2.length()){
                if(s1.charAt(i1) == s2.charAt(i1)){
                    common += s1.charAt(i1);
                    i1++;
                }else {
                    break;
                }
            }
            s1 = common;
        }
        return s1;
    }

    public static String longestCommonPrefix1(String[] strs) {
        if(null == strs || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String s1 = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(s1) != 0) {
                s1 = s1.substring(0, s1.length() - 1);
                if (s1.isEmpty()) return "";
            }
        }
        return s1;
    }
}
