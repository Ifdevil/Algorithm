package leetcode2;

public class Solution62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths2(7,3));
    }

    public static int uniquePaths(int m, int n) {
        if(m == 1){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }

    public static int uniquePaths2(int m, int n) {
        int[][] buffer = new int[n][m];
        for (int i = 0;i<m;i++){
            buffer[0][i] = 1;
        }
        for (int i = 0;i<n;i++){
            buffer[i][0] = 1;
        }
        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){
                buffer[j][i] = buffer[j-1][i]+buffer[j][i-1];
            }
        }
        return buffer[n-1][m-1];
    }
}
