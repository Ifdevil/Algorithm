package leetcode1;

public class Solution98 {

    public static void main(String[] args) {
        Solution98 solution98 = new Solution98();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        System.out.println(solution98.isValidBST(root));
    }
    
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if(null == node){
            return true;
        }
        int val = node.val;
        if(lower != null && val <= lower){
            return false;
        }
        if(upper != null && val >= upper){
            return false;
        }
        if(!helper(node.left,lower,val)){
            return false;
        }
        if(!helper(node.right,val,upper)){
            return false;
        }
        return true;
    }
}
