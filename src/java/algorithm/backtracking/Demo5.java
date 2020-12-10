package algorithm.backtracking;

/**
 * 矩阵最短路径问题
 */
public class Demo5 {

    private int minDist = Integer.MIN_VALUE;

    public void minDistBT(int[][] w,int i,int j,int dist,int n){
        if(i==n && j==n){
            if(minDist > dist) minDist = dist;
            return;
        }
        if(i < n){
            minDistBT(w,i+1,j,dist+w[i][j],n);
        }
        if(j < n){
            minDistBT(w,i,j+1,dist+w[i][j],n);
        }
    }
}
