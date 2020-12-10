package leetcode1;

public class Solution701 {

    public static void main(String[] args) {
        
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(null == root){
            return new TreeNode(val);
        }
        TreeNode base = root;
        while (base != null){
            int value = base.val;
            if(value > val){
                if(base.left== null){
                    base.left = new TreeNode(val);
                    break;
                }else {
                    base = base.left;
                }
            }else {
                if(base.right == null){
                    base.right = new TreeNode(val);
                    break;
                }else {
                    base = base.right;
                }
            }
        }
        return root;
    }
}
