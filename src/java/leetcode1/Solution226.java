package leetcode1;

public class Solution226 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        TreeNode treeNode = invertTree(n1);
        System.out.println(treeNode);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(null == root){
            return null;
        }
        TreeNode left = root.right != null ? invertTree(root.right) : null;
        TreeNode right = root.left != null ? invertTree(root.left) : null;
        root.left = left;
        root.right = right;
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
