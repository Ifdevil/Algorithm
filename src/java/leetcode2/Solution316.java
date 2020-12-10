package leetcode2;

public class Solution316 {

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
    }

    public static String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0;
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }

    /**
     * 递归
     * 先统计每个数字出现的次数，在出现多次的基础上优先取最小的字母
     * @param s
     * @return
     */
    public static String removeDuplicateLetters1(String s){
        int[] cnt = new int[26];
        int pos = 0;
        for (int i = 0;i<s.length();i++){
            cnt[s.charAt(i)-'a']++;
        }
        for (int i = 0;i<s.length();i++){
            if(s.charAt(i) < s.charAt(pos)){
                pos = i;
            }
            if(cnt[s.charAt(i) - 'a'] < 2){
                break;
            }
        }
        return s.length() == 0 ? "" : s.charAt(pos)+removeDuplicateLetters1(s.substring(pos+1).replaceAll(""+s.charAt(pos),""));
    }
}
