package leetcode1;

public class Solution101 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        Solution101 s101 = new Solution101();
        s101.isSymmetric(root);
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }
    
    
     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
