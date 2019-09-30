import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class Leetcode22 {

    public static void main(String[] args) {
        Leetcode22 l = new Leetcode22();
        List<String> strings = l.generateParenthesis(3);
        for (String s:strings){
            System.out.println(s);
        }
    }


    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    // 回溯算法
    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if(cur.length() == max * 2 ){
            ans.add(cur);
            return;
        }
        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}
