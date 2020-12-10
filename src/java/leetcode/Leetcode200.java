package leetcode;

/**
 * 岛屿数量
 */
public class Leetcode200 {

    public static void main(String[] args) {

        Leetcode200 l = new Leetcode200();
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int a = l.numIslands(grid);
        System.out.println(a);
    }

    /**
     * 深度优先搜索
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0){
            return 0;
        }
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    num++;
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid,int i,int j){
        int nr = grid.length;
        int nc = grid[0].length;

        if( i<0 || j<0 || i >= nr || j >= nc || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);

    }
}
