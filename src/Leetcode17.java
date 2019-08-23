import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 */
public class Leetcode17 {


    public static void main(String[] args) {
        Leetcode17 leetcode = new Leetcode17();
        List<String> put = leetcode.Combinations("","23");
        for (int i = 0; i < put.size(); i++) {
            System.out.println(put.get(i));
        }
    }
    private final static String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private final List<String> output = new ArrayList<String>();


    public List<String> letterCombinations(String digits) {
        return Combinations("",digits);
    }

    public List<String> Combinations(String combination,String digits) {
        if(digits.length()==0){
            if(combination.length()!=0){
                output.add(combination);
            }

        }else{
            String c = digits.substring(0,1);
            String letters = letterMap[Integer.parseInt(c)];
            for (int i = 0; i < letters.length(); i++) {
                String s = letters.substring(i,i+1);
                Combinations(combination+s,digits.substring(1));
            }
        }

        return output;
    }
}
