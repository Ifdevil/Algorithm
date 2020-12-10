package algorithm.dynamicProgramming;

import java.util.Arrays;

/**
 * 背包问题：能装W kg重量的书包，有n件不同的物品，重量不同，不可分割，再引入物品价值这一变量，在满足最大重量的前提下，总价值最大
 */
public class Demo2 {


    /**
     * 动态规划
     * @param weight
     * @param value
     * @param n
     * @param w
     * @return
     */
    public int f1(int[] weight,int[] value,int n,int w){
        int[][] states = new int[n][w+1];
        Arrays.fill(states,-1);
        states[0][0] = 0;
        if(weight[0] < w){
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; i++) { //动态规划状态转移
            for (int j = 0; j <= w; j++) { // 第i件物品不放进书包

                if(states[i-1][j] >= 0) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; j++) { // 第i件物品放进书包
                if(states[i-1][j] >= 0){
                    int v = states[i-1][j] + value[i];
                    if( v > states[i][j+weight[i]]){
                        states[i][j+weight[i]] = v;
                    }
                }
            }

        }
        int maxval = 0;
        for (int i = 0; i <= w; i--) {
            if(states[n-1][i] > maxval) maxval = states[n-1][i];
        }
        return maxval;
    }
}
