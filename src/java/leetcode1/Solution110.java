package leetcode1;

public class Solution110 {


    public static void main(String[] args) {
        
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }else {
            return Math.abs(height(root.left)-height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }
    
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }else {
            return Math.max(height(root.left),height(root.right))+1;
        }
    }


    public boolean isBalanced1(TreeNode root) {
        return height1(root) > -1;
    }
    
    public int height1(TreeNode root){
        if(null == root){
            return 0;
        }
        int left = height1(root.left);
        int right = height1(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }else {
            return Math.max(left,right)+1;
        }
    }
}
