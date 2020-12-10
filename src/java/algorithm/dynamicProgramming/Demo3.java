package algorithm.dynamicProgramming;

/**
 * 矩阵对角线最短路径
 */
public class Demo3 {

    /**
     * 状态转移表
     * @param matrix
     * @param n
     * @return
     */
    public int minDistDP(int[][] matrix,int n){
        int[][] states = new int[n][n];
        int sum = 0;
        for (int i = 0; i < n; i++) { // 初始化第一行
            sum += matrix[0][i];
            states[0][i] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][0];
            states[i][0] = sum;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                states[i][j] = matrix[i][j] + Math.min(states[i-1][j],states[i][j-1]);
            }
        }
        return states[n-1][n-1];
    }

    private int[][] matrix =
            {{1,3,5,9}, {2,1,3,4},{5,2,6,7},{6,8,4,3}};
    private int n = 4;
    private int[][] mem = new int[4][4];
    public int minDsit(int i,int j){
        if(i ==0 && j==0) return matrix[i][j];
        if(mem[i][j]>0) return mem[i][j];
        int minLeft = Integer.MAX_VALUE;
        if(j-1>=0){
            minLeft = minDsit(i,j-1);
        }
        int minUp = Integer.MAX_VALUE;
        if(i-1>=0){
            minUp = minDsit(i-1,j);
        }
        int current = matrix[i][j] + Math.min(minLeft,minUp);
        mem[i][j] = current;
        return current;
    }


}
