package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution145 {

    public static void main(String[] args) {
        Solution145 s = new Solution145();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(s.postorderTraversal1(root).toArray()));
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(null == root){
            return result;
        }
        digui(root,result);
        return result;
    }
    
    public void digui(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }
        digui(root.left,result);
        digui(root.right,result);
        result.add(root.val);
    }

    /**
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(null == root){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.peek();
            if(root.right != null && root.right != pre){
                root = root.right;
            }else {
                stack.pop();
                result.add(root.val);
                pre = root;
                root = null;
            }
        }
        return result;
    }
    
}
