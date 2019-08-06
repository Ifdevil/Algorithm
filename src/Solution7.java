import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution7 {

    public static void main(String[] args) {
        System.out.println(convert("AB",1));

    }

    public static String convert(String s, int numRows) {

        String[] nRows = new String [numRows];
        Arrays.fill(nRows,"");
        boolean goingdown = true;
        int row = 0;

        if(numRows == 1){
            return s;
        }
        for (char c : s.toCharArray()){
            nRows[row] = nRows[row] + c;
            if(row == numRows-1 || row == 0){
                goingdown = !goingdown;
            }
            row = goingdown ? row-1 : row+1;
        }

        String str = "";
        for (int i = 0; i < numRows; i++){
            str += nRows [i];
        }

        return str;
    }
}
