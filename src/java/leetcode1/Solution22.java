package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    public static void main(String[] args) {
        Solution22 s = new Solution22();
        System.out.println(s.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0){
            return result;
        }
        int left = 1;
        int right = 0;
        String init = "(";
        all(left,right,n,init,result);
        return result;
    }
    
    public void all(int left,int right,int n,String str,List<String> result){
        if(left == n && right == n){
            result.add(str);
        }
        if(left < n){
            all(left+1,right,n,str+"(",result);
        }
        if(right < n && left > right){
            all(left,right + 1,n,str +")",result);
        }
    }
}
