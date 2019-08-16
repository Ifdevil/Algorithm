/**
 * 14. 最长公共前缀
 */
public class Leetcode14 {

    public static void main(String[] args) {
        String[] a = {"flaower","flaow","flaight","flac"};
        System.out.println(longestCommonPrefix3(a));
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static String longestCommonPrefix3(String[] strs){
        if(strs.length == 0) return "";
        return longestCommon(strs,0,strs.length-1);
    }

    static String longestCommon(String[] strs,int left,int right){

        while (left<right){
            int mid = (left+right)/2;
            String strl = longestCommon(strs,left,mid);
            String strr = longestCommon(strs,mid+1,right);
            String common = commonPrefix(strl,strr);
            return common;
        }
        return strs[left];
    }

    static String commonPrefix(String left,String right){
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}
