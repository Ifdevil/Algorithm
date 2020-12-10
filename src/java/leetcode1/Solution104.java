package leetcode1;

public class Solution104 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        n5.right = n6;
        n6.right = n7;
        Solution104 s = new Solution104();
        System.out.println(s.maxDepth(n1));
    }

    int max = 0;
    public int maxDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        depth(root,0);
        return max;
    }
    
    private void  depth(TreeNode root,int count){
        if(null == root){
            max = Math.max(max,count);
            return;
        }
        count++;
        depth(root.left,count);
        depth(root.right,count);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
