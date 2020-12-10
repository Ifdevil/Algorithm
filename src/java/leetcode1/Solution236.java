package leetcode1;

public class Solution236 {

    public static void main(String[] args) {
        
    }
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root,p,q);
        return ans;
    }

    /**
     * 递归实现
     * @param root
     * @param p
     * @param q
     * @return
     */
    private boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if(root == null) return false;
        boolean lson = dfs(root.left,p,q);
        boolean rson = dfs(root.right,p,q);
        if((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))){
            this.ans = root;
        }
        return lson || rson || root.val == p.val || root.val == q.val;
    }
    
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
