package leetcode2;

public class Solution104 {

    public static void main(String[] args) {
        Solution104.TreeNode n1 = new Solution104.TreeNode(3);
        Solution104.TreeNode n2 = new Solution104.TreeNode(9);
        Solution104.TreeNode n3 = new Solution104.TreeNode(20);
        Solution104.TreeNode n4 = new Solution104.TreeNode(15);
        Solution104.TreeNode n5 = new Solution104.TreeNode(7);
        Solution104.TreeNode n6 = new Solution104.TreeNode(7);
        Solution104.TreeNode n7 = new Solution104.TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        n5.right = n6;
        n6.right = n7;
        Solution104 s = new Solution104();
        System.out.println(s.maxDepth(n1));
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
